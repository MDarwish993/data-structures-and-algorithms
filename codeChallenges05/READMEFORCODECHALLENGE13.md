# Challenge 13
#### Multi-bracket Validation.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc13.jpg "/>

### - Initial validateBrackets Method:
- validateBrackets Method:

- Arguments: String
- The validateBrackets function uses a stack to keep track of opening brackets and checks if each closing bracket matches the corresponding opening bracket. If any mismatch is found or if there are unmatched opening brackets left in the stack, it returns false. Otherwise, if the stack is empty at the end, it returns true, indicating that all brackets are balanced.


## Solution
public boolean validateBrackets(String input) {
Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()) {
                    return false; // Closing bracket without a corresponding opening bracket
                }

                char top = stack.pop();
                if (!areBracketsMatching(top, character)) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty(); // If the stack is empty, all brackets are balanced.
    }

    private  boolean areBracketsMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }


