package com.abi.cinema.db.dao;

import com.abi.cinema.db.connection.ConnectionManager;
import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.relation.Relation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversalDAO {

    private static final Logger log = LogManager.getLogger(UniversalDAO.class);

    public static boolean insertEntity(String table, Object ob) {
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return false;
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String psInsert = buildStringForInsert(table, ob);
        try (PreparedStatement ps = con.prepareStatement(psInsert, Statement.RETURN_GENERATED_KEYS);) {
            setQuestionMarkForInsert(ps, ob);
            if (ps.executeUpdate() != 1) {
                return false;
            }
            fillReturnGeneratedKey(ps,ob);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = ConnectionManager.takeBackConnection(con);
        }
        return true;
    }

    private static String buildStringForInsert(String table, Object ob) {
        StringBuilder sbInsert = new StringBuilder("INSERT INTO " + table + " VALUES (DEFAULT");
        for (int i = 1; i < ob.getClass().getDeclaredFields().length; i++ ) {
            sbInsert.append(", ?");
        }
        sbInsert.append(")");
        return sbInsert.toString();
    }

    private static void setQuestionMarkForInsert(PreparedStatement ps, Object ob) throws IllegalAccessException, SQLException {
        Field[] fields = ob.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            preparedStatementAppend(ps, i, fields[i].get(ob));
        }
    }

    private static void preparedStatementAppend(PreparedStatement ps, int number, Object fieldObject) throws SQLException {
        if (" ".getClass() == fieldObject.getClass()) {
            ps.setString(number, (String) fieldObject)   ;
            return;
        }
        if (Integer.valueOf(1).getClass() == fieldObject.getClass()) {
            ps.setInt(number, (Integer) fieldObject);
            return;
        }
        if (Timestamp.valueOf("2021-01-01 0:00:00").getClass() == fieldObject.getClass()) {
            ps.setTimestamp(number, (Timestamp) fieldObject);
            return;
        }
        if (Float.valueOf(0.0F).getClass() == fieldObject.getClass()) {
            ps.setFloat(number, (Float) fieldObject);
            return;
        }
        if (Time.valueOf("0:00:00").getClass() == fieldObject.getClass()) {
            ps.setTime(number, (Time) fieldObject);
            return;
        }
    }

    private static void fillReturnGeneratedKey(PreparedStatement ps, Object ob) throws SQLException, IllegalAccessException {
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            Field[] fields = ob.getClass().getDeclaredFields();
            fields[0].setAccessible(true);
            fields[0].set(ob,rs.getInt(1));
        }
    }

    public static Object getEntityById(String table, int id, Object ob) {
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return null;
        }
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM " + table + " WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    fillEntityFields(rs, ob);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException throwables) {
            throwables.printStackTrace();
        } finally {
            con = ConnectionManager.takeBackConnection(con);
        }
        return ob;
    }

    private static void fillEntityFields(ResultSet rs, Object ob) throws SQLException, IllegalAccessException {
        Field[] fields = ob.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fillOneField(rs, ob, i+1, fields[i]);
        }
    }

    private static void fillOneField(ResultSet rs, Object ob, int number, Field field) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        if (" ".getClass() == field.getType()) {
            field.set(ob,rs.getString(number));
            return;
        }
        if (Integer.valueOf(1).getClass() == field.getType()) {
            field.set(ob,rs.getInt(number));
            return;
        }
        if (Timestamp.valueOf("2021-01-01 0:00:00").getClass() == field.getType()) {
            field.set(ob,rs.getTimestamp(number));
            return;
        }
        if (Float.valueOf(0.0F).getClass() == field.getType()) {
            field.set(ob,rs.getFloat(number));
            return;
        }
        if (Time.valueOf("0:00:00").getClass() == field.getType()) {
            field.set(ob,rs.getTime(number));
            return;
        }
    }

    public static List<Entity> getEntityBySQL(String table, String joinCondition, List<Item> whereCondition, String postCondition, Entity en) {
        List<Entity> lo = new ArrayList<>();
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return null;
        }
        String psSelect = buildStringForSelect(table, joinCondition, whereCondition, postCondition);
        try (PreparedStatement ps = con.prepareStatement(psSelect);) {
            setQuestionMarkForSelect(ps, whereCondition);
            System.out.println(ps);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    fillEntityFields(rs, en);
                    lo.add(en.clone());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException throwables) {
            throwables.printStackTrace();
        } finally {
            con = ConnectionManager.takeBackConnection(con);
        }
        return lo;
    }

    private static String buildStringForSelect(String table, String joinCondition, List<Item> filter, String postCondition) {
        StringBuilder sbSelect = new StringBuilder("SELECT " + table + ".* FROM " + table + joinCondition);
        if (filter.size() != 0) {
            sbSelect.append(" WHERE ");
            for (int i = 0; i < filter.size(); i++) {
                if (i > 0) {
                    sbSelect.append(" " + filter.get(i).getLogic());
                }
                sbSelect.append(" "+ filter.get(i).getName() + " " + filter.get(i).getOper() +  " ?");
            }
        }
        sbSelect.append(postCondition);
        return sbSelect.toString();
    }

    private static void setQuestionMarkForSelect(PreparedStatement ps, List<Item> filter) throws SQLException {
        for (int i = 0; i < filter.size(); i++) {
            preparedStatementAppend(ps, i + 1, filter.get(i).getValue());
        }
    }

    public static boolean deleteEntityById(String table, int id) {
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return false;
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM " + table + " WHERE id=?")) {
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = ConnectionManager.takeBackConnection(con);
        }
        return true;
    }

    public static boolean updateEntity(String table, Object ob) {
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return false;
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String psInsert = buildStringForUpdate(table, ob);
        try (PreparedStatement ps = con.prepareStatement(psInsert, Statement.RETURN_GENERATED_KEYS);) {
            setQuestionMarkForUpdate(ps, ob);
            if (ps.executeUpdate() != 1) {
                return false;
            }
            fillReturnGeneratedKey(ps,ob);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = ConnectionManager.takeBackConnection(con);
        }
        return true;
    }

    private static String buildStringForUpdate(String table, Object ob) {
        Field[] fields = ob.getClass().getDeclaredFields();
        StringBuilder sbUpdate = new StringBuilder("UPDATE " + table + " SET ");
        for (int i = 1; i < fields.length; i++ ) {
            String fname = fields[i].getName();
            if (i > 1) {
                sbUpdate.append(", ");
            }
            sbUpdate.append(fname + " = ?");
        }
        sbUpdate.append(" WHERE id=?");
        return sbUpdate.toString();
    }

    private static void setQuestionMarkForUpdate(PreparedStatement ps, Object ob) throws IllegalAccessException, SQLException {
        Field[] fields = ob.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            preparedStatementAppend(ps, i, fields[i].get(ob));
        }
        fields[0].setAccessible(true);
        preparedStatementAppend(ps, fields.length, fields[0].get(ob));
    }

    public static boolean insertRelation(String table, Object ob) {
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return false;
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String psInsert = buildStringForInsertRelation(table, ob);
        try (PreparedStatement ps = con.prepareStatement(psInsert);) {
            setQuestionMarkForInsertRelation(ps, ob);
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = ConnectionManager.takeBackConnection(con);
        }
        return true;
    }

    private static String buildStringForInsertRelation(String table, Object ob) {
        StringBuilder sbInsert = new StringBuilder("INSERT INTO " + table + " VALUES (");
        for (int i = 1; i <= ob.getClass().getDeclaredFields().length; i++ ) {
            if (i > 1) {
                sbInsert.append(",");
            }
            sbInsert.append(" ?");
        }
        sbInsert.append(")");
        return sbInsert.toString();
    }

    private static void setQuestionMarkForInsertRelation(PreparedStatement ps, Object ob) throws IllegalAccessException, SQLException {
        Field[] fields = ob.getClass().getDeclaredFields();
        for (int i = 1; i <= fields.length; i++) {
            fields[i - 1].setAccessible(true);
            preparedStatementAppend(ps, i, fields[i - 1].get(ob));
        }
    }

    public static List<Relation> getRelationByFilter(String table, List<Item> filter, Relation ob) {
        List<Relation> lo = new ArrayList<>();
        Connection con = ConnectionManager.giveMeConnection();
        if (con == null) {
            return null;
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String psSelect = buildStringForSelect(table, "", filter, "");
        try (PreparedStatement ps = con.prepareStatement(psSelect);) {
            setQuestionMarkForSelect(ps, filter);
            System.out.println(psSelect);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    fillEntityFields(rs, ob);
                    lo.add(ob.clone());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = ConnectionManager.takeBackConnection(con);
        }
        return lo;
    }

}
