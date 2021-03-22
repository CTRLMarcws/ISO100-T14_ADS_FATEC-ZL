package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {

	public static void main(String[] args)
	{
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarro = 0; idCarro < 4; idCarro++)
		{
			Thread t = new ThreadCarro(idCarro, semaforo);
			t.start();				
		}

	}

}
