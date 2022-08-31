package com.digitalhouse.clinicaodontologicag6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String user;
    private String pwd;

    public ConfigJDBC(String jdbcDriver, String dbUrl, String user, String pwd) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public void reset() throws SQLException {
        String tmp = this.dbUrl;
        this.dbUrl += "DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        Connection connection = conectarBD();
        connection.close();
        this.dbUrl = tmp;
    }

    public ConfigJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test;";
        this.user = "sa";
        this.pwd = "";
    }

    public Connection conectarBD() {
        Connection connection = null;

        try {
            Class.forName(jdbcDriver).newInstance();
            connection = DriverManager.getConnection(dbUrl, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
