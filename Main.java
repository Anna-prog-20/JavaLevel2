import java.util.*;

public class Main {

    public static void main(String[] args) {
        setWords();
        actionsPhoneBook();
    }
    public static void setWords(){
        System.out.println("Первое задание:Находим, выводим и считаем");
        List <String> words=new ArrayList();
        words.add("Волк");
        words.add("Лиса");
        words.add("Белка");
        words.add("Медведь");
        words.add("Заяц");
        words.add("Белка");
        words.add("Лошадь");
        words.add("Кролик");
        words.add("Белка");
        words.add("Медведь");
        words.add("Заяц");
        words.add("Рыба");

        printUniqueList(words);

    }
    public static void printUniqueList(List <String> words){
        List <String> words1=new ArrayList();
        words1.add(words.get(0));
        for(int i=0;i<words.size();i++){
                if (!words1.contains(words.get(i)))
                    words1.add(words.get(i));
        }
        System.out.println(words1.toString());
        accountList(words,words1);
    }
    public static void accountList(List <String> words,List <String> words1){
        Map<String,Integer> countList=new HashMap<>();
        int k=1;
        for(int j=0;j<words1.size();j++){
            for(int i=0;i<words.size();i++) {
                if (words1.get(j)==words.get(i)) {
                   countList.put(words1.get(j), k++);
                }
            }
            k=1;
        }
        System.out.println(countList.toString());
    }

    public static void actionsPhoneBook(){
        System.out.println("Второе задание:телефонный справочник");
        TelephonBook telephonBook=new TelephonBook();
        telephonBook.add("Васечкин",546648);
        telephonBook.add("Петечкин",5648);
        telephonBook.add("Васечкин",8846569);
        System.out.println(telephonBook.toString());
        telephonBook.get("Васечкин");
    }


}
