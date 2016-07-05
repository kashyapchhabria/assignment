
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Assignment1 {
	static HashMap<String, Integer> ageStats = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// /home/kashyap/Downloads/assignment1.csv
		readFile(args[0]);
		
	}

	public static HashMap<String, Integer> readFile(String csvFile) {
		BufferedReader br = null;
		String line = "";
		String deLimiter = ",";
		String[] rows;
		String age;
		int count;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				rows = line.split(deLimiter);
				age = rows[1];
				count = ageStats.containsKey(age) ? ageStats.get(age) : 0; //if age present get the value or keep as 0
				ageStats.put(age, count + 1);
			}
			br.close();
			writeFile();
		}

		catch (FileNotFoundException e) {
			System.err.println("File not found");
		}

		catch (IOException e) {
			System.err.println("Output file error");
		}
		return ageStats;

	}

	public static void writeFile() {
		String eol = System.getProperty("line.separator");
		try (Writer writer = new FileWriter("output.csv")) {
			writer.append("Age").append(',').append("No of people with same age").append(eol);
			for (Entry<String, Integer> entry : ageStats.entrySet()) {
				String value = String.valueOf(entry.getValue());
				writer.append(entry.getKey()).append(',').append(value).append(eol);
			}
			System.out.print("Output file generated");
		} catch (IOException ex) {
			System.out.println("output file error");
		}
	}
}
