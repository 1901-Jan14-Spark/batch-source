package com.tranhuu.driver;

import com.tranhuu.model.Game;

public class Driver {

	public static void main(String[] args) {
		Game myGame = new Game();
		myGame.notice();
		System.out.println(myGame.getRandomNum());
	}
}
