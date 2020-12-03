package excel;

public class Subject implements SubjectInterface {
    private Double value;

    public Subject(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
