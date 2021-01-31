package myrelations.myrelationstessdemo.mix.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import myrelations.myrelationstessdemo.manytomany.entitiy.Role;
import myrelations.myrelationstessdemo.manytomany.model.RoleModel;
import myrelations.myrelationstessdemo.onetomany.model.Library;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "from_lib")
public class FromLib {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobile;

    @Column(unique = true)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Library library;


    @ManyToMany(targetEntity = GetFrom.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    private List<GetFrom> getFromList;

    public List<GetFrom> getGetFromList() {
        return getFromList;
    }

    public void setGetFromList(List<GetFrom> getFromList) {
        this.getFromList = getFromList;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
