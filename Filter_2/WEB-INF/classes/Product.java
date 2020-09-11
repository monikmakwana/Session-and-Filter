public class Product
{
	private String name;
	private String description;
	private float cost;
	
	public Product(String name, String description, float cost)
	{
		this.name = name;
		this.description = description;
		this.cost = cost;
	}

	public String name()
	{	
		return name;
	}
	public String description()
	{
		return description;
	}
	
	public float cost()
	{
		return cost;
	}
	
	public String data()
	{
		return (" Name : " + name + "<br> Description : " + description + "<br> Price : " + cost);
	}
}