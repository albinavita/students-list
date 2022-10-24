package enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика");

    private String title;

    StudyProfile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
