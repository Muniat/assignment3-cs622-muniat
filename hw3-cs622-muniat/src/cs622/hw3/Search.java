package cs622.hw3;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**  
 *  The purpose of this class is to search for keywords in a file and return some data for the keywords.
 *  It also includes method to store and print the search history.
 *  @author aymanmuniat
 */
public class Search {

	private String fileName;
    private Map<String, List<String>> searchHistory;
    
    public Search() {
    	
        this.fileName = "merged.txt";
        this.searchHistory = new HashMap<>();
    }
    
    
    /**
	 * The purpose of this method is to search the file for a keyword and return some data for the keyword.
	 * The method also stores the searched word and the time it was searched.
	 * @param keyword String to be searched in the file
	 */
    
    public void search(String keyword){
    	
    	BufferedReader reader = null;
    	
    	try {
	
        	reader = new BufferedReader(new FileReader(this.fileName));
        
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
            	//splitting the fields, separated by a comma
            	String[] fields = line.split(",");
            	
            	//checking if there are sufficient number of fields in each line to search through 
            	if(fields.length >= 8) {
            		String category = fields[1]; 
                
            		//regex pattern to match the keyword
            		if (category.toLowerCase().matches(".*\\b" + keyword.toLowerCase() + "\\b.*")) {
            			String fundRaisedPercent = fields[7];
            			String closeDate = fields[4];
            			System.out.println("category: " + keyword 
            			+ ", fund_raised_percent: " + fundRaisedPercent 
            			+ ", close_date: " + closeDate);
            			
            		}
            		
            	}
            }
            
          //gets the current date time from the system clock
            LocalDateTime now = LocalDateTime.now();  
            
            //formats the date in the "dd-MM-yyyy HH:mm:ss" pattern 
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
            String formatDateTime = now.format(format);  
           
            /*if the searchHistory collections has the keyword as key, add the time as its value 
             or add the keyword as the key and the time as its value to the Map */
             
            if (searchHistory.containsKey(keyword)) {
              searchHistory.get(keyword).add(formatDateTime);
            } else {
              List<String> timestamps = new ArrayList<>();
              timestamps.add(formatDateTime);
              searchHistory.put(keyword, timestamps);
            }
    	
        }
    	
    	catch (IOException e) {
            e.printStackTrace();
        }
        
        finally {
        	
        	if(reader != null) {
        		
        		try {
        			reader.close();
        		}
        		catch(IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
    	
    }
    
    /** 
	 * The purpose of this method is to print the date and time a specific keyword was searched
	 */
    
    public void printSearchTime() {
        
        
        for (Map.Entry<String, List<String>> entry : searchHistory.entrySet()) {
          System.out.println("\n Keyword: " + entry.getKey() + " Searched at time: " + entry.getValue());
         
      
       }
        System.out.println("--------------");
    
    
    }
    
    /** 
	 * The purpose of this method is to print the number of times a specific keyword was searched
	 */
    public void printSearchFrequency() {
    	for (Map.Entry<String, List<String>> entry : searchHistory.entrySet()) {
    		System.out.println("\n Keyword: " + entry.getKey() + " Frequency: " + entry.getValue().size());
    	}
    	System.out.println("--------------");
    }

    

   
}
