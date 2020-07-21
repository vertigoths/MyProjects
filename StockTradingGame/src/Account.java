import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Account
{
	private String username;
	private double balance;
	private SingleLinkedList<Company> stocks;
	
	public Account() 
	{
		this.username="Default";
		this.balance=0;
		this.stocks=null;
	}
	
	public Account(String username,double balance) 
	{
		this.username=username;
		this.balance=balance;
		this.stocks=new SingleLinkedList<Company>();
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public void insertStock(Company company) throws IOException 
	{
		if(!this.stocks.search(company)) 
		{
			this.stocks.insert(company);
			this.updateAccountText();
		}
	}
	
	public void displayStocks() 
	{
		if(stocks!=null) 
		{
			this.stocks.display();
		}
		
	}

	
	private void updateAccountText() throws IOException 
	{
		Writer fileWriter = new FileWriter("C:\\Users\\zombi\\Desktop\\Account.txt");
		fileWriter.write(this.getUsername()+","+this.balance+"\n");
	    int sizeOfStock=stocks.size();
		
		for(int i=0;i<sizeOfStock;i++) 
		{
			Company company=stocks.getCompany(i);
			fileWriter.write(company.toString()+"\n");
		}
	    
	    fileWriter.close();
	}
	
	
	
}
