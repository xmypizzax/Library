package guiTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Member implements IMember { //details on the Member
	
	private int id; //assigned id
	private String name; //is first/last name combined
	private boolean isTeacher; //true == teacher; false == student
	private ArrayList<Book> myBooks; //all books the person has
	private double fine; //fines for books returned late
	
	public Member(String n, int i, boolean t) {
		name = n;
		id = i;
		isTeacher = t;
		myBooks = new ArrayList<Book>();
		fine = 0.0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstName() { //gets first name
		String str = "";
		for (int x = 0;x < name.length();x++) {
			String s = name.substring(x, x + 1);
			if (s.equals(" ")) {
				break;
			}
			str = str + s;
		}
		return str;
	}
	
	public String getLastName() { //gets last name
		String str = "";
		for (int x = name.indexOf(" ") + 1;x < name.length();x++) {
			String s = name.substring(x, x + 1);
			str = str + s;
		}
		return str;
	}
	
	public boolean getIsTeacher() {
		return isTeacher;
	}
	
	public int getId() {
		return id;
	}
	
	public double getFine() {
		return fine;
	}
	
	public ArrayList<Book> getMyBooks() {
		return myBooks;
	}
	
	public Book getBook(String m) { //gets specific book by name
		for (int x = 0; x < myBooks.size();x++) {
			if (m.equals(myBooks.get(x).getTitle())) {
				return myBooks.get(x);
			}
		}
		return null;
	}
	
	public Book getBook(int i) { //gets specific book by id
		for (int x = 0;x < myBooks.size();x++) {
			if (myBooks.get(x).getId() == i) {
				return myBooks.get(x);
			}
		}
		return null;
	}
	
	public void payFine(double d) { //pays fine
		fine -= d;
	}
	
	public void addBook(Book b) {// adds book
		b.setDueDate(isTeacher);
		myBooks.add(b);
		sort();
	}
	
	public void sort() { //sorts books in order by id
		ArrayList<Book> copy = myBooks;
		ArrayList<Book> temp = new ArrayList<Book>();
		int s = myBooks.size();
		for (int x = 0; x < s; x++) {
			int i = Integer.MAX_VALUE;
			Book b;
			for (int y = 0; y < copy.size(); y++) {
				if (copy.get(y).getId() < i) {
					i = copy.get(y).getId();
				}
			}
			b = getBook(i);
			temp.add(b);
			copy.remove(b);
		}
		myBooks = temp;
	}
	
	public void removeBook(Book b) { //removes book from person, fee applied if late
		for (int x = 0;x < myBooks.size();x++) {
			if (myBooks.get(x).getTitle().equals(b.getTitle())) {
				if (myBooks.get(x).getDueDate().getMonth() < Tester.getCurrentDate().getMonth() || (myBooks.get(x).getDueDate().getMonth() == Tester.getCurrentDate().getMonth() && myBooks.get(x).getDueDate().getDate() < Tester.getCurrentDate().getDate()))  {
					int d = lateDays(myBooks.get(x).getDueDate() , Tester.getCurrentDate());
					fine = fine + 5.00 + (1.25 * d);
				}
				myBooks.remove(x);sort();
				break;
			}
		}
	}
	
	public int lateDays(Date a, Date b) {  //helps calculate days late
		GregorianCalendar calA = new GregorianCalendar();
		GregorianCalendar calB = new GregorianCalendar();
		calA.setTime(a);
		calB.setTime(b);
		int d = 0;
		while(!calA.equals(calB)) {
			calA.add(Calendar.DATE, 1);
			d++;
		}
		System.out.println(d);
		return d;
	}
	
}
