package com.abi.cinema.db.dao;

import java.io.IOException;

public class DAOException extends IOException {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}

