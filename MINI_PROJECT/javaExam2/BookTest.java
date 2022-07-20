package javaExam2;

import java.util.Scanner;



public class BookTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 번호 : ");
		String bookNo = sc.next();
		System.out.print("도서 제목 : ");
		String bookTitle = sc.next();
		System.out.print("저자 : ");
		String bookAuthor = sc.next();
		System.out.print("발행 연도 : ");
		String bookYear = sc.next();
		System.out.print("가격 : ");
		int bookPrice = sc.nextInt();
		System.out.print("출판사 : ");
		String bookPublisher = sc.next();
		
		BookDTO bookdto = new BookDTO();
		bookdto.setBookNo(bookNo);
		bookdto.setBookTitle(bookTitle);
		bookdto.setBookAuthor(bookAuthor);
		bookdto.setBookYear(bookYear);
		bookdto.setBookPrice(bookPrice);
		bookdto.setBookPublisher(bookPublisher);
		
		BookDAO dao = new BookDAO();
		dao.insertBook(bookdto);
		dao.selectBook();
	
	}

}
