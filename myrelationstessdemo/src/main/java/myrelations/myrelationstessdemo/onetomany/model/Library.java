package myrelations.myrelationstessdemo.onetomany.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
