import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = bufferedReader.readLine();
				String names[] = studentNames.split(",");
				for (String name : names) {
					System.out.println(name);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	     else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = bufferedReader.readLine();
				System.out.println(studentNames);
				String names[] = studentNames.split(",");
				Random random = new Random();
				int randomValue = random.nextInt();
				System.out.println(names[randomValue]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
		 else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("students.txt", true));
				String name = args[0].substring(1);
				Date date = new Date();
				String dateForm = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateForm);
				String formatDate = dateFormat.format(date);
				bufferedWriter.write(", " + name + "\nList last updated on " + formatDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		}
		 else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentName = bufferedReader.readLine();
				String names[] = studentName.split(",");
				boolean done = false;
				String name = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (names[index].equals(name)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} 
		else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader= new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = bufferedReader.readLine();
				char names[] = studentNames.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char ch : names) {
					if (ch == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + names.length);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
		else{
			System.err.println("Invalid number of argument");
			System.err.println("Exiting programme");
			System.exit(1);
		}
	}
}