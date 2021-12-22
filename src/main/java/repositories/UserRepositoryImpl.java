package repositories;

import model.ConnectionToDB;
import model.User;
import model.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private final ConnectionToDB connection = new ConnectionToDB();
    private final UserService userService = new UserService();

    @Override
    public boolean saveUser(String username, String password) {
        User user = userService.enrollUser(username, password);
        if (user == null) {
            return false;
        }
        try (Connection conn = connection.getNewConnection()) {
            String sql = "INSERT INTO users (username, password) values (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int getUserId(String username) {
        User user = getUserByName(username);
        if (user != null) {
            return user.getId();
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public User getUserByID(int id) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT id, username, password, createDateTime FROM users where id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                return getUserFromDB(preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT id, username, password, createDateTime FROM users where username = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                return getUserFromDB(preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean userIsExist(String username, String password) {
        User user = userService.enrollUser(username, password);
        if (user == null) {
            return false;
        }
            try (Connection conn = connection.getNewConnection()) {
                String sql = "SELECT id, username, password, createDateTime FROM users where username = ? AND password = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getPassword());
                    if (getUserFromDB(preparedStatement) != null) {
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }

    private User getUserFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setCreateDateTime(resultSet.getTimestamp("createDateTime"));
            return user;
        }
        return null;
    }
}
