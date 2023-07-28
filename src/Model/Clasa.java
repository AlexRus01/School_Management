package Model;
import Model.Student;

import java.util.Vector;

public class Clasa {
    private Integer id_class;
    private Integer number;
    private Vector<Student> students = new Vector<Student>();

    Profile profil;

    public Clasa(Integer id_class, Integer number, Vector<Student> students,Profile profil) {
        this.id_class = id_class;
        this.number = number;
        this.students = students;
        this.profil = profil;
    }

    public void setProfil(Profile profil) {
        this.profil = profil;
    }

    public Profile getProfil() {
        return profil;
    }

    public Clasa(Integer id_class, Integer number) {
        this.id_class = id_class;
        this.number = number;
    }

    public Integer getId_class() {
        return id_class;
    }

    public void setId_class(Integer id_class) {
        this.id_class = id_class;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public void AfisareStudenti(){
        Integer i;
        for(i=0;i< students.size();i++)
            System.out.println(students.get(i).getFirstname());
    }
    public void setStudents(Vector<Student> students) {
        this.students = students;
    }

    public void AddStudent(Student x){
        students.add(x);
    }
}
