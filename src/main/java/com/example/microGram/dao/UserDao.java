package com.example.microGram.dao;

import com.example.microGram.entity.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


    public List<User> index(){
        List<User> user = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM User";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                User user1 = new User("", "", 3, 4, "", 7);

                user1.setId(resultSet.getInt("id"));
                user1.setAccountName(resultSet.getString("name"));
                user1.setEmail(resultSet.getString("email"));
                user1.setAge(resultSet.getInt("age"));

                user.add(user1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public User show(int id){
        User user = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM User WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User("","",0, 0, "", 0);

            user.setId(resultSet.getInt("id"));
            user.setAccountName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public User save(User user){

        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO User VALUES(1, ?, ?, ?)");

            PreparedStatement.setString(1, user.getAccountName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }

    public void update(int id, User updateUser){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE User SET accountName=?, age=?, email=? WHERE id=?");

            PreparedStatement.setString(1, updateUser.getAccountName());
            preparedStatement.setInt(2, updateUser.getAge());
            preparedStatement.setString(3, updateUser.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM User WHERE id=?");
            PreparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
