package com.example.microGram.work51;

import com.example.microGram.dao.UserDao;
import com.example.microGram.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@RequiredArgsConstructor


public class Service51 {

    private final DataBaseConnectivity dbService;
    private final UserDao userDao;

    private int executeUpdate(String query)throws SQLException {
        Statement statement = dbService.getConn().createStatement();
        return statement.executeUpdate(query);
    }

    private void createCustomerTable() throws SQLException {
        String createTablequery = "CREATE TABLE customers (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "age INTEGER)";
        String insertQuery = "INSERT INTO customers " +
                    "VALUES(73, 'Brian', 33)";

        executeUpdate(createTablequery);
        executeUpdate(insertQuery);
    }

    public String shouldCreateTable(){
        try {
            createCustomerTable();
            dbService.getConn().createStatement().execute("select * from customers");
            return "All is fine";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    public String shouldSelectData(){
        try {
            String query = "select * from customers " +
                    "where name = ?";
            PreparedStatement statement = dbService.getConn().prepareStatement(query);
            statement.setString(1, "Brian");

            if(statement.execute()){
//                return "All it is OK";
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                int age = resultSet.getInt("age");

                return String.format("Age: %s", age);
            }else {
                throw new SQLException();
            }
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    public void shouldResultSet()throws SQLException{
        Statement statement = dbService.getConn().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        ResultSet resultSet = statement.executeQuery("select * from customers");
        resultSet.updateLong("id", 3l);
        resultSet.updateString("name", "John");
        resultSet.updateInt("age", 18);
        resultSet.insertRow();
        resultSet.moveToCurrentRow();
    }

    public void create(User user) {
        userDao.save(user);
    }
}
