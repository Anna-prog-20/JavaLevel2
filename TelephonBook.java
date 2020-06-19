import java.util.LinkedList;
import java.util.List;

public class TelephonBook {
    List <PhoneBook> phoneBookList=new LinkedList<>();

    public void add(String surname, Integer phone){
        phoneBookList.add(new PhoneBook(surname,phone));
    }
    public void get(String findSurname) {
        for (int i=0;i<phoneBookList.size();i++) {
            if (phoneBookList.get(i).getSurname()==findSurname){
                System.out.println(phoneBookList.get(i).getSurname()+" - "+phoneBookList.get(i).getPhone());
            }
        }
    }

    @Override
    public String toString() {
        return phoneBookList.toString();
    }
}
