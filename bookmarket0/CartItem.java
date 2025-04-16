package bookmarket0;

public class CartItem {
	private String[] itemBook = new String[7];
	private String bookId;
	private int quantity;
	private int totalPrice;
	
	public CartItem() {
	
	}
	
	public CartItem(String[] book) {
		this.itemBook = book;
		this.bookId = book[0];
		this.quantity = 1;
		updateTotalPrice();
	}
	
	public String[] getItemBook() {
		return itemBook;
	}
	
	public void setItemBook(String[] itemBook) {
		this.itemBook = itemBook;
	}
	
	public String getBookID() {
		return bookId;
	}
	public void setBookID(String bookID) {
		this.bookId = bookID;
		this.updateTotalPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void updateTotalPrice() {
		totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
	}

}
