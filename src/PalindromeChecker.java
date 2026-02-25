import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Node class to support Singly Linked List operations (UC8)
 */
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeChecker {

    public static void main(String[] args) {
        // UC1: Startup and Welcome
        displayWelcomeMessage();

        // UC2: Basic Hardcoded Check
        checkHardcodedPalindrome();

        // UC3: Manual String Reversal with Loop
        checkWithManualReversal();

        // UC4: Character Array with Two-Pointer Technique
        checkWithCharArray();

        // UC5: Stack-Based Reversal (LIFO)
        checkWithStack();

        // UC6: Queue (FIFO) and Stack (LIFO) Comparison
        checkWithQueueAndStack();

        // UC7: Deque (Double-Ended Queue) Comparison
        checkWithDeque();

        // UC8: Singly Linked List with In-Place Reversal
        checkWithLinkedList();

        // UC9: Recursive Palindrome Check
        String recursiveWord = "rotator";
        boolean isRecPal = isPalindromeRecursive(recursiveWord, 0, recursiveWord.length() - 1);
        System.out.println("UC9 (Recursion): " + recursiveWord + (isRecPal ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC1: Displays the application header
     */
    public static void displayWelcomeMessage() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0.0");
        System.out.println("------------------------------------------");
    }

    /**
     * UC2: Demonstrates simple string comparison using += operator
     */
    public static void checkHardcodedPalindrome() {
        String original = "madam";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        System.out.println("UC2 (Hardcoded): " + original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC3: Focuses on string immutability and manual reversal logic
     */
    public static void checkWithManualReversal() {
        String original = "radar";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        System.out.println("UC3 (Manual Loop): " + original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC4: Optimized two-pointer approach using a char array
     */
    public static void checkWithCharArray() {
        String original = "level";
        char[] arr = original.toCharArray();
        boolean isPal = true;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                isPal = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("UC4 (Char Array): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC5: Uses Stack's Last-In-First-Out (LIFO) property to reverse
     */
    public static void checkWithStack() {
        String original = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : original.toCharArray()) stack.push(c);
        String rev = "";
        while (!stack.isEmpty()) rev += stack.pop();
        System.out.println("UC5 (Stack): " + original + (original.equals(rev) ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC6: Compares Queue (FIFO) vs Stack (LIFO) behavior
     */
    public static void checkWithQueueAndStack() {
        String original = "racecar";
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for (char c : original.toCharArray()) {
            q.add(c);
            s.push(c);
        }
        boolean isPal = true;
        while (!q.isEmpty()) {
            if (!q.remove().equals(s.pop())) {
                isPal = false;
                break;
            }
        }
        System.out.println("UC6 (Queue+Stack): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC7: Uses Deque to shrink the word from both ends simultaneously
     */
    public static void checkWithDeque() {
        String original = "deified";
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : original.toCharArray()) dq.addLast(c);
        boolean isPal = true;
        while (dq.size() > 1) {
            if (!dq.removeFirst().equals(dq.removeLast())) {
                isPal = false;
                break;
            }
        }
        System.out.println("UC7 (Deque): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC8: Singly Linked List with Middle Finding and In-Place Reversal
     */
    public static void checkWithLinkedList() {
        String original = "malayalam";
        Node head = null, temp = null;
        for (char ch : original.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) { head = newNode; temp = head; }
            else { temp.next = newNode; temp = temp.next; }
        }

        // Find middle using Fast & Slow pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of linked list
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }

        // Compare first half and reversed second half
        Node f = head, s = prev;
        boolean isPal = true;
        while (s != null) {
            if (f.data != s.data) { isPal = false; break; }
            f = f.next;
            s = s.next;
        }
        System.out.println("UC8 (Linked List): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    /**
     * UC9: Recursive approach using the Call Stack
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base case: markers meet or cross
        if (start >= end) return true;
        // Check if characters at current markers match
        if (str.charAt(start) != str.charAt(end)) return false;
        // Recur for the remaining inner substring
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}