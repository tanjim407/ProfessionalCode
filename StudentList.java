import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	
	public static String getLineFromFile() throws Exception {
        String line =new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_FILE_NAME ))).bufferedReader.readLine();
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
				
				for (String name : getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);) {
					System.out.println(name);
				}
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
	     else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				System.out.println(getLineFromFile());
				String names[] = studentNames.split(Constants.WORDS_SPLIT_REGEX);
				int randomValue = new Random().random.nextInt();
				System.out.println(names[randomValue]);
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA));
		}
		 else if (args[0].contains(Constants.ARG_ADD_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				String name = args[0].substring(1);				
				String formatDate = new SimpleDateFormat( Constants.DATE_FORMAT_PATTERN).format(new Date());
				getFileBufferedWriter().write(Constants.WORDS_SPLIT_REGEX + name + "\n"Constants.MSG_DATA_UPDATED+ "" + formatDate);
				getFileBufferedWriter().close();
			} catch (Exception e) {
			}

			System.out.println(Constants.MSG_LOADED_DATA);
		}
		 else if (args[0].contains(Constants.ARG_FIND_DATA)) {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {

				String studentName = getLineFromFile();
				String names[] = studentName.split(Constants.WORDS_SPLIT_REGEX);
				String name = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (Array.asList(getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)).contains( args[0].substring(1))) {
						System.out.println(Constants.MSG_DATA_FOUND);
					}
					else{
						System.out.println("NOt Found");
					}
				}
			} catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		 }
		
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
				System.out.println(getLineFromFile().split(Constants.WORDS_SPLIT_REGEX).length/2+ Constants.MSG_WORDS_FOUND + names.length);
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