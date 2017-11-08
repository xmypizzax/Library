package guiTest;


import java.util.Date;
import java.util.ArrayList;

public interface IBook {
	
	public int getId();
	
	public String getType();
	
	public String getTitle();
	
	public Date getDueDate();
	
	public boolean getAtLibrary();
	
	public boolean bookAvailability(int i);
	
	public void reserveBook(int i);
	
	public void changePossession(int i);
	
	public void setDueDate(boolean t);
	
	public void resetDueDate();
	
	public Date addDays(Date date, int days);
	
}
