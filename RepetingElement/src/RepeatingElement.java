
public class RepeatingElement {
	
		void printRepeating(int arr[], int size)
		{
			int i; 
			System.out.println("The repeating elements are : ");
		        
		
			for(i = 0; i < size; i++)
			{
			   /* if(arr[i] < size){
				       int j = arr[i] % size;
				       arr[Math.abs(arr[j])] = -arr[Math.abs(arr[j])];
				    }
*/				 if(arr[Math.abs(arr[i] % size)] > 0){
				    
					arr[Math.abs(arr[i] % size)] = -arr[Math.abs(arr[i] % size)];
				}else
					System.out.print(Math.abs(arr[i]) + " ");
			}		 
		} 

		/* Driver program to test the above function */
		public static void main(String[] args) 
		{
			RepeatingElement duplicate = new RepeatingElement();
			int arr[] = {9, 2, 9, 5, 2, 3, 1};
			int arr_size = arr.length;
			duplicate.printRepeating(arr, arr_size);
		}
	}

	
