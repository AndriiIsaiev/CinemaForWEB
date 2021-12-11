package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static void insertUser(User user) throws IOException {
        if (getUserByContent(user).size() == 0) {
            UniversalDAO.insertEntity("user", user);
        }
    }

    public static User getUserById(int id) throws IOException {
        return ((User) UniversalDAO.getEntityById("user", id, new User()));
    }

    public static List<User> getUserByContent(User user) throws IOException {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","email", "=", user.getEmail()));
        List<User> listUser = getUserByFilter(filter);
        return listUser;
    }

    public static List<User> getUserByFilter(List<Item> filter) throws IOException {
        return UserDAO.getUserBySQL("", filter, "");
    }

    public static List<User> getUserBySQL(String joinCondition, List<Item> whereCondition, String postCondition) throws IOException {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("user", joinCondition, whereCondition, postCondition, new User());
        ArrayList<User> listUser = new ArrayList<>();
        for (Entity en : listEntity) {
            listUser.add((User) en);
        }
        return listUser;
    }

    public static List<User> getAllUser() throws IOException {
        return getUserByFilter(new ArrayList<>());
    }

    public static void deleteUserById(int id) throws IOException {
        if (((Integer) id).equals(getUserById(id).getId())) {
            UniversalDAO.deleteEntityById("user", id);
        }
    }

    public static void updateUserByUser(User user) throws IOException {
        if (user.getId().equals(getUserById(user.getId()).getId())) {
            UniversalDAO.updateEntity("user", user);
        }
    }

}
