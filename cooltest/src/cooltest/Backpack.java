import java.util.ArrayList;

public class Backpack extends ArrayList<Item>{
	public int totalValue=0;
	
	public Backpack() {super();}
	
	public Backpack(Backpack pack) {
		super(pack);
	}
	
	@Override
	public boolean add(Item item){
		boolean bool = super.add(item);
		this.totalValue+=item.value;
		return bool;
	}
	
	public ArrayList<Item> optimizer(int maxWeight){
		return optimizer(maxWeight,new Backpack());
	}
	
	// TODO: doesnt work fully
	private Backpack optimizer(int maxWeight,Backpack currentSolution) {
		if (maxWeight<=0) return currentSolution;
		
		Backpack currentWinner= new Backpack();
		Backpack result = null;
		for (Item i:Item.items) {
			while(maxWeight>=0) {
				Backpack temp = new Backpack(currentSolution);
				temp.add(i);
				result = optimizer(maxWeight-i.weight,temp);
			}
			if (result.totalValue>currentWinner.totalValue)
				currentWinner = result;	
		}
		
		return currentWinner;
	}
}

