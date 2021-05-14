package models;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Milestone {

    private String name;
    private String description;
    private Timestamp timestamp;
    private int parentId;
    private String refs;
    private Timestamp startOn;

}
