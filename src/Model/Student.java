package Model;

public class Student extends Person{
    private boolean scholarship;

    private Integer id_class;

    public Student() {}

    public Student(boolean scholarship, Integer id_class) {
        this.scholarship = scholarship;
        this.id_class = id_class;
    }

    public Student(Integer id_person, String firstname, String lastname, Integer age, Address adresa, boolean scholarship, Integer id_class) {
        super(id_person, firstname, lastname, age, adresa);
        this.scholarship = scholarship;
        this.id_class = id_class;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public Integer getId_class() {
        return id_class;
    }

    public void setId_class(Integer id_class) {
        this.id_class = id_class;
    }
}
