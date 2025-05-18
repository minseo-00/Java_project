package bookmarket0;

public class Cart implements CartInterface {
	
	static final int NUM_BOOK = 3;
	CartItem[] mCartItem = new CartItem[NUM_BOOK];
	static int mCartCount = 0;
	
	public Cart() {
		// 기본 생성자
	}

	public void printBookList(Book[] booklist) {
		for (int i = 0; i < booklist.length; i++) {
			System.out.print(booklist[i].getBookId() + " | ");
			System.out.print(booklist[i].getName() + " | ");
			System.out.print(booklist[i].getUnitPrice() + " | ");
			System.out.print(booklist[i].getAuthor() + " | ");
			System.out.print(booklist[i].getDescription() + " | ");
			System.out.print(booklist[i].getCategory() + " | ");
			System.out.print(booklist[i].getReleaseDate() + " | ");
			System.out.println("");
		}
	}
	
	public void insertBook(Book book) {
		mCartItem[mCartCount++] = new CartItem(book);
	}
	
	// 장바구니 전체 비우기 (모두 삭제)
	public void deleteBook() {
		mCartItem = new CartItem[NUM_BOOK];
		mCartCount = 0;
	}
	
	public void printCart() {
		System.out.println("장바구니 상품 목록: ");
		System.out.println("-----------------------------------");
		System.out.println("    도서ID \t|    수량 \t|    합계");
		
		for(int i = 0; i < mCartCount; i++) {
			System.out.print("   "+mCartItem[i].getBookID()+ "\t|");
			System.out.print("   "+mCartItem[i].getQuantity()+ "\t|");
			System.out.print("   "+mCartItem[i].getTotalPrice());
			System.out.println("");
		}
		System.out.println("-----------------------------------");
	}

	// 도서ID가 장바구니에 있는지 확인, 있으면 수량 1 증가
	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		for(int i = 0; i < mCartCount; i++) {
			// 문자열 비교 시 equals() 사용
			if(bookId.equals(mCartItem[i].getBookID())) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}
	
	// numId 위치의 항목 삭제
	public void removeCart(int numId) {
		CartItem[] cartItem = new CartItem[NUM_BOOK];
		int num = 0;
		
		for(int i = 0; i < mCartCount; i++) {
			if(numId != i) {
				cartItem[num++] = mCartItem[i];
			}
		}
		
		mCartCount = num;
		mCartItem = cartItem;
	}
}
