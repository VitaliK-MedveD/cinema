package medved.main.model;

import medved.main.util.Menu;

import java.time.LocalDate;

public class Person {

    private Long id;
    private String access;
    private String username;
    private String password;
    private String lastAndFirstName;
    private String email;
    private String dateBirthday;
    private String dateCreated = LocalDate.now().toString();

    public Person() {
    }

    public Person(String access, String username, String password, String lastAndFirstName, String email,
                  String dateBirthday, String dateCreated) {
        this.access = access;
        this.username = username;
        this.password = password;
        this.lastAndFirstName = lastAndFirstName;
        this.email = email;
        this.dateBirthday = dateBirthday;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastAndFirstName() {
        return lastAndFirstName;
    }

    public void setLastAndFirstName(String lastAndFirstName) {
        this.lastAndFirstName = lastAndFirstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", access='" + access + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastAndFirstName='" + lastAndFirstName + '\'' +
                ", email='" + email + '\'' +
                ", dateBirthday='" + dateBirthday + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
