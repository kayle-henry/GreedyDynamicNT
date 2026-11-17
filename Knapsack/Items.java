import java.util.Random;
//This class should read a file with columns being value weight and turn it into a two dimensional array like itemList[row][column]
//row being the list and columns needing to follow the row. To sort look at 

public class Items {
	int value;
	int weight;
	Random rand = new Random();
	
	public Items(int value, int weight)	{
		this.value = value;
		this.weight = weight;
	}
	
	public Items() {
		//generate value and weight
		this.value = rand.nextInt(1, 201);
		this.weight = rand.nextInt(1, 51);
	}
	

}


