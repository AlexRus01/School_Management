package Model;

public abstract class Person {
    private Integer id_person;
    private String firstname;
    private String lastname;
    private Integer age;
    private Address adresa;

    public Person(){
    }
    public Person(Integer id_person, String firstname, String lastname, Integer age, Address adresa) {
        this.id_person = id_person;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.adresa = adresa;
    }

    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAdresa() {
        return adresa;
    }

    public void setAdresa(Address adresa) {
        this.adresa = adresa;
    }
}
