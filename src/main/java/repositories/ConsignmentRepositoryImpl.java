package repositories;

import model.ConnectionToDB;
import model.Consignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsignmentRepositoryImpl implements ConsignmentRepository {

    private final ConnectionToDB connection = new ConnectionToDB();

    @Override
    public Consignment getConsignmentById(int id) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT id, name, leader, text, image FROM consignments WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                return getConsignmentFromDB(preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Consignment getConsignmentFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Consignment consignment = new Consignment();
            consignment.setId(resultSet.getInt("id"));
            consignment.setName(resultSet.getString("name"));
            consignment.setLeaderImage(resultSet.getString("leader"));
            consignment.setImage(resultSet.getString("image"));
            consignment.setText(resultSet.getString("text"));
            return consignment;
        }
        return null;
    }
}
