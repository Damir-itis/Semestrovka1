package model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private int id;
    private String authorUsername;
    private String commentText;
    private String commentTimeOfCreate;
}
