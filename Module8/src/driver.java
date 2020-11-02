import java.util.Random;

public class driver {

	public static int total;

	public static void main(String[] args) throws InterruptedException {
		
		//create instance of random object
		Random rand = new Random();
		//create an array of ints
		int[] random;
		//create array of 200million ints
		random = new int[200000000];
		//fill array with random ints 1-10
		for(int i = 0;i<200000000;i++)
		{
			random[i] = rand.nextInt(10) + 1;
		}
		
		//run thread that sums the array and take time before and after. Print sum and time
		long startTime = System.nanoTime();
		SumThread first = new SumThread(random,0,200000000);
		Thread t1 = new Thread(first);
		t1.start();
		t1.join();
		System.out.println("total for one thread: ");
		System.out.println(first.getTotal());
		System.out.println("total time spent: ");
		System.out.println((System.nanoTime() - startTime)+"ms");
		
		//run (2) threads that sum the array and take time before and after. Print sum and time
		startTime = System.nanoTime();
		SumThread second = new SumThread(random,0,100000000);
		SumThread third = new SumThread(random,100000000,200000000);
		Thread t2 = new Thread(second);
		Thread t3 = new Thread(third);
		t2.start();
		t3.start();
		t2.join();
		t3.join();
		System.out.println("total for two threads: ");
		System.out.println(second.getTotal()+third.getTotal());
		System.out.println("total time spent: ");
		System.out.println((System.nanoTime() - startTime)+"ms");
		
		
	}
}
	
	

