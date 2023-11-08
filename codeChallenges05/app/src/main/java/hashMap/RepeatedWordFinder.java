package hashMap;

import java.util.HashMap;

public class RepeatedWordFinder {
    public String findFirstRepeatedWord(String input) {
        String[] words = input.split("\\s+");


        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();

            if (wordCount.containsKey(lowercaseWord)) {
                return lowercaseWord;
            } else {
                wordCount.put(lowercaseWord, 1);
            }
        }


        return null;
    }

}
