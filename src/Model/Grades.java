package Model;

public class Grades {
    private Student student;
    private Subject subject;
    private Integer grade;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Grades(Student student, Subject subject, Integer grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public void afisnota(){
        System.out.println("Studentul " + getStudent().getFirstname() + " are nota " + this.grade + " la materia " + this.subject.getName());
    }
}
