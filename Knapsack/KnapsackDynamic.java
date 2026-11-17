
public class KnapsackDynamic {

	/*public static void main(String[] args){
	    int[]val = {1,2,3};
	    int[] wt = {4,5,1};
	    int w = 4;

	    System.out.print(knapsackM(w, val, wt));
	}*/

	static int knapsackMem(int w, int[] val, int[] wt, int n, int[][] memo){
	    //base case
	    if(n == 0 || w==0){
	        return 0;
	    }

	    //check if prev calculated
	    if(memo[n][w] != -1){
	        return memo[n][w];
	    }

	    int pick = 0;

	    //pick the nth item if not > capacity
	    if(wt[n-1]<=w){
	        pick = val[n-1] + knapsackMem(w - wt[n-1], val, wt, n-1, memo);
	    }

	    //dont pick nth item
	    int notPick = knapsackMem(w, val, wt, n-1, memo);

	    //store result and return it
	    return memo[n][w] = Math.max(pick, notPick);
	}

	static int knapsackM(int w, int[] val, int[] wt){
		Long start = System.nanoTime();
		int n = val.length;

	    //Memoization table
	    int [][] memo = new int[n+1][w+1];
	    //while(System.nanoTime() <= 5.1182531641) {
	    for(int i=0; i<=n; i++){
	        for(int j=0; j<=w; j++){
	            memo[i][j] = -1;
	        }
	    }
	    return knapsackMem(w, val, wt, n, memo);
		//}
		
	}







}
