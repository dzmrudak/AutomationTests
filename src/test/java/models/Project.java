package models;

import enums.ProjectType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String name;
    private String announcement;
    boolean isShowAnnouncement;
    private ProjectType type;
}
