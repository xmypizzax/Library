
package guiTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public interface IPeople { 
	
	public ArrayList<IMember> getMembers();
	
	public IMember getMember(String m);
	
	public IMember getMember(int i);
	
	public String findMemberName(int i);
	
	public int findMemberId(String name);
	
	public void addMember(String n, boolean t);
	
	public void removeMember(int i);
	
	public void bookExchange(Member m, Book b);
	
	public void bookExchange(Book b, Member m);
	
}
