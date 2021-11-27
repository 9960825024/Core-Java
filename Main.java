package Practise.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Student>student =null;  // populate student from file
		try {
			student =StudentIOOperation.readFromFile();
		}
		catch (StudentDBFileNotFound e) {
			System.out.println(e);
			student = new ArrayList<Student>(); // empty file create
		}
		System.out.println("*****************MENU*******************");

		boolean choice = true;
		while(choice)
		{
			showmenu();

			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if(choice==false)
				break;

			switch(ch)
			{
			case 1 : 
				for(int i=0;i<student.size();i++)
				{
					System.out.println(student.get(i));
				}
				break;
			case 2 : 
				populatestudentwithmarks(student,sc);
				break;
			case 3 :
				populatestudent(student,sc);
				break;
			case 4 :
				searchstudentname(student, sc);
				break;
			case 5 :
				removestudentname(student, sc);
				break;
			case 6 :
				System.out.println("Removing all student");
				student.removeAll(student);
				break;
			case 7 :
				choice =false;
				break;
			case 8 :
				try {
				StudentIOOperation.WriteToFile(student);
				System.out.println("Data saved!!!!!");
				choice = false;
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			default:
				System.out.println("INVALID OPTION");
				break;
			}    	  
		}
	}

	private static void populatestudent(List<Student> student, Scanner sc) {

		System.out.println("Enter Student name:");
		String name = sc.next();
		System.out.println("Enter student age:");
		int age= sc.nextInt();

		Student stud = new Student(name,age);
		student.add(stud);
	}

	private static void populatestudentwithmarks(List<Student>students,Scanner sc) {

		int [] marks = new int[2];
		System.out.println("Enter Student Name :");
		String name = sc.next();
		System.out.println("Enter Student Age:");
		int age= sc.nextInt();
		System.out.println("Enter Student Marks:");
		for (int i = 0; i < marks.length; i++) {
			marks[i]=sc.nextInt();
		}
		students.add(new Student(name,age,marks));

	}

	private static void showmenu() {

		System.out.println("1.Show All Student");
		System.out.println("2.Add Student (name,age,marks):");
		System.out.println("3.Add Student without marks (name,age):");
		System.out.println("4.Search Student by name :");
		System.out.println("5.Remove Student(name):");
		System.out.println("6.Remove All Students:");
		System.out.println("7.Exit Without Save");
		System.out.println("8.Exit with Save");

	}
    public static void searchstudentname(List<Student>students,Scanner sc)
    {
    	System.out.println("Search...Which name you want from list:");
		String name=sc.next();

		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getName().equalsIgnoreCase(name))
				System.out.println(students.get(i));
		}
    }
    public static void removestudentname(List<Student>students,Scanner sc)
    {
    	System.out.println("Remove Studentname:");
		String n = sc.next();
		Iterator<Student> stud = students.iterator();
		while(stud.hasNext())
			if(stud.next().getName().equalsIgnoreCase(n))
				stud.remove();
    }
}
