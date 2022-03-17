package com.example.myapplication.Supportive;




import java.util.List;

public class TokenInfo {

    @SerializedName()
    @Expose
    private String tokenType;
    @SerializedName()
    @Expose
    private Integer exp;
    @SerializedName()
    @Expose
    private String jti;
    @SerializedName()
    @Expose
    private String username;

    @SerializedName()
    @Expose
    private List<Object> groups = null;

    @SerializedName()
    @Expose
    private Boolean isSuperuser;
    @SerializedName()
    @Expose
    private String firstName;
    @SerializedName()
    @Expose
    private String lastName;
    @SerializedName()
    @Expose
    private Boolean isStaff;
    @SerializedName()
    @Expose
    private Boolean isActive;
    @SerializedName()
    @Expose
    private String email;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
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

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
