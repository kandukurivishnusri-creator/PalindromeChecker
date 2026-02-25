public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("--- Palindrome Checker App ---");
        displayWelcomeMessage();
            }
    //Usecase 1
            public static void displayWelcomeMessage() {
                System.out.println("------------------------------------------");
                System.out.println("Welcome to the Palindrome Checker App");
                System.out.println("Version: 1.0.0");
                System.out.println("------------------------------------------");

//Usecase 2
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

//Usecase 3


    }
}

