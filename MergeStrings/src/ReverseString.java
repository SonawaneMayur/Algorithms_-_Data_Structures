
class ReverseString{

public static int equilibrium(int arr[], int n)
{
   int sum = 0;      // initialize sum of whole array
   int leftsum = 0; // initialize leftsum
   int i;
   int j;
   
   
   /* Find sum of the whole array */
   for (i = 0; i < n; ++i)
        sum += arr[i];
 
   for( i = 0; i < n; ++i)
   {
      sum -= arr[i]; // sum is now right sum for index i
 
       if(leftsum == sum)
    	  return i;
      
      leftsum += arr[i];
     
   }
 
    /* If no equilibrium index found, then return 0 */
    return -1;
}
 
public static void main(String[] args)
{
  int arr[] = {4,1,2,3,3};
  int arr_size = arr.length;
  System.out.println("Result"+equilibrium(arr, arr_size));
  
}
}