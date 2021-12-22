package repositories;

import model.Comment;
import model.ConnectionToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    private final ConnectionToDB connection = new ConnectionToDB();

    @Override
    public boolean saveComment(String text, String name, int consignment_id, int user_id) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "INSERT INTO comments (author_username, user_id, comment_text, consignment_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, user_id);
                preparedStatement.setString(3, text);
                preparedStatement.setInt(4, consignment_id);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Comment> getListCommentsByConsignmentsId(int id) {
        try (Connection conn = connection.getNewConnection()) {
        String sql = "SELECT author_username, comment_text, commentTimeOfCreate FROM comments WHERE consignment_id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return getConsignmentFromDB(preparedStatement);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }

    private List<Comment> getConsignmentFromDB(PreparedStatement preparedStatement) throws SQLException {
        LinkedList<Comment> arrayList = new LinkedList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setAuthorUsername(resultSet.getString("author_username"));
            comment.setCommentText(resultSet.getString("comment_text"));
            comment.setCommentTimeOfCreate(resultSet.getString("commentTimeOfCreate"));
            arrayList.addFirst(comment);
        }
        return arrayList;
    }
}
