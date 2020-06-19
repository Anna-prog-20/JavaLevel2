import java.util.*;

public class PhoneBook{
    private String surname;
    private Integer phone;

    public PhoneBook(String surname, Integer phone) {
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return surname+" - "+phone;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPhone() {
        return phone;
    }
}
