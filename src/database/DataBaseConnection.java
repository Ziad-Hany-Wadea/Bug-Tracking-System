package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class DataBaseConnection {

    protected final String DRIVER_CLASS, URL;
    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    protected int rs;

    public DataBaseConnection() {
        this.DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.URL = "jdbc:sqlserver://DESKTOP-PS6M8QD;databaseName=PL2;integratedSecurity=true;encrypt=false";
        this.connection = null;
        this.resultSet = null;
        this.statement = null;
        this.rs = 0;
    }

    private Connection getConnection() {
        try {
            Class.forName(this.DRIVER_CLASS);
            this.connection = DriverManager.getConnection(this.URL);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
        }
        return this.connection;
    }

    public Statement setStatement() {
        try {
            this.statement = getConnection().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
        }

        return this.statement;
    }

}
