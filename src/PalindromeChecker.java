import java.util.Stack;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeChecker {
    public static void main(String[] args) {
        displayWelcomeMessage();
        checkHardcodedPalindrome();
        checkWithManualReversal();
        checkWithCharArray();
        checkWithStack();
        checkWithQueueAndStack();
    }

    // UC1: Welcome Message
    public static void displayWelcomeMessage() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0.0");
        System.out.println("------------------------------------------");
    }

    // UC2: Hardcoded String Check
    public static void checkHardcodedPalindrome() {
        String original = "madam";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    // UC3: Manual String Reversal
    public static void checkWithManualReversal() {
        String original = "radar";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    // UC4: Two-Pointer with Character Array
    public static void checkWithCharArray() {
        String original = "level";
        char[] charArray = original.toCharArray();

        boolean isPalindrome = true;
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    // UC5: Stack-Based Reversal (LIFO)
    public static void checkWithStack() {
        String original = "noon";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    // UC6: Queue (FIFO) + Stack (LIFO) Comparison
    public static void checkWithQueueAndStack() {
        String original = "racecar";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            // Queue pulls from front, Stack pulls from back
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }

        //UC7


    }
}