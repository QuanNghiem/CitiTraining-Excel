package excel;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private List<Subject> subjects = new ArrayList<Subject>();
    private Double totalPercentage;

    public Student() {
    }

    public Student(Integer id, String name, Math math, Science science, Language language) {
        this.id = id;
        this.name = name;
        this.subjects.add(math);
        this.subjects.add(science);
        this.subjects.add(language);
        this.getPercentage();
    }

    private void getPercentage() {
        Double result = 0.0;
        for (Subject subject : subjects) {
            result += subject.getValue();
        }
        setTotalPercentage(result / subjects.size());
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPercentage() {
        return this.totalPercentage;
    }

    public void setTotalPercentage(Double totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    @Override
    public int compareTo(Student student) {
        return -1 * (int) (this.getTotalPercentage() - student.getTotalPercentage());
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", Math='"
                + this.subjects.get(0).getValue() + "'" + ", Science='" + this.subjects.get(1).getValue() + "'"
                + ", Language='" + this.subjects.get(2).getValue() + "'" + ", totalPercentage='" + getTotalPercentage()
                + "'" + "}";
    }
}
