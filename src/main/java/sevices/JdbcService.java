package sevices;

import org.testng.log4testng.Logger;

import java.sql.*;

public class JdbcService {

    static Logger logger = Logger.getLogger(JdbcService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PSW = "1111";

    Connection connection = null;
    Statement statement;

    public JdbcService() {
        logger.info("Setup connection to Postgres DB.");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Postgres JDBC Driver is not found");
            logger.error(e.getMessage());
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PSW);
        } catch (SQLException e) {
            logger.error("Connection is failed");
            logger.error(e.getMessage());
            return;
        }

        if (connection != null) {
            logger.info("You successfully connected to db");
        } else {
            logger.info("Failed to connect to db");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            logger.info("Connection closed successfully");
        } catch (SQLException throwable) {
            logger.error("Can not close connection");
            logger.error(throwable.getMessage());
        }
    }

    public Statement getStatement() {
        try {
            if (statement == null) {

                statement = connection.createStatement();
            }
        } catch (SQLException ex) {

            logger.error("Statement creation failed");
            logger.error(ex.getMessage());
        }
        return statement;
    }

    public void closeStatement() {
        try{
            statement.close();
        } catch (SQLException exception) {
            logger.error("Statement can not be closed");
            logger.error(exception.getMessage());
        }
    }

    public void executeSQL(String sql) {
        try{
            getStatement().execute(sql);
        } catch (SQLException exception) {
            logger.error(exception.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try{
            resultSet = getStatement().executeQuery(sql);
            logger.info("SQL: " + sql + " has been executed");
        } catch (SQLException exception) {
            logger.error(exception.getMessage());
        }
        return resultSet;
    }
}
