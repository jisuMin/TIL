package day4_Test;
class Book {
 private String title;
 private int price;
 
Book(String title, int price) {
 this.title = title;
 this.price = price;
}
Book() {
}

public String getTitle() {
 return title;
}
public void setTitle(String title) {
 this.title = title;
}
public int getPrice() {
 return price;
}
public void setPrice(int price) {
 this.price = price;
}
}

class BookMgr {
	 Book[] a = new Book[5];

	 public BookMgr(Book[] booklist) {
	  this.a = booklist;
	 }
	 
	 void printBooklist(){
	  for(int i=0;i<a.length;i++){
	   System.out.println(a[i].getTitle());
	  }
	 }
	 void printTotalPrice(){
	  int sum = 0;
	  for(int i=0;i<a.length;i++){
	   sum += a[i].getPrice();
	  }
	  System.out.println("전체 책 비용 = "+sum);
	 } 
	}



public class BookStore {

	public static void main(String[] args) {
		Book booklist[] = new Book[5];

		Book book1 = new Book("Java Program", 25000);
		Book book2 = new Book("JSP Program", 15000);
		Book book3 = new Book("SQL Fundamentals", 30000);
		Book book4 = new Book("JDBC Program", 28000);
		Book book5 = new Book();
		book5.setTitle("EJB Program");
		book5.setPrice(34000);
		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;
		
		BookMgr mgr = new BookMgr(booklist);
		System.out.println("=== 책 목록 ===");
		mgr.printBooklist();
		System.out.println("");
		System.out.println("=== 책 가격의 총합 ===");
		mgr.printTotalPrice();
	}

}
