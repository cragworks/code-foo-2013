//Calvin Tham
//April 24 Wednesday IGN Code FOO
//Finished at 3pm!

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class WordSearch {
	
	public static void main(String[]args)
	{
		String fileName = "word-search.txt";
		
		//grid contains the wordsearch 2d array
		Grid grid = new Grid(fileName);
		
		ArrayList <String> wordsToSearch = addWordsToSearch(fileName);
		
		//search for words
		while(!wordsToSearch.isEmpty())
		{
			String wordToSearch = wordsToSearch.remove(0);
			
			for(int r = 0; r < grid.words.length; r++)
				for(int c = 0; c < grid.words[0].length; c++)
					if(grid.get(r, c).equals(""+wordToSearch.charAt(0))) //go through row and see if any letter matches first letter of word to search
					{	
						if(grid.search(r, c, "north", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r-count, c);
						}
						else if(grid.search(r, c, "northeast", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r-count, c+count);
						}
						else if(grid.search(r, c, "east", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r, c+count);
						}
						else if(grid.search(r, c, "southeast", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r+count, c+count);
						}
						else if(grid.search(r, c, "south", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r+count, c);
						}
						else if(grid.search(r, c, "southwest", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r+count, c-count);
						}
						else if(grid.search(r, c, "west", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r, c-count);
						}
						else if(grid.search(r, c, "northwest", wordToSearch.substring(1)))
						{
							for(int count = 0; count < wordToSearch.length(); count++)
								grid.markFound(r-count, c-count);
						}
					}			
			}
		
		//print the crossword and the answers
		grid.print();
	}
	//gets words to search and put into arraylist
	public static ArrayList <String> addWordsToSearch(String fileName)
	{
		ArrayList <String> wordsToSearch = new ArrayList<String>();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		//get to the words to search
		while(sc.hasNextLine() && !sc.nextLine().equals("Words to find:"));
		
		while(sc.hasNextLine())
			wordsToSearch.add(sc.nextLine().toLowerCase());
		
		return wordsToSearch;
	}
	
	
}
