package com.revature.tree;

public class Node {
	
	int id;
	String name;
	Node left;
	Node right;
	
	public Node(int id) {
		this.id = id;
	}
	
	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
