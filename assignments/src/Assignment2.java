import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Assignment2 {
	static Map<String, List<String>> colgDetails = new HashMap<String, List<String>>();
	static List<String> tempArray = new ArrayList<String>();
	static List<String> comCourse = new ArrayList<String>();

	public static void main(String[] args) {
		// /home/kashyap/Downloads/assignment2.csv
		readFile(args[0]);

		findCommon(); //Finds common courses

		writeFile(); 
	}

	public static Map<String, List<String>> readFile(String csvFile) {
		BufferedReader br = null;
		String line = "";
		String deLimiter = ",";
		String[] rows;
		String college, course;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				rows = line.split(deLimiter);
				college = rows[2];
				course = rows[1];
				if (colgDetails.containsKey(college) == true) {
					tempArray = colgDetails.get(college);
					if (tempArray.contains(course) == false)
						tempArray.add(course);
					colgDetails.put(college, tempArray);
				} else {
					tempArray.removeAll(tempArray);
					tempArray.add(course);
					colgDetails.put(college, tempArray);
				}

			}
			br.close();
			return colgDetails;
		}

		catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write failed");
		}

		return colgDetails;
	}

	public static void findCommon() {
		for (Entry<String, List<String>> entry : colgDetails.entrySet()) {
			tempArray = entry.getValue();
			comCourse.retainAll(tempArray);
		}

	}

	public static void writeFile() {
		String eol = System.getProperty("line.separator");
		try (Writer writer = new FileWriter("output2.csv")) {
			writer.append("Course").append(',').append("courses available").append(eol);
			for (Entry<String, List<String>> entry : colgDetails.entrySet()) {
				tempArray = (entry.getValue());
				String value = tempArray.stream().collect(Collectors.joining(" and "));
				writer.append(entry.getKey()).append(',').append(value).append(eol);
			}
			String value = comCourse.stream().collect(Collectors.joining(" and "));
			writer.append(eol).append("Common Courses ").append(',').append(value).append(eol);

			System.out.print("Output file generated");
		} catch (IOException ex) {
			System.out.println("output file error");
		}
	}

}
