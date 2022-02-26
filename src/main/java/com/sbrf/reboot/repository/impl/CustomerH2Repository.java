package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {
    /**
     * CREDENTIALS
     */
    private final String CREDENTIALS_USER = "sa";
    private final String CREDENTIALS_PASS = "";

    /**
     * CONNECTIONS SETTINGS
     */
    private final String SETTING_JDBC_DRIVER = "org.h2.Driver";
    private final String SETTING_DB_URL = "jdbc:h2:~/my_db";
    private final String SETTING_DB_NAME = "CUSTOMER";

    /**
     * SCHEMA
     */
    private final String ID = "id";
    private final String NAME = "name";
    private final String EMAIL = "eMail";

    /**
     * QUERIES
     */
    private final String QUERY_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS CUSTOMERS " +
            "(id BIGINT AUTO_INCREMENT PRIMARY KEY, name MEDIUMTEXT, eMail VARCHAR(30))";
    private final String QUERY_INSERT = String.format("INSERT INTO CUSTOMERS (%s, %s) VALUES(?, ?)", NAME, EMAIL);
    private final String QUERY_SELECT = String.format("SELECT %s, %s, %s FROM CUSTOMERS", ID, NAME, EMAIL);
    private final String QUERY_DROP = "DROP TABLE CUSTOMERS";

    /**
     * QUERIES PARAMS
     */
    private final int PARAM_INSERT_NAME = 1;
    private final int PARAM_INSERT_EMAIL = 2;

    public CustomerH2Repository() {
        try {
            connection = DriverManager.getConnection(SETTING_DB_URL, CREDENTIALS_USER, CREDENTIALS_PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate(QUERY_CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;
    @Override
    public boolean createCustomer(String name, String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(PARAM_INSERT_NAME, name);
            preparedStatement.setString(PARAM_INSERT_EMAIL, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> toReturn = new ArrayList<>();

        try {
            Statement connectionStatement = connection.createStatement();
            ResultSet execResult = connectionStatement.executeQuery(QUERY_SELECT);
            while (execResult.next()) {
                toReturn.add(new Customer(execResult.getLong(ID), execResult.getString(NAME), execResult.getString(EMAIL)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
