package repositories;

import model.ConnectionToDB;
import model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository {

    private final ConnectionToDB connection = new ConnectionToDB();

    @Override
    public List<News> getAllNews() {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT title, mainText, newsPicture FROM news";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                return getNewsFromDB(preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<News> getNewsByConsignmentId(int consignment_id) {
        try (Connection conn = connection.getNewConnection()) {
            String sql = "SELECT title, mainText, newsPicture FROM news WHERE consignment_id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, consignment_id);
                return getNewsFromDB(preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<News> getNewsFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        LinkedList<News> listNews = new LinkedList<>();
        while (resultSet.next()) {
            News news = new News();
            news.setMainText(resultSet.getString("mainText"));
            news.setNewsPicture(resultSet.getString("newsPicture"));
            news.setTitle(resultSet.getString("title"));
            listNews.addFirst(news);
        }
        return listNews;

    }
}
