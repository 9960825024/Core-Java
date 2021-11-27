package Practise.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentIOOperation implements Serializable {

	public static void WriteToFile(List<Student>students)
	{
		FileOutputStream file=null;
		try {
			file = new FileOutputStream("E:\\javastudentfile\\student.abc");
			ObjectOutputStream out = new ObjectOutputStream(file);
			for (Iterator iterator = students.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				out.writeObject(student);
			}
			
			out.flush();
			out.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

	public static List<Student> readFromFile() throws StudentDBFileNotFound
	{
		List<Student> students = new ArrayList<Student>();
		ObjectInputStream oin=null;
		try {
			FileInputStream	in = new FileInputStream("E:\\javastudentfile\\student.abc");
			oin = new ObjectInputStream(in);
			while(in.available()>0)
				  {
					Student student = ((Student)oin.readObject());
					students.add(student);
				  }
		    }
			catch (FileNotFoundException e) 
			{
				// TODO 'Throw StudentDBFileNotFound'
				throw new StudentDBFileNotFound();
			}
			catch (ClassNotFoundException | IOException e)
			{
				
			}
			finally
			{   try 
			     {
				if(oin !=null)
				  oin.close();}
			      catch(IOException i)
			      {
				  System.out.println(i);
			       }

			}
	
			return students;
	
		}
}

