import java.util.*;

public class ClassDirectory {
	Scanner input = new Scanner(System.in);
	
	ArrayList<ClassEntry> classes = new ArrayList<ClassEntry>();
	
	public ClassDirectory() {
	}
	
	public void add(ClassEntry entry) {
		classes.add(entry);
		System.out.println("New class added.");
	}
	public void edit(String name, int section) {
		Boolean isEdited = false;
		
		for(int i=0; i<classes.size(); i++) {
			if(name.equals(classes.get(i).getName()) && section==classes.get(i).getSection()) {
				System.out.println("What course name and instructor name do you want to change to?");
				String courseName = input.nextLine();
				String instructor = input.nextLine();
				input.nextLine();
				
				classes.get(i).setName(courseName);
				classes.get(i).setInstructor(instructor);
				System.out.println("The class is edited.");
				
				isEdited = true;
			}
		}
		if(isEdited != true) {
			System.out.println("ERROR.");
		}
	}
	public void displayAll() {
		System.out.println("The courses are:");
		for (int i=0; i<classes.size(); i++) {
			if (classes.get(i).getName()!=null) {
				System.out.println(classes.get(i).printClassEntry());
			}
		}
	}
	public void search(String name, int section) {
		Boolean isFound = false;
		
		for (int i=0; i<classes.size(); i++) {
			if (name.equals(classes.get(i).getName()) && section==classes.get(i).getSection()) {
				System.out.println(classes.get(i).printClassEntry());
				isFound = true;
			}
		}
		if(isFound == false) {
			System.out.println("ERROR.");
		}
	}
	public void delete(String name, int section) {
		Boolean isDeleted = false;
		
		for (int i=0; i<classes.size(); i++) {
			if (name.equals(classes.get(i).getName()) && section==classes.get(i).getSection()) {
				classes.get(i).setName(null);
				classes.get(i).setInstructor(null);
				classes.get(i).setSection(-1);
				classes.get(i).setStudentNumber(-1);
				classes.get(i).setLocation(null);
				System.out.println("The course info is deleted.");
				isDeleted = true;
			}
		}
		if(isDeleted == false) {
			System.out.println("ERROR.");
		}
	}
	public void sort() {
		for (int i=0;i<classes.size();i++) {
			for (int j=0;j<classes.size();j++) {
				if (classes.get(j).getStudentNumber()>classes.get(i).getStudentNumber()) {
					Collections.swap(classes, j , i);	
				}
			}
		}
		System.out.println("The courses are sorted.");
	}
	public ClassEntry[] displayStudentNumberAbove30() {
		int count = 0; 
		int x = 0;
		
		for (int i=0; i<classes.size(); i++) {
			if (classes.get(i).getStudentNumber()>30) {
				count++;
			}
		}
		//System.out.println("Count: " + count);
		ClassEntry[] entry = new ClassEntry[count];
		
		if (count == 0)
			return null;
		else {
			for (int i=0; i<classes.size(); i++) {
				if (classes.get(i).getStudentNumber()>30) {
					entry[x]=classes.get(i);
					x++;
				}
			}
		}
		return entry;
	}
}
