package data;

public enum Data {

    EN("Valentin"),
    RU("Валентин");
    private final String Name;

    Data(String name) {
        Name = name;
    }
    public String getName() {
        return Name;

    }
}
