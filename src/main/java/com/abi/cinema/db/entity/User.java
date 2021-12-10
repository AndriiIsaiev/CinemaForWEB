package com.abi.cinema.db.entity;

public class User extends Entity {
    private Integer id;
    private String email;
    private String createTime;
    private String password;
    private Integer role;
    private String name;
    private String surname;
    private String phone;
    private Integer mailing;

    public User() {
    }

    public User(String email, String createTime, String password, Integer role, String name, String surname, String phone, Integer mailing) {
        this.email = email;
        this.createTime = createTime;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mailing = mailing;
    }

    public User(Integer id, String email, String createTime, String password, Integer role, String name, String surname, String phone, Integer mailing) {
        this.id = id;
        this.email = email;
        this.createTime = createTime;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mailing = mailing;
    }

    public User(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.createTime = user.createTime;
        this.password = user.password;
        this.role = user.role;
        this.name = user.name;
        this.surname = user.surname;
        this.phone = user.phone;
        this.mailing = user.mailing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMailing() {
        return mailing;
    }

    public void setMailing(Integer mailing) {
        this.mailing = mailing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(((User) o).email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return id + " " + email + " " + password + " " + role + " " + name + " " + surname;
    }

    @Override
    public User clone() {
        return new User(this);
    }

}