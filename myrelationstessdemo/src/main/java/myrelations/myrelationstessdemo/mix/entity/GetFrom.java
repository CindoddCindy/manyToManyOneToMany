package myrelations.myrelationstessdemo.mix.entity;

import myrelations.myrelationstessdemo.manytomany.entitiy.User;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "get_from")

public class GetFrom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(targetEntity = User.class, mappedBy = "getFrom", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<FromLib> fromLibs;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<FromLib> getFromLibs() {
        return fromLibs;
    }

    public void setFromLibs(List<FromLib> fromLibs) {
        this.fromLibs = fromLibs;
    }
}
