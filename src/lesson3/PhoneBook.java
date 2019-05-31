package lesson3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, String> phonebook = new HashMap<>();

    public PhoneBook() {

    }

    public void add(String name, String phone) {
        if (this.phonebook.get(name) == null) {
            this.phonebook.put(name, phone);
        } else {
            String str = this.phonebook.get(name).concat(" ").concat(phone);
            this.phonebook.put(name, str);
        }

    }

    public String get (String name){
        return (this.phonebook.get(name));
    }


    public void WriteAllPhonebook() {
        System.out.println(this.phonebook);
    }


}
