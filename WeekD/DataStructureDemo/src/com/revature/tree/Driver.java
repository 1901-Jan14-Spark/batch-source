package com.revature.tree;

public class Driver {

	public static void main(String[] args) {
		
		Node root = new Node(8, "Joe");
		Node left = new Node(5, "Sally");
		Node right = new Node(10, "Lisa");
		root.left = left;
		root.right = right;
		
		BinaryTree tree = new BinaryTree(root);
		System.out.println(tree.containsValue(5));
		System.out.println(tree.containsValue(6));
		
		System.out.println("data from node with id 5: "+tree.returnData(5));
		System.out.println("data from node with id 6: "+tree.returnData(6));
	}

}
