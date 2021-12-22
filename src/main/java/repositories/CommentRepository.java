package repositories;

import model.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> getListCommentsByConsignmentsId(int id);
    boolean saveComment(String text, String name, int consignment_id, int user_id);
}
