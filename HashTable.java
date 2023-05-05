package com.java;

public class HashTable {
    private int[] slots;
    private int size;
    
    public HashTable(int size) {
        this.size = size;
        this.slots = new int[size];
        for (int i = 0; i < size; i++) {
            slots[i] = -1; // initialize slots to -1 to indicate they are empty
        }
    }
    
    public int hash(int key) {
        return key % size; // simple modulo hashing function
    }
    
    public void insert(int key) {
        int slot = hash(key);
        while (slots[slot] != -1) {
            // if slot is already occupied, find the next available slot
            slot = (slot + 1) % size;
        }
        slots[slot] = key;
    }
    
    public int search(int key) {
        int slot = hash(key);
        while (slots[slot] != -1) {
            if (slots[slot] == key) {
                return slot;
            }
            slot = (slot + 1) % size;
        }
        return -1; // key not found
    }

   public static void main(String[] args) {
    HashTable ht = new HashTable(10);
    ht.insert(25);
    ht.insert(35);
    ht.insert(15);
    int index = ht.search(35);
    if (index == -1) {
        System.out.println("35 not found in hash table.");
    } else {
        System.out.println("35 found at index " + index);
    }
   }
}
