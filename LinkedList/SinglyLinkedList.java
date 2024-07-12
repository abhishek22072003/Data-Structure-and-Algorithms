package LinkedList;
public class SinglyLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    
    }
    static Node constructSLL(int [] arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1;i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;            
        }
        return head;
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }  
        System.out.println();      
    }

    static Node deleteHead(Node head){
        if(head==null && head.next==null)
            return null;
        head = head.next;
        return head;
    }
    static Node deleteTail(Node head){
        if(head==null && head.next==null)
            return null;
        Node temp = head;
        while(temp.next.next!=null)
            temp = temp.next;
        temp.next = null;
        return head;
    }
    static Node deleteNodeWithGivenData(Node head, int data){
           if(head.data==data) return deleteHead(head);
           Node temp = head;
            while(temp.next.data!=data){
                temp = temp.next;
            }
            if(temp.next.next==null) return deleteTail(head);
            temp.next = temp.next.next;
            return head;
    }
    static Node insertAtHead(Node head, int data){
        Node newNode = new Node(data, head);
        head = newNode;
        return head;
    }
    static Node insertAtTail(Node head, int data){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        return head;
    }
    static Node insertAfterGivenData(Node head, int data, int val){
        if(head.data == data) return insertAtHead(head, val);
        Node temp = head;
        while(temp.next!=null && temp.data!=data)
            temp = temp.next;
        Node newNode = new Node(data);
        if(temp.next==null)
            return insertAtTail(head, val);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    static boolean search(Node head, int data){
        Node temp = head;
        while(temp!=null){
            if(temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr = {5, 7, 3, 12, 57};
        Node head = constructSLL(arr);
        print(head);
        head = insertAtHead(head, 100);
        print(head);
        head = insertAtHead(head, 200);
        print(head);
        head = insertAtTail(head, 475);
        print(head);
        head = insertAtTail(head, 956);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteTail(head);
        print(head);
        head = deleteTail(head);
        print(head);
        head = deleteNodeWithGivenData(head, 57);
        print(head);
        System.out.println(search(head, 5));
        System.out.println(search(head, 475));
                
    }
    
}