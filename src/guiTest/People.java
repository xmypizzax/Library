
package guiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class People implements IPeople { //class of the group of members labeled in the library
	
	private ArrayList<IMember> members; //has all of the members
	private int id = 1; //doing this so i can add id anywhere, like in People() and addMember()
	
	public People() { //default list
		members = new ArrayList<IMember>();
		members.add(new Member("Cameron Newborn", id, false));id++;
		members.add(new Member("Andre Roberts", id, false));id++;
		members.add(new Member("Sawyer Pawyer", id, true));id++;
		members.add(new Member("Eric Rabil", id, false));id++;
		members.add(new Member("Stage Mage", id, true));id++;
	}
	
	public ArrayList<IMember> getMembers() {
		return members;
	}
	
	public IMember getMember(String m) { //gets Member by name
		for (int x = 0; x < members.size();x++) {
			if (m.equals(members.get(x).getName())) {
				return members.get(x);
			}
		}
		return null;
	}
	
	public IMember getMember(int i) { //gets Member by id
		for (int x = 0;x < members.size();x++) {
			if (members.get(x).getId() == i) {
				return members.get(x);
			}
		}
		return null;
	}
	
	public String findMemberName(int i) { //returns name given id
		for (int x = 0;x < members.size();x++) {
			if (members.get(x).getId() == i) {
				return members.get(x).getName();
			}
		}
		return "ERROR, MEMBER NOT FOUND";
	}
	
	public int findMemberId(String name) {//returns id given name
		for (int x = 0;x < members.size();x++) {
			if (members.get(x).getName().equals(name)) {
				return members.get(x).getId();
			}
		}
		return 0;
	}
	
	public void addMember(String n, boolean t) {//adds member given String(Name) and boolean(is teacher?)
		Member mem = new Member(n, id , t);
		members.add(mem);id++;
	}
	
	public void removeMember(int i) {//removes member based on id
		for (int x = 0;x < members.size();x++) {
			if (members.get(x).getId() == i) {
				members.remove(x);
			}
		}
	}
	
	public void bookExchange(Member m, Book b) {// Member is getting book, Library gives book
		if ((b.getType() != "textbook" || m.getIsTeacher()) && (m.getFine() == 0.0) && (Tester.getLibrary().getBook(b.getTitle()).bookAvailability(m.getId())) && (b.getAtLibrary()) && ((m.getMyBooks().size() <= 5) ||  m.getIsTeacher())) {
			for (int x = 0; x < members.size();x++) {
				if (m.getId() == members.get(x).getId()) {
					members.get(x).addBook(b);
					Tester.getLibrary().bookExchange(b , m.getId());
					break;
				}
			}
		}
	}
	
	public void bookExchange(Book b, Member m) {// Library gets book back, Member gives book
		for (int x = 0; x < members.size();x++) {
			if (m.getId() == members.get(x).getId()) {
				for (int y = 0; y < members.get(x).getMyBooks().size(); y++) {
					if (members.get(x).getMyBooks().get(y).equals(b)) {
						members.get(x).removeBook(b);
						Tester.getLibrary().bookExchange(b , m.getId());
						break;
					}
				}
				break;
			}
		}
	}
	
}
