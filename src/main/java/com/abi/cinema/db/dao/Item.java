package com.abi.cinema.db.dao;

public class Item {
    private String logic;
    private String name;
    private String oper;
    private Object value;

    public Item(String logic, String name, String oper, Object value) {
        this.logic = logic;
        this.name = name;
        this.oper = oper;
        this.value = value;
    }

    public String getLogic() { return logic; }
    public void setLogic(String logic) { this.logic = logic; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOper() { return oper; }
    public void setOper(String oper) { this.oper = oper; }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
