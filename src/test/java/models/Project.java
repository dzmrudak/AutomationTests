package models;

import com.google.gson.annotations.SerializedName;
import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
public class Project {

    @EqualsAndHashCode.Exclude int id;
    private String name;
    private String announcement;
    @SerializedName(value = "show_announcement")
    boolean showAnnouncement;
    @SerializedName(value = "suite_mode")
    private int type;

}
