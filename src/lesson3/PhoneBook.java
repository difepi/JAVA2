package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    private HashMap<String, Set<String>> phonebook = new HashMap<>();


    public void add(String name, String phone) {

        if (this.phonebook.get(name) == null) {
            Set<String> phoneset = new HashSet<>();
            phoneset.add(phone);
            this.phonebook.put(name, phoneset);
        } else {
            Set<String> phoneset = new HashSet<>(this.phonebook.get(name));
            phoneset.add(phone);
            this.phonebook.put(name, phoneset);
        }

    }

    public Set<String> get(String name) {
        return (this.phonebook.get(name));
    }


    public void WriteAllPhonebook() {
        System.out.println(this.phonebook);
    }


}
