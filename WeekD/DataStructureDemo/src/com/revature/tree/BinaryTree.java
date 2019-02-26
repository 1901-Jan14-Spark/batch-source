package com.revature.tree;

public class BinaryTree {
	
	Node root;
	
	public BinaryTree() {
		
	}
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public boolean containsValue(int val) {
		return containsValue(root, val);
	}
	
	private boolean containsValue(Node n, int val) {
		if(n!=null && n.id == val) {
			return true;
		}
		if(n!=null && val>n.id) {
			return containsValue(n.right, val);
		}
		if(n!=null && val<n.id) {
			return containsValue(n.left, val);
		}
		return false;
	}
	
	public String returnData(int val) {
		return returnData(root, val);
	}
	
	private String returnData(Node node, int val) {
		// check if the id matches the node itself
		if(node != null && node.id ==val) {
			return node.name;
		}
		if(node != null && node.id<val) {
			return returnData(node.right, val);
		}
		if(node != null && node.id>val) {
			return returnData(node.left, val);
		}
		return "";
	}

	public Node addNode(int val, String name) {
		if(root==null) {
			root = new Node(val);
		}
		return addNode(root, val, name);
	}
	
	private Node addNode(Node n, int val, String name) {
		Node newNode = new Node(val, name);
		if(n != null && n.id == val) {
			return n;
		}
		if(val>n.id) {
			if(n.right == null) {
				n.right = newNode;
				return newNode;
			} else {
				return addNode(n.right, val, name);
			}
		}
		if(val<n.id) {
			if(n.left == null) {
				n.left = newNode;
				return newNode;
			} else {
				return addNode(n.left, val, name);
			}
		}
		return null;
	}
}
