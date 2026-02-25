import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

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
        displayWelcomeMessage();
        checkHardcodedPalindrome();
        checkWithManualReversal();
        checkWithCharArray();
        checkWithStack();
        checkWithQueueAndStack();
        checkWithDeque();
        checkWithLinkedList();
    }

    // UC1
    public static void displayWelcomeMessage() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to the Palindrome Checker App");
        System.out.println("Version: 1.0.0");
        System.out.println("------------------------------------------");
    }

    // UC2
    public static void checkHardcodedPalindrome() {
        String original = "madam";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) reversed += original.charAt(i);
        System.out.println(original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC3
    public static void checkWithManualReversal() {
        String original = "radar";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) reversed = reversed + original.charAt(i);
        System.out.println(original + (original.equals(reversed) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC4
    public static void checkWithCharArray() {
        String original = "level";
        char[] arr = original.toCharArray();
        boolean isPal = true;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) { isPal = false; break; }
        }
        System.out.println(original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC5
    public static void checkWithStack() {
        String original = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : original.toCharArray()) stack.push(c);
        String rev = "";
        while (!stack.isEmpty()) rev += stack.pop();
        System.out.println(original + (original.equals(rev) ? " is a palindrome." : " is not a palindrome."));
    }

    // UC6
    public static void checkWithQueueAndStack() {
        String original = "racecar";
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for (char c : original.toCharArray()) { q.add(c); s.push(c); }
        boolean isPal = true;
        while (!q.isEmpty()) {
            if (!q.remove().equals(s.pop())) { isPal = false; break; }
        }
        System.out.println(original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC7
    public static void checkWithDeque() {
        String original = "deified";
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : original.toCharArray()) dq.addLast(c);
        boolean isPal = true;
        while (dq.size() > 1) {
            if (!dq.removeFirst().equals(dq.removeLast())) { isPal = false; break; }
        }
        System.out.println(original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    // UC8
    public static void checkWithLinkedList() {
        String original = "malayalam";
        Node head = null, temp = null;
        for (char ch : original.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) { head = newNode; temp = head; }
            else { temp.next = newNode; temp = temp.next; }
        }

        boolean isPal = true;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }
        Node f = head, s = prev;
        while (s != null) {
            if (f.data != s.data) { isPal = false; break; }
            f = f.next; s = s.next;
        }
        System.out.println(original + (isPal ? " is a palindrome." : " is not a palindrome."));
    }
}