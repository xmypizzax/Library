package guiTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public interface IMember {
	
	public String getName();
	
	public String getFirstName();
	
	public String getLastName();
	
	public boolean getIsTeacher();
	
	public int getId();
	
	public double getFine();
	
	public ArrayList<Book> getMyBooks();
	
	public Book getBook(String m);
	
	public Book getBook(int i);
	
	public void payFine(double d);
	
	public void addBook(Book b);
	
	public void sort();
	
	public void removeBook(Book b);
	
	public int lateDays(Date a, Date b);
	
}
