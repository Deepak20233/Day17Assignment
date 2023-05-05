package com.java;
import java.util.*;

public class UnorderedLinkedList {
	static Node head;
	static int position = 0;
	static boolean isDeleted = false;
	static boolean isfound = false;
    static int count = 0;
	public static void main(String[] args) {
		LinkedListClass list = new LinkedListClass();
		
		String str = "This is a hello comment from Deepak";
        String[] arrOfStr = str.split(" ");
        int i=0;
        for (String a : arrOfStr) {
            list.insert(a, i);
            i++;
        }
        list.printList(); 
        System.out.println("\n Enter your word to be searched!!!");
        Scanner sc = new Scanner(System.in);
        String searchWord = sc.next();
        list.search(searchWord);
        
        
        
        
	}

//	private static Node search(String searchWord) {
//		
//			Node current = head;
//			
//	        while (current != null) {
//	            if (current.data == searchWord) {
//	            	isfound = true;
//	            	position++;
//	                return current;
//	            }
//	            current = current.next;
//	        }
//	        return null;
//	}
//	
//	public static void delete(String value) {
//        if (head == null) {
//            return;
//        }
//        if (head.data == value) {
//            head = head.next;
//            return;
//        }
//        Node prev = head;
//        Node current = head.next;
//        while (current != null) {
//            if (current.data == value) {
//            	isDeleted= true;
//                prev.next = current.next;
//                return;
//            }
//            prev = current;
//            current = current.next;
//        }
//    }
//	public int size() {
//
//        Node current = head;
//        while (current != null) {
//            count++;
//            current = current.next;
//        }
//        return count;
//    }
	
	
}
