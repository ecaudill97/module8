
class SumThread implements Runnable{  
	
	//private variables
	private int[] random;
	private int arr_min;
	private int arr_max;
	private int total;
	
	//returns total
	int getTotal()
	{
		return total;
	}
	//finds the sum in an array
	public void run(){ 
		
		int sum=0;
		for(int j=arr_min;j<arr_max;j++)
		{
			sum+=random[j];
		}
		total = sum;
	} 
	//takes the min and max and array to find the sum in array for that range.  0-200mil for one 
	//thread and 0-100mil and 100mil-200mil for two
	SumThread(int[] r,int min,int max)
	{
		random = r;
		arr_min = min;
		arr_max = max;
	}
  
}  