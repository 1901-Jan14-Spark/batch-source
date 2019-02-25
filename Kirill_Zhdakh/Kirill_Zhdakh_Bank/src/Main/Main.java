package Main;

import java.util.Scanner;

import Classes.Bank;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank(scan);
		bank.mainPage();
	}
}
