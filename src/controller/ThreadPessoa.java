/*2. Quatro pessoas caminham, cada uma em um corredor diferente. Os 4 corredores terminam
em uma única porta. Apenas 1 pessoa pode cruzar a porta, por vez. Considere que cada
corredor tem 200m. e cada pessoa anda de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
para abrir e cruzar a porta. Faça uma aplicação em java que simule essa situação.
*/
package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	private static int distanciaTotal = 200;
	private int idPessoa;
	private static Semaphore semaforo = new Semaphore(1);
	
	public ThreadPessoa() {
		this.idPessoa = (int)threadId();
	}
	
	@Override
	public void run() {
		andar();
		try {
			semaforo.acquire();
			abrir();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}

	private void andar() {
		int distanciaPercorrida = 0;
		
		while(distanciaPercorrida < distanciaTotal) {
			int passos = (int)((Math.random() * 3) + 4);
			distanciaPercorrida += passos;
			System.out.println("Pessoa #" + idPessoa + " percorreu " + distanciaPercorrida + " metros.");
			
			if(distanciaPercorrida >= distanciaTotal) {
				System.out.println("Pessoa #" + idPessoa + " finalizou o percurso e chegou na porta.");
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		
		
	}

	private void abrir() {
		int tempo = (int)((Math.random() * 2) + 1);
		
		System.out.println("Pessoa #" + idPessoa + " abriu e cruzou a porta levando " + tempo + " segundo(s).");
		try {
			sleep(tempo * 1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		
	}

}
