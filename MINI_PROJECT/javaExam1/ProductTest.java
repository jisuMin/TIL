package javaExam1;

import java.util.ArrayList;



public class ProductTest {

	public static void main(String[] args) {		

		ArrayList <ProductDTO> list = new ArrayList<>();
		ProductDTO pt1 = new ProductDTO(100,"노트북",1200000,2021,"삼성");
		list.add(pt1);
		ProductDTO pt2 = new ProductDTO(200,"아이패드",500000,2022,"애플");
		list.add(pt2);
		ProductDTO pt3 = new ProductDTO(200,"마우스",15000,2021,"LG");
		list.add(pt3);
		
		System.out.println("상품번호\t상품명\t가격\t제조년도\t제조\t");
		System.out.println("=====================================");
		
		for(ProductDTO dto:list) {
			System.out.println(dto);
			
		}
		

	}

}
