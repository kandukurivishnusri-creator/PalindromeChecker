import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

// ==========================================
// UC8 & UC11: Supporting Classes
// ==========================================
class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; this.next = null; }
}

// ==========================================
// UC12: Strategy Pattern Implementation
// ==========================================

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean check(String text) { return strategy.isPalindrome(text); }
}

// ==========================================
// MAIN APPLICATION
// ==========================================
public class PalindromeChecker {

    public static void main(String[] args) {
        displayWelcomeMessage(); // UC1
        checkHardcodedPalindrome(); // UC2
        checkWithManualReversal(); // UC3
        checkWithCharArray(); // UC4
        checkWithStack(); // UC5
        checkWithQueueAndStack(); // UC6
        checkWithDeque(); // UC7
        checkWithLinkedList(); // UC8

        // UC9 - Recursion
        String recWord = "rotator";
        boolean res9 = isPalindromeRecursive(recWord, 0, recWord.length() - 1);
        System.out.println("UC9 (Recursion): " + recWord + (res9 ? " is a palindrome." : " is not a palindrome."));

        // UC10 - Normalization
        checkWithNormalization();

        // UC11 & UC12 - OOPS & Strategy Pattern
        checkWithStrategyPattern();

        // UC13 - Performance Comparison
        comparePerformance();
    }

    // UC1: Welcome Message
    public static void displayWelcomeMessage() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0.0 (Performance Profiling)");
        System.out.println("------------------------------------------");
    }

    // UC2: Basic Check
    public static void checkHardcodedPalindrome() {
        String original = "madam";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) reversed += original.charAt(i);
        System.out.println("UC2 (Hardcoded): " + original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC3: Manual Reversal
    public static void checkWithManualReversal() {
        String original = "radar";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) reversed = reversed + original.charAt(i);
        System.out.println("UC3 (Manual Loop): " + original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC4: Char Array Two-Pointer
    public static void checkWithCharArray() {
        String original = "level";
        char[] arr = original.toCharArray();
        boolean isPal = true;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) { isPal = false; break; }
        }
        System.out.println("UC4 (Char Array): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC5: Stack (LIFO)
    public static void checkWithStack() {
        String original = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : original.toCharArray()) stack.push(c);
        String rev = "";
        while (!stack.isEmpty()) rev += stack.pop();
        System.out.println("UC5 (Stack): " + original + (original.equals(rev) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC6: Queue + Stack
    public static void checkWithQueueAndStack() {
        String original = "racecar";
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for (char c : original.toCharArray()) { q.add(c); s.push(c); }
        boolean isPal = true;
        while (!q.isEmpty()) {
            if (!q.remove().equals(s.pop())) { isPal = false; break; }
        }
        System.out.println("UC6 (Queue+Stack): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC7: Deque
    public static void checkWithDeque() {
        String original = "deified";
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : original.toCharArray()) dq.addLast(c);
        boolean isPal = true;
        while (dq.size() > 1) {
            if (!dq.removeFirst().equals(dq.removeLast())) { isPal = false; break; }
        }
        System.out.println("UC7 (Deque): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC8: Linked List
    public static void checkWithLinkedList() {
        String original = "malayalam";
        Node head = null, temp = null;
        for (char ch : original.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) { head = newNode; temp = head; }
            else { temp.next = newNode; temp = temp.next; }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        Node prev = null, curr = slow;
        while (curr != null) { Node nX = curr.next; curr.next = prev; prev = curr; curr = nX; }
        Node f = head, s = prev;
        boolean isPal = true;
        while (s != null) {
            if (f.data != s.data) { isPal = false; break; }
            f = f.next; s = s.next;
        }
        System.out.println("UC8 (Linked List): " + original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC9: Recursion
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // UC10: Normalization
    public static void checkWithNormalization() {
        String input = "Step on no pets";
        String clean = input.replaceAll("\\s+", "").toLowerCase();
        boolean isPal = true;
        for (int i = 0, j = clean.length() - 1; i < j; i++, j--) {
            if (clean.charAt(i) != clean.charAt(j)) { isPal = false; break; }
        }
        System.out.println("UC10 (Normalization): '" + input + "' " + (isPal ? "is a palindrome." : "is not a palindrome."));
    }

    // UC11 & UC12 Implementation
    public static void checkWithStrategyPattern() {
        String testInput = "Never odd or even";
        PalindromeService service = new PalindromeService();
        service.setStrategy(new StackStrategy());
        service.check(testInput);
        service.setStrategy(new DequeStrategy());
        service.check(testInput);
        System.out.println("UC11/12 (OOPS & Strategy): Executed successfully.");
    }

    // UC13: Performance Comparison Logic
    public static void comparePerformance() {
        System.out.println("\n--- UC13: Performance Comparison (nanoseconds) ---");
        String longText = "a".repeat(10000) + "b" + "a".repeat(10000); // 20,001 characters

        // 1. Measure Stack Strategy
        long startTime = System.nanoTime();
        new StackStrategy().isPalindrome(longText);
        long stackTime = System.nanoTime() - startTime;

        // 2. Measure Deque Strategy
        startTime = System.nanoTime();
        new DequeStrategy().isPalindrome(longText);
        long dequeTime = System.nanoTime() - startTime;

        // 3. Measure Two-Pointer (Char Array)
        startTime = System.nanoTime();
        char[] arr = longText.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { if (arr[i] != arr[j]) break; }
        long pointerTime = System.nanoTime() - startTime;

        System.out.println("Stack Strategy Time  : " + stackTime + " ns");
        System.out.println("Deque Strategy Time  : " + dequeTime + " ns");
        System.out.println("Two-Pointer Time     : " + pointerTime + " ns");
        System.out.println("--------------------------------------------------\n");
    }
}