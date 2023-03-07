
Assignment 3 - MET CS 622

The purpose of this assignment is to be able to design a Java program to merge the content of multiple files 
into a single file and to search for a keyword in the merged file. The result of the search will present 
'fund_raised_percent' and 'close_date' for the keyword. The searched word and the time it was searched at gets
stored into a Map.

The FileMerger class:
 This class is used to merge all the CSV files in the present directory into a single text file, 'merged.txt'.
 The method 'mergeFiles()' uses a BufferedWriter to write the contents of each file to the 'merged.txt' file.
 
 The Search class:
  The SearchFiles class is used to search for a keyword in the merged file. It returns the 'fund_raised_percent' 
  and 'close_date' in the merged file that contain the keyword. Additionally, it keeps track of the number of times a 
  keyword was searched and the timestamps of each search in a Map. The 'search' method, which takes a String 
  parameter, keyword, accomplishes this task.
  The 'printSearchTime()' and 'printSearchFrequency()' methods print the timestamps and the search frequency of each keyword
  searched, respectively.

 The Main class:
  The Main class provides the option to the user to merge files, search for a specific keyword and print the search
  history details by using the FileMerger and Search classes.
  
 Requirements

1. Java 8 or later

How to Run

1. Download the project. 
2. Open your preferred IDE (Eclipse preferably).
3. Choose File > Open Projects from File System then specify the directory of this project.
4. Compile the Java files, run the Main class.
5. Follow along with the user prompts. 
The result (depending on the provided answer) is displayed on the console.
