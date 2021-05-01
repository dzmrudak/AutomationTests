package models;

import enums.ProjectType;

public class Project {

    private String name;
    private String announcement;
    boolean isShowAnnouncement;
    private ProjectType type;

    public Project() {
    }

    public Project(String name, String announcement, boolean isShowAnnouncement, ProjectType type) {
        this.name = name;
        this.announcement = announcement;
        this.isShowAnnouncement = isShowAnnouncement;
        this.type = type;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        isShowAnnouncement = showAnnouncement;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", isShowAnnouncement=" + isShowAnnouncement +
                ", type=" + type +
                '}';
    }
}
