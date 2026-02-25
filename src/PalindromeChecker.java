public class PalindromeChecker {
    public static void main(String[] args) {
        displayWelcomeMessage();
        checkHardcodedPalindrome();
        checkWithManualReversal();
    }
    //UC1

    public static void displayWelcomeMessage() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0.0");
        System.out.println("------------------------------------------");
    }

    //UC2
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

    //UC3
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
        //UC4
    }
}
