import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private Date dob;           // store as Date
    private String heardFrom;
    private String wantsUpdates;
    private String emailOK;
    private String contactVia;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dob = null;
        heardFrom = "";
        wantsUpdates = "";
        emailOK = "";
        contactVia = "";
    }

    // --- Getters and Setters ---
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getHeardFrom() { return heardFrom; }
    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    public String getWantsUpdates() { return wantsUpdates; }
    public void setWantsUpdates(String wantsUpdates) { this.wantsUpdates = wantsUpdates; }

    public String getEmailOK() { return emailOK; }
    public void setEmailOK(String emailOK) { this.emailOK = emailOK; }

    public String getContactVia() { return contactVia; }
    public void setContactVia(String contactVia) { this.contactVia = contactVia; }
}
