package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static void insertUser(User user) {
        if (getUserByContent(user).size() == 0) {
            UniversalDAO.insertEntity("user", user);
        }
    }

    public static User getUserById(int id) {
        return ((User) UniversalDAO.getEntityById("user", id, new User()));
    }

    public static List<User> getUserByContent(User user) {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","email", "=", user.getEmail()));
        List<User> listUser = getUserByFilter(filter);
        return listUser;
    }

    public static List<User> getUserByFilter(List<Item> filter) {
        return UserDAO.getUserBySQL("", filter, "");
    }

    public static List<User> getUserBySQL(String joinCondition, List<Item> whereCondition, String postCondition) {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("user", joinCondition, whereCondition, postCondition, new User());
        ArrayList<User> listUser = new ArrayList<>();
        for (Entity en : listEntity) {
            listUser.add((User) en);
        }
        return listUser;
    }

    public static List<User> getAllUser() {
        return getUserByFilter(new ArrayList<>());
    }

    public static void deleteUserById(int id) {
        if (((Integer) id).equals(getUserById(id).getId())) {
            UniversalDAO.deleteEntityById("user", id);
        }
    }

    public static void updateUserByUser(User user) {
        if (user.getId().equals(getUserById(user.getId()).getId())) {
            UniversalDAO.updateEntity("user", user);
        }
    }

}
