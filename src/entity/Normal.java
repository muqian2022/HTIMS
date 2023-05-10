package entity;

public class Normal{
    private int normalId;
    private String password;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;

    public Normal(){
    }

    public Normal(int normalId, String password, String name, String gender, String phoneNumber, String address) {
        this.normalId = normalId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getNormalId() {
        return normalId;
    }

    public void setNormalId(int normalId) {
        this.normalId = normalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
