package models;

import enums.testCaseAttributes.Priority;
import enums.testCaseAttributes.Section;
import enums.testCaseAttributes.Template;
import enums.testCaseAttributes.Type;

public class TestCase {

    private String title;
    private Priority priority;
    private Section section;
    private Template template;
    private Type type;

    public TestCase(String title, Section section, Template template, Type type, Priority priority) {
        this.title = title;
        this.section = section;
        this.template = template;
        this.type = type;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "title='" + title + '\'' +
                ", section=" + section +
                ", template=" + template +
                ", type=" + type +
                ", priority=" + priority +
                '}';
    }
}
