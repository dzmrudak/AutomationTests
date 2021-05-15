package models;

import enums.testCaseAttributes.Priority;
import enums.testCaseAttributes.Section;
import enums.testCaseAttributes.Template;
import enums.testCaseAttributes.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    private String title;
    private Section section;
    private Template template;
    private Type type;
    private Priority priority;

}
