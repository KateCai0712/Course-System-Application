import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Exercise1 {
	public static void main(String[] args) {
		//Declare variables
		int choice, section, student;
		String name, instructor, location;
		ArrayList<String> info = new ArrayList<String>();
		
		ClassDirectory directory = new ClassDirectory();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("1. Load data from the CSV file (Populate an array list ofcourses) – will be done once.\n"
					+ "2. Add a new course\n"
					+ "3. Edit a course\n"
					+ "4. Display all courses\n"
					+ "5. Search for a course (by course name and section number)\n"
					+ "6. Delete a course (by course and section number)\n"
					+ "7. Sort courses by number of students registered and display them.\n"
					+ "8. Display all courses with number of students above 30 students.\n"
					+ "9. Write data (of the results of menu option# 8) to a new text file\n"
					+ "10. Exist");
			choice = input.nextInt();
			if (choice == 1) {
				String fileName = "courses.txt";
				String line = null;
				boolean isLoaded = false;
				int x = 0;
				
				try {	
					FileReader fileReader = new FileReader(fileName);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					
					while((line = bufferedReader.readLine())!=null)
					{	
						info.add(line);
						x++;
						isLoaded = true;
					}
					bufferedReader.close();
				}
				catch(FileNotFoundException ex){
					System.out.println("file not found");
				}
				catch(IOException ex){
					System.out.println("IO Exception");
					ex.printStackTrace();	
				}
				
				if (isLoaded == true) {
					for(int i=0; i<x; i++) {
						List<String> split = Arrays.asList(info.get(i).split(","));
						name = split.get(0);
						instructor = split.get(1);
						section = Integer.parseInt(split.get(2));
						student = Integer.parseInt(split.get(3));
						location = split.get(4);
						
						ClassEntry entry = new ClassEntry(name, instructor, section, student, location);
						directory.add(entry);
						//System.out.println(directory.classes.get(i).printClassEntry());
					}
					System.out.println(directory.classes.size() + " data are loaded.");
				}
			}else if (choice == 2) {
				System.out.println("Enter info for a new class:\nCourse name, Course instructor, Course section number, Current students, Course location:");
				input.nextLine();
				name = input.nextLine();
				instructor = input.nextLine();
				section = input.nextInt();
				student = input.nextInt();
				input.nextLine();
				location = input.nextLine();
				input.nextLine();
				
				ClassEntry entry = new ClassEntry(name, instructor, section, student, location);
				directory.add(entry);
			}else if (choice == 3) {
				System.out.println("What course do you want to edit (Enter a course name and section number)?");
				input.nextLine();
				name = input.nextLine();
				section = input.nextInt();
				directory.edit(name, section);
				input.nextLine();
			}else if (choice == 4) {
				directory.displayAll();
			}else if (choice == 5) {
				System.out.println("What course do you want to find (Enter a course name and section number)?");
				input.nextLine();
				name = input.nextLine();
				section = input.nextInt();
				directory.search(name, section);
				input.nextLine();
			}else if (choice == 6) {
				System.out.println("What course do you want to delete (Enter a course name and section number)?");
				input.nextLine();
				name = input.nextLine();
				section = input.nextInt();
				directory.delete(name, section);
				input.nextLine();
			}else if (choice == 7) {
				directory.sort();
			}else if (choice == 8) {
				
				ClassEntry[] entry = directory.displayStudentNumberAbove30();
				
				for (int i=0; i<entry.length; i++) {
					System.out.println(entry[i].printClassEntry());
				}
				
			}else if (choice == 9) {
				String fileName = "CoursesWith30OrMoreStudents.txt";
				boolean isWritten = false;
				
				try {
					FileWriter fileWriter = new FileWriter(fileName);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					
					ClassEntry[] entry = directory.displayStudentNumberAbove30();
					for (int i=0; i<entry.length; i++) {
						bufferedWriter.write(entry[i].getName() + "," + entry[i].getInstructor() + "," + entry[i].getSection() + "," + entry[i].getStudentNumber() + "," + entry[i].getLocation() + "\n");
					}
					isWritten = true;
					
					bufferedWriter.close();
				}catch(IOException ex){
					System.out.println("IO Exception. Error writing to file '" + fileName + "'.");
					ex.printStackTrace();	
				}
				if (isWritten == true)
					System.out.println("New data are written in '" + fileName + "'");
			}
		}while(choice != 10);
		
		input.close();
	}
	

}
