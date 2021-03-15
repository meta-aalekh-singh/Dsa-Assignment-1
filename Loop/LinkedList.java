import java.util.*;
 
public class LinkedList {
 
    static Node head; 
    static class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    
    static public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    
    static boolean detectLoop(Node head)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (head != null) {
            if (s.contains(head)){
                return true;
            }
            s.add(head);
            head = head.next;
        }
 
        return false;
    }
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        Scanner in = new Scanner(System.in);
        int i,numOfElement,elementOfLinkedList;
        System.out.println("Enter Number of element in Linked List : ");
        numOfElement = in.nextInt();
        for(i=0 ; i<numOfElement ; i++){
        	System.out.println("Enter "+(i+1)+" Element of linked list : ");
        	elementOfLinkedList = in.nextInt();
        	llist.push(elementOfLinkedList);
        }
        //Create loop for testing
        if(numOfElement>=4){
            llist.head.next.next.next.next = llist.head;
        }
        System.out.println("\n================================================================================================================");
        if (detectLoop(head)){
            System.out.println("Loop found in Linklist");
        } else {
            System.out.println("No Loop found in Linklist");
        }
    }
}