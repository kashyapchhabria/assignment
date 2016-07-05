import java.util.*;

public final class Assignment3 {

	static HashSet<Integer> randArray = new HashSet<Integer>();

	public static final void main(String[] args) {

		Random randomGenerator = new Random();
		int count = 1;
		while (count < 100) {
			int randomInt = randomGenerator.nextInt(1000);
			if (randArray.contains(randomInt) == false) {
				randArray.add(randomInt);
				count++;
			}
		}
		System.out.println(randArray);
		System.out.println("enter the number to ne searched : ");
		Scanner sc = new Scanner(System.in);
		int srchElement = sc.nextInt();
		searchElement(randArray, srchElement);
		sc.close();
	}

	public static boolean searchElement(HashSet<Integer> randArray, int srchElement) {
		TreeSet<Integer> sorted = new TreeSet<Integer>();
		sorted.addAll(randArray);
		if (sorted.contains(srchElement) == true) {
			System.out.println((sorted).lower(srchElement));
			System.out.println((sorted).higher(srchElement));
			return true;
		} else {
			System.out.println("not found");
			return false;
		}
	}

}
