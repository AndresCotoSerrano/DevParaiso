package retoprogramathon2018.devparaiso.domain;


public class Attendant {

    private int userCount ;
    private String attendantName;
    private String attendantLastName;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String password;

    public Attendant(int userCount, String attendantName, String attendantLastName, String idNumber, String phoneNumber, String email, String password) {
        this.userCount = userCount;
        this.attendantName = attendantName;
        this.attendantLastName = attendantLastName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Attendant() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public String getAttendantLastName() {
        return attendantLastName;
    }

    public void setAttendantLastName(String attendantLastName) {
        this.attendantLastName = attendantLastName;
    }
}
