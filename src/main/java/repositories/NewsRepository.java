package repositories;

import model.News;

import java.util.List;

public interface NewsRepository {
    List<News> getAllNews();
    List<News> getNewsByConsignmentId(int consignment_id);
}
