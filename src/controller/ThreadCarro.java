package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread
{
	private Semaphore semaforo;
	private int idCarro;
	private String sentido [] = {"Norte", "Sul", "Leste", "Oeste"};
	
	public ThreadCarro(int idCarro, Semaphore semaforo)
	{
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run()
	{
		try
		{
			semaforo.acquire();
			Andando();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			semaforo.release();
		}
	}

	private void Andando()
	{
		String destino;
		
		if(ePar(idCarro))
		{
			destino = sentido[idCarro+1];
		}
		else
		{			
			destino = sentido[idCarro-1];
		}
		System.out.println("Carro #" + idCarro + " esta indo de " + sentido[idCarro] + " para " + destino + ".");
		dormir(3000);
		System.out.println("Carro #" + idCarro + " atravessou o cruzamento.");
		dormir(1000);
	}

	private void dormir(int i)
	{
		try
		{
			sleep(i);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private boolean ePar(int x)
	{
		if (x % 2 == 0)
		{
			return true;
		}
		return false;
	}
}
