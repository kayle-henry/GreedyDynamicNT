import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException {
		int itemCount = 100;
		int wt = 100;
		int time = 0;
		Items[] itemsList = new Items[itemCount];
		int[] values = new int[itemCount];
		int[] weights = new int[itemCount];
		
		
//Generate Items
		itemsList = loadItemList(itemsList);
		//itemsList = generateItems(itemCount);
		printItemList(itemsList);
		
		//split the objects' properties for dynamic
		for(int i=0; i<itemsList.length;i++) {
			values[i] = itemsList[i].value;
			weights[i] = itemsList[i].weight;
		}
		
		
//InsertLoop
		
		//Dynamic
		System.out.println("Dynamic: " + KnapsackDynamic.knapsackM(wt, values, weights)); //total weight, values, weights
		//Greedy
		System.out.println("Greedy: " + KnapsackGreedy.run(wt, itemsList));
		
//EndLoop
		
	}
	

	private static Items[] generateItems(int c){
		Items[] itemsList = new Items[c];
		
		for(int i = 0; i < itemsList.length; i++) {	
			Items item = new Items();
			itemsList[i] = item;
		}
		return itemsList;
	}
	
	private static void printItemList(Items[] itemsList) {
		for(int j = 0; j < itemsList.length; j++) {
			System.out.println(itemsList[j].value +", "+ itemsList[j].weight);
		}
	}
		
	private static Items[] loadItemList(Items[] itemsList) throws IOException {
		String file = "RawItemsList";
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for(int i=0; i<100; i++) {
				String string = reader.readLine();
				//String delim = "[]+";
				String[] item = string.split("\\s+");
				int value = Integer.parseInt(item[0]);
				int weight = Integer.parseInt(item[1]);
				itemsList[i] = new Items(value, weight);
				//System.out.println(string);
				//System.out.println(value+ " - "+ weight);
			}
			reader.close();
			return itemsList;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return itemsList;
	}
	
	
	
	
	
}
