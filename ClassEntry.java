
public class ClassEntry {
	//Declare variables
	private String name;
	private String instructor;
	private int section;
	private int studentNumber;
	private String location;
	
	//Default constructor
	public ClassEntry() {
	}
	//Constructor with name, instructor, section, student number, and location
	public ClassEntry(String name, String instructor, int section, int studentNumber, String location) {
		this.name = name;
		this.instructor = instructor;
		this.section = section;
		this.studentNumber = studentNumber;
		this.location = location;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	//A method that prints all information
	public String printClassEntry() {
		return "Course name: " + name + "\nCourse instructor: " + instructor + "\nCourse section number: " + section + "\nCurrent students: " + studentNumber + "\nCourse location: " + location; 
	}
	
}
