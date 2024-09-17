package view;

import controller.ThreadPessoa;

public class Main {

	public static void main(String[] args) {
		
		for(int i = 0; i < 4; i++) {
			Thread t = new ThreadPessoa();
			t.start();
		}
	}

}
