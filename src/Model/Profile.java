package Model;

public class Profile {
    private Integer id_profile;
    private String name;

    public Profile() {
    }

    public Profile(Integer id_profile, String name) {
        this.id_profile = id_profile;
        this.name = name;
    }

    public Integer getId_profile() {
        return id_profile;
    }

    public void setId_profile(Integer id_profile) {
        this.id_profile = id_profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

