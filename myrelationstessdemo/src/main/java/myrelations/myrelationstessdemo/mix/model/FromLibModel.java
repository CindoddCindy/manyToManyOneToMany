package myrelations.myrelationstessdemo.mix.model;

import myrelations.myrelationstessdemo.manytomany.model.RoleModel;

import java.util.List;

public class FromLibModel {
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;

    private List<GetFromModel> getFromModels;

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

    public List<GetFromModel> getGetFromModels() {
        return getFromModels;
    }

    public void setGetFromModels(List<GetFromModel> getFromModels) {
        this.getFromModels = getFromModels;
    }
}
