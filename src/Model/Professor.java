package Model;

public class Professor extends Person{
    private Integer experience;

    private Subject subject;

    public Professor (){}

    public Professor(Integer experience) {
        this.experience = experience;
    }

    public Professor(Integer experience, Subject subject) {
        this.experience = experience;
        this.subject = subject;
    }

    public Professor(Integer id_person, String firstname, String lastname, Integer age, Address adresa, Integer experience, Subject subject) {
        super(id_person, firstname, lastname, age, adresa);
        this.experience = experience;
        this.subject = subject;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
