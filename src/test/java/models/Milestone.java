package models;

import java.sql.Timestamp;

public class Milestone {

    private String name;
    private String description;
    private Timestamp timestamp;
    private int parentId;
    private String refs;
    private Timestamp startOn;

    public Milestone() {
    }

    public Milestone(String name, String description, Timestamp timestamp, int parentId, String refs, Timestamp startOn) {
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.parentId = parentId;
        this.refs = refs;
        this.startOn = startOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getRefs() {
        return refs;
    }

    public void setRefs(String refs) {
        this.refs = refs;
    }

    public Timestamp getStartOn() {
        return startOn;
    }

    public void setStartOn(Timestamp startOn) {
        this.startOn = startOn;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", parentId=" + parentId +
                ", refs='" + refs + '\'' +
                ", startOn=" + startOn +
                '}';
    }
}
