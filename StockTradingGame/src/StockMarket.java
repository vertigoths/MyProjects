public class StockMarket
{
	private String name;
	private SingleLinkedList<Company> companies;
	
	public StockMarket(String name) 
	{
		this.companies=new SingleLinkedList<Company>();
		this.name=name;
	}
	
	public void insertCompany(Company company) 
	{
		this.companies.insert(company);
	}
	
	public void displayCompanies() 
	{
		this.companies.display();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public Company getCompany(int index) 
	{
		return this.companies.getCompany(index);
	}
	
	
}
