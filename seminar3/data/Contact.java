package seminar3.data;

public class Contact
{
    private int contactId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Long phone;
    private String date;
    private String sex;


    public Contact(String[] msg) {
        this.firstName = msg[0];
        this.lastName = msg[1];
        this.fatherName = msg[2];
        this.phone = Long.valueOf(msg[3]);
        this.date = msg[4];
        this.sex = msg[5];
    }

    public Contact(int contactId, String firstName, String lastName, String fatherName, String date, Long phone, String sex) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.phone = phone;
        this.date = date;
        this.sex = sex;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = (phone);
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getSex() {return sex; }

    public void setSex(String sex) {this.sex = sex; }

    @Override
    public String toString() {
        return "Контакт: {" + "ID= " + contactId + ", Фамилия: " + firstName + ", Имя: " + lastName + ", Отчество: " + fatherName + ", Телефон: " + phone + ", Дата: " + date + ", Пол: " + sex + "}\n";
    }
}