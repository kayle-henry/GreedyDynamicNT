
public class Quicksort {
    
	static int partition(Items[] itemsList, int low, int high)
	{
		int pivot = itemsList[high].value; 
	    int i = (low-1);
	    for (int j=low; j<high; j++)
	    {
	          
	        // If current element is smaller than or
	        // equal to pivot
	        if (itemsList[j].value >= pivot)
	        {
	            i++;

	            Items temp = itemsList[i];
	            itemsList[i] = itemsList[j];
	            itemsList[j] = temp;
	            }
	        }

	        Items temp = itemsList[i+1];
	        itemsList[i+1] = itemsList[high];
	        itemsList[high] = temp;

	        return i+1;
	    }


	    /* The main function that implements QuickSort()
	      a[] --> Array to be sorted,
	      l  --> Starting index,
	      h  --> Ending index */
	static void sort(Items[] itemsList, int l, int h){
	    if (l < h){
	        int pi = partition(itemsList, l, h);
            // Recursively sort elements before
	        // partition and after partition
	        sort(itemsList, l, pi-1);
	        sort(itemsList, pi+1, h);
	    }
	    
	    //for (int i=0; i<itemsList.length; ++i)
          //  System.out.print(itemsList[i]+" ");
	    
	}
}

