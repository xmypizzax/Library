package guiTest;

import java.util.ArrayList;

public interface ILibrary {

	public ArrayList<IBook> getBooks();
	
	public IBook getBook(String m);
	
	public IBook getBook(int i);
	
	public String findBookName(int i);
	
	public int findBookId(String name);
	
	public void bookExchange(Book b , int i);
	
	public void reserveBook(Member m, Book b);
	
	public void addBook(Book b);
	
	public void removeBook(Book b);
	
	public void sort();
	
}
