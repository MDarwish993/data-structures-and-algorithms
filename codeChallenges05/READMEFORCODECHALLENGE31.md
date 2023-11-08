# Challenge 31
#### find First Repeated Word.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc31.jpg "/>

### - Initial findFirstRepeatedWord Method:
- Arguments: String.
- Return: String.
## Solution
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