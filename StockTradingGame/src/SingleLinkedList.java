public class SingleLinkedList<T>
{
	private Node<T> head;
	private Node<T> tail;
	
	public SingleLinkedList() 
	{
		this.head=null;
		this.tail=null;
	}
	
	
	public void insert(T data) 
	{
		Node<T> newNode=new Node<T>(data);
		if(head==null) 
		{
			head=newNode;
			tail=newNode;
		}
		
		else 
		{
			tail.setNext(newNode);
			tail=newNode;
		}
	}
	
	
	public void display() 
	{
		if(head.getData() instanceof Company) 
		{
			if(head!=null) 
			{
				Node<T> temp=head;
				while(temp!=null) 
				{
					Company comp=(Company) temp.getData();
					System.out.println(comp.toString());
					temp=temp.getNext();
				}
	 		}
		}
	}

	
	public boolean search(Company company) 
	{
		
		if(head!=null) 
		{
			if(head.getData() instanceof Company) 
			{
				if(head!=null) 
				{
					Node<T> temp=head;
					while(temp!=null) 
					{
						if(((Company)temp.getData()).getName().equalsIgnoreCase(company.getName()))
						{
							return true;
						}
						
						temp=temp.getNext();	
					}
		 		}
			}
			
			
		}
		
		return false;
	}
	
	
	
	public int size() 
	{
		int count=0;
		
		if(head.getData() instanceof Company) 
		{
			if(head!=null) 
			{
				Node<T> temp=head;
				while(temp!=null) 
				{
					count++;
					
					temp=temp.getNext();	
				}
	 		}
		}
		
		return count;
	}
	
	
	public Company getCompany(int index) 
	{
		int count=0;
		
		if(head.getData() instanceof Company) 
		{
			if(head!=null) 
			{
				Node<T> temp=head;
				while(temp!=null) 
				{
					if(index==count) 
					{
						return (Company)temp.getData();
					}
					
					count++;
					temp=temp.getNext();	
				}
	 		}
		}
		
		return null;
	}
	
}
