
public class Application
{
	public static void main(String args[])
	{
		System.out.println("Starting Thread 1");
		Task taskRunner = new Task("Thread - A");
		Thread t1 = new Thread(taskRunner);
		t1.start();

		System.out.println("Starting Thread 2");
		Task taskRunner2 = new Task("Thread - B");
		Thread t2 = new Thread(taskRunner2);
		t2.start();

		System.out.println("Starting Thread 3");
		Task taskRunner3 = new Task("Thread - C");
		Thread t3 = new Thread(taskRunner3);
		t3.start();
	}
}

class Task implements Runnable
{
	String name;
	public Task(String name)
	{
		this.name = name;
	}
	public void run()
	{
		Thread.currentThread().setName(this.name);
		for(int i = 0; i < 100; i++)
		{
			System.out.println("number: " + i + " - " + Thread.currentThread().getName());
			try{
				Thread.sleep(10);  // in miliseconds
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}