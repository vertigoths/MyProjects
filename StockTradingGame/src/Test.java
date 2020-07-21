import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;





public class Test
{
	
	public static boolean isCompanyExists(String previousLine) 
	{	
		for(int i=0;i<CompanySymbols.values().length;i++) 
		{
			if(previousLine.contains(CompanySymbols.values()[i].toString())) 
			{
				return true;
			}
		}
		
		return false;
	}

	
	public static String extractingFloatNumberFromString(String nextLine) 
	{
		String str="";
		
		nextLine = nextLine.replaceAll("\\D+","");
		
		for(int i=0;i<nextLine.length();i++) 
		{
			str+=nextLine.charAt(i);
			if(i==nextLine.length()-3) 
			{
				str+=".";
			}
		}
		
		nextLine=str;
		
		return nextLine;
	}
	
	
	public static void creatingCompanies(StockMarket stockMarket) throws IOException 
	{
		String previousLine="";
		String currentLine="";
		String nextLine="";
		
		
		
		
		URL nasdaq=new URL("https://www.slickcharts.com/nasdaq100");
		
		System.setProperty("http.agent", "Mozilla/5.0");
		
		Scanner scan=new Scanner(nasdaq.openStream());
		
		while(scan.hasNext()) 
		{
			
			currentLine=scan.nextLine();
			
			
			if(scan.hasNext()) 
			{
				nextLine=scan.nextLine();
			}
			
			
			if(isCompanyExists(previousLine)) 
			{
				nextLine=extractingFloatNumberFromString(nextLine);
				previousLine=previousLine.replace("<td><a href=\"/symbol/", "");
				previousLine=previousLine.replace("</a></td>", "");
				previousLine=previousLine.replace("O&#39;", "");
				previousLine=previousLine.replace("\">", " ");
				String[] array=previousLine.split("\\s+");
				
				
				if(!((array[1].contains("background")) || (array[1].contains("<p>"))))
				{
					Company company=new Company(array[1],array[2],Float.parseFloat(nextLine),stockMarket,0);
					stockMarket.insertCompany(company);
					
				}
			}
			
			
			previousLine=currentLine;
			
		}
		
		scan.close();
	}
	
	
	public static Account readAccountData() throws IOException 
	{
		Account account=new Account("Default",0);
		Scanner file=new Scanner(new File("C:\\Users\\zombi\\Desktop\\Account.txt"),"UTF-8");
		String line="";
		int count=0;
		while(file.hasNext()) 
		{
			
			line=file.nextLine();
			String[] array=line.split(",");
			
			if(count==0)
			{
				account=new Account(array[0],Double.parseDouble(array[1]));
				count=1;
			}
			
			else 
			{
				Company company=new Company(array[0],array[1],Double.parseDouble(array[2]),Double.parseDouble(array[3]));
				account.insertStock(company);
			}
			
		}
		file.close();
		
		return account;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		StockMarket NASDAQ=new StockMarket("NASDAQ");
		
		Account account=readAccountData();

		creatingCompanies(NASDAQ);
		
		
		Company company=NASDAQ.getCompany(20);
		
		
		account.insertStock(company);
		
		
		account.displayStocks();
		
	}

}
