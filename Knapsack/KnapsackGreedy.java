
public class KnapsackGreedy {
//Greedy-choice: Take the item with the most value under the weight limit
	/*public static void main(String[] args) {
		int[] val = {3, 2, 1};
	    int[] wt = {4 ,5 ,1};
	    //int[][] item = {val, wt};
	    int w = 4;

	    System.out.print(knapsackGreedy(w, val, wt));
		
	}*/
	
	public static int run(int w, Items[] itemsList) {
		int sumwt=0;
		int totalVal=0;
		
		//Sort
		itemsList = qs(w, itemsList);
		
		//Find the item with the highest value(already sorted highest to lowest)		
		for(int i = 0; i < itemsList.length; i++) {
			if(itemsList[i].weight+sumwt <= w) {
				sumwt+=itemsList[i].weight;
				totalVal+= itemsList[i].value;
			}
		}
		//System.out.println(totalVal);
		return totalVal;
	}

	public static Items[] qs(int wt, Items[] itemsList) {
		Quicksort.sort(itemsList, 0 , itemsList.length-1);
		
		return itemsList;
	}
	

}
