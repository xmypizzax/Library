package guiTest;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tester { //main method spot
	//need to be static, so I can get them at any class
	private static Date currentDate;
	private static IPeople people;
	private static ILibrary library;
	
	//runs program
	public static void main(String[] args) {
		currentDate = new Date(118, 0, 1);
		people = new People();
		library = new Library();
		/*Date a = new Date(117, 9, 24);
		//ArrayList<Member> one = people.getMembers();
		//ArrayList<Member> two = people.sortByName();
		//ArrayList<Member> three = people.sortByRank();
		//ArrayList<Member> four = people.sortByDues();
		//printM(four);
		people.bookExchange(people.getMember(1), library.getBook("The Lord Of The Rings"));
		library.reserveBook(people.getMember(2), library.getBook("The Lord Of The Rings"));
		printB(library.getBooks());
		printM(people.getMembers());
		people.bookExchange(people.getMember(1).getBook("The Lord Of The Rings"), people.getMember(1));
		printB(library.getBooks());
		printM(people.getMembers());
		people.bookExchange(people.getMember(3), library.getBook("The Lord Of The Rings"));
		printB(library.getBooks());
		printM(people.getMembers());*/
	}
	
	public static Date getCurrentDate() {
		return currentDate;
	}
	
	public static IPeople getPeople() {
		return people;
	}
	
	public static ILibrary getLibrary() {
		return library;
	}
	
	public static void advanceTime(int days) { //advances time
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(currentDate);
		cal.add(Calendar.DATE, days);
		System.out.println(cal.getTime());
		currentDate = cal.getTime();
	}
	
	/*//just ways for me to test who has what
	public static void printM(ArrayList<Member> members) {
		String str = "";
		for (int x = 0; x < members.size();x++) {
			str = str + members.get(x).getName() + " , " + members.get(x).getId() + " , " + members.get(x).getIsTeacher() + " , " + members.get(x).getFine();
			if (members.get(x).getMyBooks().size() > 0) {
				str = str + print(members.get(x).getMyBooks());
			}
			str = str + " ;     ";
		}
		System.out.println(str);
	}
	
	public static void printB(ArrayList<Book> books) {
		String str = "";
		for (int x = 0; x < books.size();x++) {
			if (books.get(x).getAtLibrary()) {
				str = str + books.get(x).getTitle() + " , " + books.get(x).getId() + " , " + books.get(x).getType() + " , " + books.get(x).getDueDate() + " , " + books.get(x).getAtLibrary() + " ;     ";
			}
		}
		System.out.println(str);
	}
	
	public static String print(ArrayList<Book> books) {
		String str = "";
		for (int x = 0; x < books.size();x++) {
			str = str + "( " + books.get(x).getTitle() + " , " + books.get(x).getId() + " , " + books.get(x).getType() + " , " + books.get(x).getDueDate() + " , " + books.get(x).getAtLibrary() + " )";
		}
		return str;
	}*/
	
}
