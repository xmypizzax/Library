package guiTest;

import java.util.ArrayList;

public class Library implements ILibrary { //class of the group of books the library has
	
	//similar structure to people class
	
	private ArrayList<IBook> books; //has all of the books
	private int id = 1; //doing this so i can add id anywhere, like in People() and addMember()
	
	public Library() {
		books = new ArrayList<IBook>();
		books.add(new Book(id, "fiction", "The Hunger Games", true));id++;
		books.add(new Book(id, "nonfiction", "The Great Gatsby", true));id++;
		books.add(new Book(id, "textbook", "AP Calculus", true));id++;
		books.add(new Book(id, "nonfiction", "The Lord Of The Rings", true));id++;
		books.add(new Book(id, "fiction", "To Kill a MockingBird", true));id++;
	}
	
	public ArrayList<IBook> getBooks() {
		return books;
	}
	
	public IBook getBook(String m) { //gets book by name
		for (int x = 0; x < books.size();x++) {
			if (m.equals(books.get(x).getTitle())) {
				return books.get(x);
			}
		}
		return null;
	}
	
	public IBook getBook(int i) { //gets book by id
		for (int x = 0;x < books.size();x++) {
			if (books.get(x).getId() == i) {
				return books.get(x);
			}
		}
		return null;
	}
	
	public String findBookName(int i) { //given id, gets name
		for (int x = 0;x < books.size();x++) {
			if (books.get(x).getId() == i) {
				return books.get(x).getTitle();
			}
		}
		return "ERROR, MEMBER NOT FOUND";
	}
	
	public int findBookId(String name) { // given name, gives id
		for (int x = 0;x < books.size();x++) {
			if (books.get(x).getTitle().equals(name)) {
				return books.get(x).getId();
			}
		}
		return 0;
	}
	
	public void bookExchange(Book b , int i) { //basically part two to bookExchange
		for (int x = 0;x < books.size();x++) {
			if (books.get(x).getId() == b.getId()) {
				books.get(x).changePossession(i);
			}
		}
	}
	
	public void reserveBook(Member m, Book b) { //reserves book so no one else can take it
		for (int x = 0;x < books.size();x++) {
			if (b.getId() == books.get(x).getId()) {
				b.reserveBook(m.getId());
			}
		}
	}
	
	public void removeBook(Book b) { //removes and resorts library
		books.remove(b);
		sort();
	}
	
	public void sort() { //sorts library by id
		ArrayList<IBook> copy = books;
		ArrayList<IBook> temp = new ArrayList<IBook>();
		int s = books.size();
		for (int x = 0; x < s; x++) {
			int i = Integer.MAX_VALUE;
			IBook b;
			for (int y = 0; y < copy.size(); y++) {
				if (copy.get(y).getId() < i) {
					i = copy.get(y).getId();
				}
			}
			b = getBook(i);
			temp.add(b);
			copy.remove(b);
		}
		books = temp;
	}
	
}
