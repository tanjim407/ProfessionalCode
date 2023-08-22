import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	
	public static String getLineFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_FILE_NAME )));
        String line = bufferedReader.readLine();
        return line;
    }
	public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter(Constants.STUDENTS_FILE_NAME, true));
    }
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals(Constants.ARG_LIST_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				String studentNames = getLineFromFile();
				String names[] = studentNames.split(Constants.WORDS_SPLIT_REGEX);
				for (String name : names) {
					System.out.println(name);
				}
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
	     else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				String studentNames = getLineFromFile();
				System.out.println(studentNames);
				String names[] = studentNames.split(Constants.WORDS_SPLIT_REGEX);
				Random random = new Random();
				int randomValue = random.nextInt();
				System.out.println(names[randomValue]);
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA));
		}
		 else if (args[0].contains(Constants.ARG_ADD_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				BufferedWriter bufferedWriter = getFileBufferedWriter();
				String name = args[0].substring(1);
				Date date = new Date();
				String dateForm = Constants.DATE_FORMAT_PATTERN;
				DateFormat dateFormat = new SimpleDateFormat(dateForm);
				String formatDate = dateFormat.format(date);
				bufferedWriter.write(Constants.WORDS_SPLIT_REGEX + name + "\n"Constants.MSG_DATA_UPDATED+ "" + formatDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}

			System.out.println(Constants.MSG_LOADED_DATA);
		}
		 else if (args[0].contains(Constants.ARG_FIND_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {

				String studentName = getLineFromFile();
				String names[] = studentName.split(Constants.WORDS_SPLIT_REGEX);
				boolean done = false;
				String name = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (names[index].equals(name)) {
						System.out.println(Constants.MSG_DATA_FOUND);
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		
		
		else if (args[0].contains(Constants.ARG_COUNT_WORDS)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				
				String studentNames = getLineFromFile();
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
				System.out.println(count + Constants.MSG_WORDS_FOUND + names.length);
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else{
			System.err.println("Invalid number of argument");
			System.err.println("Exiting programme");
			System.exit(1);
		}
	}
}