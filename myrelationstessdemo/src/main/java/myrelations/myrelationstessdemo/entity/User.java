package myrelations.myrelationstessdemo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import myrelations.myrelationstessdemo.model.Library;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

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


    @ManyToMany(targetEntity = Role.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
