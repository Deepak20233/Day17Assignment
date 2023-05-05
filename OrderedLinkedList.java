package com.java;
import java.util.*;

public class OrderedLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("Enter integers in order (press q to stop):");
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
           
            addItemInList(num,list);
            
        }
        System.out.println("The ordered list is:");
        printList(list);
        
        System.out.println("\nEnter integer to search in List :");
        Scanner sc1 = new Scanner(System.in);
        int num1 = sc1.nextInt();
        
        int index = list.indexOf(num1);
        if(index>-1) {
        System.out.println("Present at "+  index);
        System.out.println("Deleting" + num1 + " from index " + index);
        list.remove(index);
        printList(list);
        }
        else 
        {
        	  System.out.println("Given Number not present is List, so adding at end ");
        	  addItemInList(num1,list);
        	  //list.addLast(num1);
        	  printList(list);
        }
        
        
	}

	private static void addItemInList(int num, LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		 int index = 0;
		for (int i = 0; i < list.size(); i++) {
            if (num >= list.get(i)) {
                index = i + 1;
            } else {
                break;
            }
        }
        list.add(index, num);
	}

	private static void printList(LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		for (int num : list) {
            System.out.print(num + " ");
        }
	}

}
