package lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class SetOfWords {
    private ArrayList<String> words = new ArrayList<>();

    public SetOfWords(String[] wordsarr) {
        words.addAll(Arrays.asList(wordsarr));

    }

    public void outUniqueWords() {
        Set<String> set = new LinkedHashSet<>(this.words);
        System.out.println(set);
    }


    public void repOnWords() {
        Map<String, Integer> hash = new LinkedHashMap<>();
        Integer item = null;

        for (String s : this.words
        ) {
            hash.merge(s, 1, (a, b) -> a + b);

        }
        System.out.println(hash);

    }


}
