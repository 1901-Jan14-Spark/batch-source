package com.revature.list;

public class Driver {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); // head = null
		list.push(3); // head 3
		list.push(5); // head 5
		list.push(7); // head 7
		list.print();
		System.out.println();
		Node fiveNode = list.find(5);
		Node oneNode = list.insertAfter(fiveNode, 1);
		list.insertAfter(oneNode, 14);
		list.insertAfter(fiveNode, 2);
//		System.out.println(list.find(8));
		list.print();
		System.out.println();
		list.append(4);
		list.print();
	}

}
