//Calvin Tham
//April 24 2013
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class HighScoreRadixSort {

	public static void main(String[]args)
	{
		Map <Float, LinkedHashSet<String>> highScoresMap = new LinkedHashMap<Float, LinkedHashSet<String>>();
		float[] sortedHighScores = {};
		
		Scanner sc = new Scanner(System.in);
		String input = "e";
		
		while(!input.equals("q"))
		{
			System.out.println("\nType 'e' to enter a highscore, 'h' to view radix sorted highscores, or 'q' to quit");
			input = sc.nextLine();
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			if(input.equals("e"))
			{
				System.out.print("Enter your score (0 to 9,999,999,999): ");
				float score = sc.nextFloat();
				//take out to two decimal places, or this gets to be an issue with sorting
				score*=100;
				score = (float)(int)score;
				score/=100;
				
				sc.nextLine();//remove end of character \n
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				if(name.length()>16)
					name = name.substring(0,16);//16 characters max.
				
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				
				
				LinkedHashSet <String> names = highScoresMap.remove(score);
				if(names == null)
					names = new LinkedHashSet <String> ();
				
				names.add(name);
				highScoresMap.put(score, names);
			}
			else if(input.equals("h"))
			{
				sortedHighScores = checkIfAnyNewHighScores(highScoresMap, sortedHighScores);
				printHighScores(highScoresMap, sortedHighScores);
				
			}
		}
	}
	
	public static void printHighScores(Map<Float, LinkedHashSet<String>> highScoresMap, float[] sortedHighScores)
	{
		System.out.println("------------HIGHSCORE TABLE-------------");
		
		for(int c = sortedHighScores.length-1; c>=0; c--) //needa be reverse since the order is low to high
			for(String name : highScoresMap.get(sortedHighScores[c]))
				System.out.println(String.format("%-30s %1s",sortedHighScores[c],name));
	}
	
	public static float[] checkIfAnyNewHighScores(Map<Float, LinkedHashSet<String>> highScoresMap, float[] sortedHighScores)
	{
		
		//see if any new highscores, if so, gotta add them to the sortedHighScores array and sort them
		if(highScoresMap.size() == 0)
			System.out.print("");
		else if(sortedHighScores.length != highScoresMap.size())
		{
			//make new array with bigger size
			float[] temp = new float[highScoresMap.size()];
			//add old already sorted values back first
			for(int c = 0; c < sortedHighScores.length; c++)
				temp[c] = sortedHighScores[c] * 100; //times 100 for decimal place sorting later
			
			//make set for the new scores
			Set <Float> newScores = new HashSet(highScoresMap.keySet());
			
			//remove old scores from set so all thats left are the new scores
			for(int c = 0; c < sortedHighScores.length; c++)
				newScores.remove(sortedHighScores[c]);
			
			
			//now add new scores to temp
			int lastIndex = sortedHighScores.length;//get index of end of old array
			for(Object score : newScores.toArray())
			{
				temp[lastIndex] = (float)score * 100; //times 100 for decimal place sorting later
				lastIndex++;
			}
			sortedHighScores = temp;

			
		sortedHighScores = radixSort(sortedHighScores);
		
		for(int c = 0; c < sortedHighScores.length; c++)
			temp[c] = sortedHighScores[c] / 100; //divide by 100 to return to original number
		}
		

		return sortedHighScores;
	}
	 
	//Returns number's digit in place, place should be 1, 10, 100...
	 public static int selectDigit (float number, int place)
	 {return (int)((number/place) % 10);}
	  
	 
	 //RADIX SORT!
	 public static float[] radixSort(float[] a) {
	  //make array of ten slots
	  Queue[] array = new LinkedList[10];
	  for(int c = 0; c < array.length;c++)//initialize them
			array[c] = new LinkedList();
		
	  //for every place (10 digit numbers, including 2 decimal places)
		for(int place = 1; place <=1000000000; place *= 10)
		{
		//for each value in array
		for(float number : a)
			array[selectDigit(number, place)].add(number); //put into right bucket
			 
		//for every slot (0 to 9) move back to array a
		int c = 0;
		for(int c2 = 0; c2 < array.length; c2++)
			while(!array[c2].isEmpty())
			{
				a[c] = (Float) array[c2].remove();
				c++;
			}
		}
		
		return a;
	}

	
	
}
