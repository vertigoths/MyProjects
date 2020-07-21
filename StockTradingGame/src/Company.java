public class Company
{
	private String symbol;
	private String name;
	private double price;
	private StockMarket stockMarket;
	private double share;
	
	
	public Company(String symbol,String name,double price,StockMarket stockMarket,double share) 
	{
		this.symbol=symbol;
		this.name=name;
		this.price=price;
		this.stockMarket=stockMarket;
		this.share=share;
	}
	
	public Company(String symbol,String name,double price,double share) 
	{
		this.symbol=symbol;
		this.name=name;
		this.price=price;
		this.stockMarket=null;
		this.share=share;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	
	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public double getPrice()
	{
		return price;
	}


	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
	public StockMarket getStockMarket()
	{
		return stockMarket;
	}

	
	public void setStockMarket(StockMarket stockMarket)
	{
		this.stockMarket = stockMarket;
	}
	

	public double getShare()
	{
		return share;
	}


	public void setShare(double share)
	{
		this.share = share;
	}


	@Override
	public String toString() 
	{
		return this.getSymbol()+","+this.getName()+","+this.getPrice()+","+this.getShare();
	}
	
	
	
}
