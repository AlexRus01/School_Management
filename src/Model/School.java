package Model;

public class School {
    private Integer id_school;
    private String name;

    public School(){

    }

    public School(Integer id_sc, String nume){
        this.id_school = id_sc;
        this.name = nume;
    }

    public Integer getId_school() {
        return id_school;
    }

    public void setId_school(Integer id_school) {
        this.id_school = id_school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
