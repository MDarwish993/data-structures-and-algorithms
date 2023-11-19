# Challenge LEFT JOIN
## Problem Domain
In this problem domain, we are tasked with  implements a basic HashMap with additional functionality for a left join operation on two hash maps containing synonyms and antonyms.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc33.jpg "/>

## - Algorithms:
1. **Initialize the Result List**
    - Create an empty list called `results` to hold the resulting joined values.

2. **Iterate through the Keys of the Synonyms HashMap**
    - For each key in the `synonyms` hashmap:
        - Create a new list called `row` to hold the values for the current key.
        - Add the key to the `row` list.

3. **Get Synonym Value**
    - Fetch the value corresponding to the current key from the `synonyms` hashmap and store it in the variable `synonym`.
    - Check if `synonym` is not null:
        - If it's not null, add `synonym` to the `row` list.
        - If it's null, add `null` to the `row` list (to represent the absence of a value).

4. **Get Antonym Value**
    - Fetch the value corresponding to the current key from the `antonyms` hashmap and store it in the variable `antonym`.
    - Check if `antonym` is not null:
        - If it's not null, add `antonym` to the `row` list.
        - If it's null, add `null` to the `row` list (to represent the absence of a value).

5. **Add Row to Results**
    - Add the `row` list, representing the joined values for the current key, to the `results` list.

6. **Return Results**
    - After iterating through all keys in the `synonyms` hashmap, return the `results` list containing all the joined values.


## Solution

public static List<List<String>> leftJoin(HashMap<String, String> synonyms, HashMap<String, String> antonyms) {
List<List<String>> results = new ArrayList<>();

        for (String key : synonyms.keys()) {
            List<String> row = new ArrayList<>();
            row.add(key);
            String synonym = synonyms.get(key);
            if (synonym != null) {
                row.add(synonym);
            } else {row.add(null);}
            String antonym = antonyms.get(key);
            if (antonym != null) {
                row.add(antonym);
            } else {row.add(null);
            }
            results.add(row);
        }

        return results;
    }