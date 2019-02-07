package com.revature.list;

public class LinkedList {
	
	Node head;
	
	public LinkedList() {
		super();
		this.head = null;
	}
	
	public LinkedList(Node head) {
		this.head = head;
	}
	
	// time complexity O(1)
	public void push(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	// time complexity for search O(n)
	public Node find(int data) {
		Node n = head;
		while(n!=null) {
			if(n.id == data) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
	
	// time complexity for insertion O(1)
	public Node insertAfter(Node preceding, int id) {
		Node newNode = new Node(id);
		if(preceding == null) {
			return newNode;
		}
		newNode.next = preceding.next;
		preceding.next = newNode; 
		return newNode;
	}
	
	// appending a value at the end would be O(n)
	public Node append(int id) {
		Node newNode = new Node(id);
		if(head == null) {
			head = newNode;
		}
		Node n = head;
		while(n.next!=null) {
			n = n.next;
		}
		n.next = newNode;
		return newNode;
	}
	
	public void print() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.id + " ");
			n = n.next;
		}
	}

}
