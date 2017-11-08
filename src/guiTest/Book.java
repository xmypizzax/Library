package guiTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Book implements IBook { //details on the book
	
	private int id; //assigned id
	private String typeOfBook; //fiction , nonfiction, or textbook (textbook only accessible by teacher)
	private String title; //title of book
	private Date dueDate; //when issued to a member, will have a due date
	private boolean atLibrary; //determines if at library, true == atlibrary; false == notAtLibrary
	private int reserve; //acts as a boolean to determine if reserved, which id reserved it
	
	public Book(int i, String ty, String ti, boolean b) {
		id = i;
		typeOfBook = ty;
		title = ti;
		atLibrary = b;
		reserve = -1;
	}
	
	public int getId() {
		return id;
	}
	
	public String getType() {
		return typeOfBook;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public boolean getAtLibrary() {
		return atLibrary;
	}
	
	public boolean bookAvailability(int i) { //checks if available to person who requested it
		return reserve == -1 || reserve == i;
	}
	
	public void reserveBook(int i) {  //reserves book
		reserve = i;
	}
	
	public void changePossession(int i) { //changes if at library, disables reserve if returned to library by person who reserved it
		atLibrary = !atLibrary;
		if (atLibrary && reserve == i) {
			reserve = -1;
		}
	}
	
	public void setDueDate(boolean t) { //sets dueDate when issued book, default is 14 days (24 days for teachers) from current date
		Date temp = Tester.getCurrentDate();
		int i = 14; if (t) { i *= 2; }
		temp = addDays(temp, i);
		dueDate = temp;
	}
	
	public void resetDueDate() { //gets rid of the due date when returned
		dueDate = null;
	}
	
	public Date addDays(Date date, int days) { //advances time
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
	
}
