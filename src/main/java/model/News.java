package model;

import lombok.Data;

import java.util.Random;

@Data
public class News {
    private int id;
    private String title;
    private String mainText;
    private String newsPicture;
    private int consignment_id;
}
