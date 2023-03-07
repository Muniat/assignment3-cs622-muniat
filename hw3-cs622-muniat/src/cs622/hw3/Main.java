package cs622.hw3;

import java.util.Scanner;
/*
* The purpose of this class is to provide a user options to merge files, search for categories and check 
* search term frequency and time stamps.
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Would you like to merge files (yes/no)? : ");
		String mergeOption = scanner.nextLine();
		
		if(mergeOption.equalsIgnoreCase("yes")) {
			
			FileMerger merge = new FileMerger();
			merge.mergeFiles();
			System.out.println("Merging the files...");
		
			System.out.println("\n Would you like to search for categories? (yes/no)");
			
			Search searchFile = new Search();
			String searchKey = scanner.nextLine();
			
			if(searchKey.equalsIgnoreCase("yes")) {
				System.out.println("\n Enter a category name (e.g. animal, travel, education etc.) : ");
				String keyword = scanner.nextLine();
				searchFile.search(keyword);
				System.out.println();
				
				boolean flag = true;
				
				//continue searching while the user keeps on entering valid inputs
				while(flag == true) {
					System.out.println("\n What would you like to do next? Press 1,2 or 3.\n"
						+ "1. Continue searching \n"
						+ "2. Look for most common search terms \n"
						+ "3. Searching times");
				
					String response = scanner.nextLine();
				
					switch(response) {
				
					case("1"):
					
						System.out.println("\n Enter a category name (e.g. animal, travel, education etc.) : ");
						keyword = scanner.nextLine();
						searchFile.search(keyword);
						break;
				    
					case("2"):
						searchFile.printSearchFrequency();
						break;
					
					case("3"):
						searchFile.printSearchTime();
						break;
					
					default:
						System.out.println("Invalid input! Closing the application.");
						flag = false;
						break;
					}
					
				
			   }
			}
			else {
				
				System.out.println("Closing the application");
			}
			
			
		}
		
		else {
			System.out.println("Closing the application");
		}
		
		scanner.close();
	}

}
