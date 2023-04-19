package org.homework4.business.concretes;

import org.homework4.business.abstracts.Password1Service;
import org.homework4.repository.abstracts.OfficerRepository;

import java.util.Stack;

public class Password1Manager implements Password1Service {

    private final OfficerRepository repository;
    private Stack<String> passwords1;

    public Password1Manager(OfficerRepository repository) {
        this.repository = repository;
        passwords1 = new Stack<String>();

        for(int i = 0; i < repository.getOfficers().size() ; i++) {
            passwords1.push(repository.getOfficers().get(i).getPassword1());
        }
    }

    /**
     * Checks if password1 have at least 8 characters
     * Checks if password1 have at least 2 brackets
     * Checks if password1 have only letters and brackets
     * @param password
     * @return true if password1 is valid
     */
    public boolean isValidPassword(String password) {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            System.out.println("It should have at least 8 characters");
            return false;
        }

        // Check if the password contains at least 2 brackets
        int bracketCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')') {
                bracketCount++;
            }
        }
        if (bracketCount < 2) {
            System.out.println("It should have at least 2 brackets");
            return false;
        }

        boolean isThereAnyLetter = false;
        // Check if the password contains only letters and brackets
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetter(c) && c != '{' && c != '}' && c != '[' && c != ']' && c != '(' && c != ')') {
                System.out.println("It should have only letters and brackets");
                return false;
            }
            if(Character.isLetter(c)) isThereAnyLetter = true;
        }
        if(!isThereAnyLetter) {
            System.out.println("It should have letters too");
            return false;
        }

        // All checks passed, so the password is valid
        return true;
    }

    /**
     * Boolean function checks if password contains at least one letter of the username
     * @param username
     * @param password1
     * @return true if password contains at least one letter of the username
     */
    public boolean containsUserNameSpirit(String username, String password1) {
        Stack<Character> charStack = new Stack<>();

        // Push all characters of the password onto the stack
        for (int i = 0; i < password1.length(); i++) {
            char c = password1.charAt(i);
            charStack.push(c);
        }

        // Check if any character in the username is in the password
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (charStack.contains(c)) {
                return true;
            }
        }

        // If no character in the username is in the password, return false
        System.out.println("It should have at least 1 character from the username");
        return false;
    }

    /**
     * Checks brackets if they balanced
     * @param password1
     * @return true if password is balanced
     */

    public boolean isBalancedPassword(String password1) {
        Stack<Character> stack = new Stack<>();

        // Remove all letters from the password and only keep brackets
        String bracketsOnly = password1.replaceAll("[^{}\\[\\]()]", "");

        // Check if password starts with a closed bracket
        if (!bracketsOnly.isEmpty() && (bracketsOnly.charAt(0) == '}' || bracketsOnly.charAt(0) == ']' || bracketsOnly.charAt(0) == ')')) {
            return false;
        }

        // Process the brackets using a stack
        for (int i = 0; i < bracketsOnly.length(); i++) {
            char c = bracketsOnly.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                System.out.println("It should be balanced");
                return false; // Unmatched closing bracket
            }
        }
        // Check if all brackets are matched
        return stack.isEmpty();
    }

    /**
     * Checks if it is possible to obtain a palindrome by rearranging the letters in the password1.
     * @param password1
     * @return true if case is true, false otherwise
     */
    public boolean isPalindromePossible(String password1) {

        int maybeMiddle = 0;
        // Remove brackets from the string
        String s = password1.replaceAll("[{}\\[\\]()]", "");
        // Call the recursive function
        return isPalindromePossibleRecursion(s,maybeMiddle);
    }

    private boolean isPalindromePossibleRecursion(String s,int maybeMiddle) {
        // Base case: the string is empty or has only one character
        if(maybeMiddle > 1){
            System.out.println("It should be possible to obtain a palindrome from the password1.");
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        // Recursive case: check if the first character appears in the rest of the string
        char c = s.charAt(0);
        int index = s.indexOf(c, 1);

       if (index == -1) {
            maybeMiddle++;
            return isPalindromePossibleRecursion(s.substring(1),maybeMiddle);
        }
        else {
            // Recurse on the remaining string with the character removed
            String remaining = s.substring(1, index) + s.substring(index + 1);
            return isPalindromePossibleRecursion(remaining,maybeMiddle);
        }
    }


}
