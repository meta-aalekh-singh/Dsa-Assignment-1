import java.util.*;
public class LinkList {
	static class ListNode {  
	    int data;  
	    ListNode next;  
	}
	
	static void rotateSubList(ListNode head, int leftPosition, int rightPosition, int numOfRotation)  
	{  
	    int size = rightPosition - leftPosition + 1;    
	    if (numOfRotation > size) {  
	    	numOfRotation = numOfRotation % size;  
	    }  
	    
	    if (numOfRotation == 0 || numOfRotation == size) {  
	        ListNode newHead = head;  
	        while (newHead != null) {  
	            System.out.print( newHead.data);  
	            newHead = newHead.next;  
	        }  
	        return;  
	    }  
	    
	    ListNode link = null; 
	    if (leftPosition == 1) {  
	        link = head;  
	    }  
	        
	    ListNode currentNode = head;  
	    int count = 0;    
	    ListNode end = null;    
	    ListNode previousNode = null; // Previous of m-th node  
	    while ( currentNode != null) {  
	        count++;  
	      
	        if (count == leftPosition - 1) {  
	            previousNode = currentNode;  
	            link = currentNode.next;  
	        }  
	        if (count == rightPosition - numOfRotation) {  
	            if (leftPosition == 1) {  
	                end = currentNode;  
	                head = currentNode.next;  
	            }  else {  
	                end = currentNode;  
	    
	                // That is how we bring (n-k+1)th  
	                // node to front of sublist.  
	                previousNode.next = currentNode.next;  
	            }  
	        }  
	    
	        // This keeps rest part of list intact.  
	        if (count == rightPosition) {  
	            ListNode d = currentNode.next;  
	            currentNode.next = link;  
	            end.next = d;  
	            ListNode newHead = head;  
	            while (head != null) {  
	                System.out.print( head.data+" ");  
	                head = head.next;  
	            }  
	            return;  
	        }  
	        currentNode = currentNode.next;  
	    }  
	}  
	
	static ListNode push( ListNode head, int val)  
	{  
	    ListNode new_node = new ListNode();  
	    new_node.data = val;  
	    new_node.next = (head);  
	    (head) = new_node;  
	    return head; 
	}
	
	public static void main(String args[]) 
	{  
	     ListNode head = null;  
	     head = push(head, 70);  
	     head = push(head, 60);  
	     head = push(head, 50);  
	     head = push(head, 40);  
	     head = push(head, 30);  
	     head = push(head, 20);  
	     head = push(head, 10);  
	     ListNode tmp = head;  
	     System.out.print("Given List: ");  
	     while (tmp != null) {  
	        System.out.print( tmp.data + " ");  
	        tmp = tmp.next;  
	     }  
	     System.out.println();
	     int leftPosition,rightPosition,numOfRotation;
	     Scanner in = new Scanner(System.in);
	     System.out.println("Enter left position of substring : ");
	     leftPosition=in.nextInt();
	     System.out.println("Enter Right position of substring : ");
	     rightPosition=in.nextInt();
	     System.out.println("Enter Number of Rotation steps : ");
	     numOfRotation=in.nextInt();  
	     System.out.print( "After rotation of sublist: ");  
	     rotateSubList(head, leftPosition, rightPosition, numOfRotation);  
	    
	} 
}

