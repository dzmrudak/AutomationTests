package enums;

public enum ProjectType {

    SINGLE_FOR_ALL_CASES(1),
    SINGLE_FOR_WITH_BASELINE(2),
    MULTIPLE(3);

    private final int value;

    ProjectType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ProjectType getEnumByValue(int value) {
        for (ProjectType mod : ProjectType.values()) {
            if (mod.getValue() == value)
                return mod;
        }
        throw new IllegalArgumentException("No enum constant with value" + value);
    }

}