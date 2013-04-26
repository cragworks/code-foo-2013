//Calvin Tham
//April 24 Wednesday IGN Code FOO
//Finished at 3pm!

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Grid {
	String[][] words = null;
	String[][] found = null; //if found this array will be marked
	
	public Grid(String fileName)
	{
		words = readAndFill2dArray(fileName);
		found = new String[words.length][words[0].length];
		
		//fill the found 2d array with spaces
		for(int r = 0; r < found.length; r++)
			for(int c = 0; c < found[0].length; c++)
				found[r][c] = "-";
	}
	
	public void markFound(int r, int c)
	{
		found[r][c] = words[r][c];
	}
	public void print()
	{
		//the word search grid
		for(int r = 0; r < words.length; r++)
		{
			for(int c = 0; c < words[0].length; c++)
				System.out.print(words[r][c]+" ");
			System.out.println();
		}
		System.out.print("\n");
		
		//the word search answers
		for(int r = 0; r < found.length; r++)
		{
			for(int c = 0; c < found[0].length; c++)
				System.out.print(found[r][c]+" ");
			System.out.println();
		}
	}
	
	public String get(int r, int c)
	{
		return words[r][c];
	}
	
	
	//search in direction for letter
	public boolean search(int r, int c, String direction, String word)
	{
		//System.out.println("searching for "+word +direction);
		//if found the word
		
		String letter = "" + word.charAt(0);
	//	System.out.println(word.length());
		switch(direction)
		{
		case "north":
			if(r-1 >= 0)
			{
				if(words[r-1][c].equals(letter))
					if(word.length() == 1)//base case, means at last letter and found it
						return true;
					else
						return search(r-1, c, direction, word.substring(1));
			}
			break;
		case "northeast":
			if(r-1 >= 0 && c+1 < words[0].length)
			{
				if(words[r-1][c+1].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r-1, c+1, direction, word.substring(1));
			}
			break;
		case "east":
			if(c+1 < words[0].length)
			{
				
				if(words[r][c+1].equals(letter))
				{
					//System.out.println("row "+r+"col " +c + word+" "+word.length());
					if(word.length() == 1)//base case
						return true;
					else
						return search(r, c+1, direction, word.substring(1));
				}
			}
			break;
		case "southeast":
			if(r+1 < words.length && c+1 < words[0].length)
			{
				if(words[r+1][c+1].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r, c-1, direction, word.substring(1));
			}
			break;
		case "south":
			if(r+1 < words.length)
			{
				if(words[r+1][c].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r+1, c, direction, word.substring(1));
			}
			break;
		case "southwest":
			if(r+1 < words.length && c-1 >= 0)
			{
				if(words[r+1][c-1].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r+1, c-1, direction, word.substring(1));
			}
			break;
		case "west":
			if(c-1 >= 0)
			{
				if(words[r][c-1].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r, c-1, direction, word.substring(1));
			}
			break;
		case "northwest":
			if(r-1 >= 0 && c-1 >= 0)
			{
				if(words[r-1][c-1].equals(letter))
					if(word.length() == 1)//base case
						return true;
					else
						return search(r-1, c-1, direction, word.substring(1));
			}
			break;
			
		}
		return false;
	}
	
	//find out how large word search is
		//and make 2d array that large
	public String[][] create2DArray(String fileName)
	{
		int colSize = 0;
		Scanner sc = null;
		
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		String line = sc.nextLine();
		line = removeSpaces(line);
		colSize = line.length();
		
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
				
		int rowSize = 0;
		while(sc.hasNextLine() && sc.nextLine().isEmpty() == false)
		rowSize++;
				
		return new String[rowSize][colSize];
	}
	
	public String[][] readAndFill2dArray(String fileName)
	{
		//create 2d array of appropriate size
		String[][] words = create2DArray(fileName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		//place letters into array
		for(int r = 0; r < words.length; r++)
		{
			String line = sc.nextLine();
			line = removeSpaces(line);
			
			for(int count = 0; count < line.length(); count++)
			{
				words[r][count] = "" + line.charAt(count);
			}
		}
		
		sc.close();
		return words;
	}
	
	private String removeSpaces(String line)
	{
		for(int count = 0; count < line.length(); count++)
			if((int)line.charAt(count) == 9) //this is the ascii value of a tab
				line = line.substring(0, count) + line.substring(count+1, line.length());
		return line;
	}
}
