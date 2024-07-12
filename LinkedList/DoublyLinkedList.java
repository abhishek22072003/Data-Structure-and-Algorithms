package LinkedList;
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DoublyLinkedList {
    static Node constructDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], temp, null);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node prev = temp.prev;
        temp.prev = null;
        prev.next = null;
        return head;
    }

    static Node deleteKthNode(Node head, int k) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k)
                break;
            temp = temp.next;
        }
        Node back = temp.prev;
        Node front = temp.next;
        if (back == null && front == null) {
            return null;
        }
        if (back == null) {
            return deleteHead(head);
        }
        if (front == null) {
            return deleteTail(head);
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    static void deleteGivenNode(Node node) {
        Node back = node.prev;
        Node front = node.next;
        if (front == null) {
            back.next = null;
            node.prev = null;
            return;
        }
        back.next = front;
        front.prev = back;
        node.next = node.prev = null;
        return;
    }

    static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data, null, head);
        head.prev = newNode;
        head = newNode;
        return head;
    }

    static Node insertAtEnd(Node head, int data) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newNode = new Node(data, tail, null);
        tail.next = newNode;
        return head;
    }
    static Node insertBeforeKthNode(Node head, int data, int k){
        if(k==1){
            return insertAtHead(head, data);
        }
        int cnt =0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node newNode = new Node(data, prev, temp);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 7, 6, 9, 5, 4 };
        Node head = constructDLL(arr);
        print(head);
        head = insertAtHead(head, 700);
        print(head);
        head = insertAtEnd(head, 22);
        print(head);
        head = insertAtEnd(head, 23);
        print(head);
        head = insertBeforeKthNode(head, 500, 4);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteTail(head);
        print(head);
        head =deleteTail(head);
        print(head);
        head = deleteKthNode(head, 3);
        print(head);
        deleteGivenNode(head.next.next);
        print(head);        
    }
}