package lesson3;

import java.util.*;

public class SetofWords {
    private ArrayList<String> words = new ArrayList<>();

    public SetofWords(String... words) {
        for (String s : words
        ) {
            this.words.add(s);
        }
    }

    public void OutUniqueWords() {
        LinkedHashSet<String> set = new LinkedHashSet<>(this.words);
        System.out.println(set);
    }


    public void RepetiotionWords() {
        HashMap<String, Integer> hash = new HashMap<>();
        Integer item;

        for (String s : this.words
        ) {
            item = hash.get(s);
            if (item == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, item + 1);
            }

        }
        System.out.println(hash);

    }


}
