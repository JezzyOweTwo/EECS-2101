
public class Item {
	public static Item one = new Item(2,20,"one");
	public static Item two = new Item(5,30,"two");
	public static Item three = new Item(10,50,"three");
	public static Item four = new Item(5,10,"four");
	public static Item[] items = {one,two,three,four};
	
	int weight;
	int value;
	String name;
	
	public Item(int weight,int value,String name) {
		this.weight=weight;
		this.value=value;
		this.name=name;
	}
}
