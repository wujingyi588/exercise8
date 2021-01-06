package exercise8;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		List<Book> books1 = new ArrayList<Book>();
		Map<String, Book> books2= new HashMap<String, Book>();
		System.out.print("Please enter the number of books: ");
		int n = input.nextInt();
		String index,name,publisher;
        int price;
        
        for (int i = 1;i <= n;i++) {
        	System.out.print("Please enter the "+i+" book index, name, price, publisher: ");
        	index = input.next();
            name = input.next();
            price = input.nextInt();
            publisher = input.next();
            Book book = new Book(index, name, price, publisher);
            books1.add(book);
            books2.put(index, book);
        }
        
        for (int i = 0;i < books1.size();i++) {
        	System.out.println(books1.get(i).getIndex()+" "+books1.get(i).getName()+" "+books1.get(i).getPrice()+" "+books1.get(i).getPublisher());
        }
        
        @SuppressWarnings("rawtypes")
		Iterator iter = books2.entrySet().iterator();
        while(iter.hasNext()){
            @SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iter.next();
            System.out.println("next :" + entry.getKey() + " " + ((Book)entry.getValue()).getIndex()+" "+
            		((Book)entry.getValue()).getName()+" "+((Book)entry.getValue()).getPrice()+" "+((Book)entry.getValue()).getPublisher());
        }
	}

}
class Book{
	private String index; //编号
	private String name;  //名称
	private int price;    //单价
	private String publisher;  //出版社
	
	public Book(String index,String name,int price,String publisher) {
		this.index=index;
		this.name=name;
		this.price=price;
		this.publisher=publisher;
	}
	
	public String getIndex(){
        return this.index;
    }
	
    public String getName(){
        return this.name;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public String getPublisher(){
        return this.publisher;
    }
    
    public void setIndex(String index){
        this.index = index;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setPress(String publisher){
        this.publisher = publisher;
    }
}