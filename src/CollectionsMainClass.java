import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.InputMismatchException;


public class CollectionsMainClass {
	
	private static Scanner scnr;
//	private static Set<String> VALID_YES = new HashSet<>(Arrays.asList("yes", "y", "yeah", "ok", "sure"));
//	private static Set<String> VALID_NO = new HashSet<>(Arrays.asList("no", "n", "nope", "nah"));
	private static Map<String, Double> items = new TreeMap<>();
//	private static List<String> orderName = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();
	private static List<String> orderSelection = new ArrayList<>();
	private static boolean stillSelecting = true;
	
	public static void main(String[] args) {
		scnr = new Scanner (System.in);
		fillItemsMap();
		printMenu();
		menuSelection();
		orderCalc();
		
		
		scnr.close();
	}
	
	private static void fillItemsMap() {
		items.put("apple", 0.99);
		items.put("banana", 0.59);
		items.put("cauliflower", 1.59);
		items.put("dragonfruit", 2.19);
		items.put("elderberry", 1.79);
		items.put("figs", 2.09);
		items.put("grapefruit", 1.99);
		items.put("honeydew", 3.49);
		
		
	}
	
	private static void printMenu() {
		System.out.printf("%-16s" + "Price\r\n", "Item");
		System.out.println("=====================");
			for (Map.Entry<String, Double> entry : items.entrySet()) {
				System.out.printf("%-10s" + "\t$" + entry.getValue() + "\r\n", entry.getKey());
			}
		System.out.println("=====================");
	}
	
	private static void menuSelection () {
		while (stillSelecting) 
		{
			System.out.println("What item would you like to order? ");
			String itemName = scnr.nextLine();
			
			while (items.containsKey(itemName) && stillSelecting) { //checks if input matches menu
			orderSelection.add(itemName.toLowerCase());
			orderPrices.add(items.get(itemName));
			Double itemPrice = items.get(itemName.toLowerCase());
			System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
			while (true) {
			System.out.println("Would you like to order another item? (y/n)");
			String orderAnother = scnr.nextLine();
				if (orderAnother.equalsIgnoreCase("y")){
					printMenu();
					break;
					
				} else if (orderAnother.equalsIgnoreCase("n")) {
					stillSelecting = false;
					break;
					
				} else {
					System.out.println("Please make a valid entry.");	
				}
			} break;
			}
			while ((!items.containsKey(itemName) && stillSelecting)) {
			printMenu();
			System.out.print("Order entry invalid. "); //outputs if input does not match menu
			break;
			}
		}
	}
	
	private static void orderCalc() {
		double total = 0;
		double averagePrice = 0;
		System.out.println("Thanks for your order!\r\nHere's what you got:\r\n=====================");
		for (int i = 0; i < orderSelection.size(); i++) {
//		System.out.println(orderSelection.get(i) + " $" + items.get(orderSelection.get(i)));
		System.out.printf("%-15s" + " $" + items.get(orderSelection.get(i)) + "\r\n", orderSelection.get(i));
		double itemPrice = orderPrices.get(i);
		total += itemPrice;
		averagePrice = (total / orderSelection.size());
		}
		System.out.println("=====================\r\n" + "Average price per item in order was " + averagePrice);
	}
	
	
//	public static boolean getYesNo(Scanner scnr, String prompt) {
//		while (true) {
//			String userInput = getString(scnr, prompt).toLowerCase();
//			if(VALID_YES.contains(userInput)) {
//				return true;
//			} else if (VALID_NO.contains(userInput)) {
//				return false;
//			} else {
//				System.out.println("Your answer must be yes or no. ");
//			}
//		}
//	}
//	
//	private static String getString(Scanner scnr, String prompt) {
//		System.out.println(prompt);
//		String userInput = scnr.nextLine();
//		return userInput;
//	}
	
}
