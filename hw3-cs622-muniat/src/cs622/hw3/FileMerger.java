package cs622.hw3;

import java.io.*;

/**  
 *  The purpose of this class is to merge the content of multiple files into one single file
 *  @author aymanmuniat
 */

public class FileMerger {
	
	private String outputFile;
	private File[] files;
	
	public FileMerger() {
		
		this.outputFile = "merged.txt";
		
		//returning an array of all the csv files in this directory
		this.files = new File(".").listFiles((dir, name) -> name.endsWith(".csv"));
	}
	
	/** 
	 * The purpose of this method is to read the content of multiple csv files and merge them into one text file
	 */
	public void mergeFiles() {
		
		FileWriter writer = null;
		
		try {
            writer = new FileWriter(this.outputFile);
            
          //reads each file line by line and writes each line to 'merged.txt'
            for (File file : files) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line + "\n");
                    }
                } 
                catch (IOException e) {
                    e.printStackTrace();
                } 
                finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } 
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        } 
        
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } 
                
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

}
