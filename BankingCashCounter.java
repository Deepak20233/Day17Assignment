package com.java;

	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;

	class Customer {
	    String name;
	    String transactionType;
	    int amount;
	    
	    public Customer(String name, String transactionType, int amount) {
	        this.name = name;
	        this.transactionType = transactionType;
	        this.amount = amount;
	    }
	}

	class Bank {
	    Queue<Customer> queue;
	    int cashBalance;
	    
	    public Bank() {
	        queue = new LinkedList<>();
	        cashBalance = 0;
	    }
	    
	    public void addCustomer(String name, String transactionType, int amount) {
	        Customer customer = new Customer(name, transactionType, amount);
	        queue.add(customer);
	    }
	    
	    public void processCustomer() {
	        if (queue.isEmpty()) {
	            System.out.println("No customers in queue.");
	            return;
	        }
	        
	        Customer customer = queue.poll();
	        if (customer.transactionType.equals("deposit")) {
	            cashBalance += customer.amount;
	            System.out.println(customer.name + " deposited " + customer.amount + " dollars. Cash balance: " + cashBalance);
	        } else if (customer.transactionType.equals("withdraw")) {
	            if (customer.amount > cashBalance) {
	                System.out.println(customer.name + " cannot withdraw " + customer.amount + " dollars. Insufficient funds.");
	            } else {
	                cashBalance -= customer.amount;
	                System.out.println(customer.name + " withdrew " + customer.amount + " dollars. Cash balance: " + cashBalance);
	            }
	        } else {
	            System.out.println("Invalid transaction type.");
	        }
	    }
	}

	public class BankingCashCounter {
	    public static void main(String[] args) {
	        Bank bank = new Bank();
	        Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println("Enter customer name (or 'q' to quit):");
	            String name = scanner.nextLine();
	            if (name.equals("q")) {
	                break;
	            }
	            
	            System.out.println("Enter transaction type ('deposit' or 'withdraw'):");
	            String transactionType = scanner.nextLine();
	            
	            System.out.println("Enter amount:");
	            int amount = scanner.nextInt();
	            scanner.nextLine(); // consume newline character
	            
	            bank.addCustomer(name, transactionType, amount);
	        }
	        
	        while (true) {
	            System.out.println("Press enter to process next customer (or 'q' to quit):");
	            String input = scanner.nextLine();
	            if (input.equals("q")) {
	                break;
	            }
	            
	            bank.processCustomer();
	        }
	    }
	}


