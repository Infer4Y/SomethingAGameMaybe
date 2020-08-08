package inferno.sgle.internet;

public class Data {
    protected String name;
    protected String value;

    public Data(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name+"="+value;
    }
}
