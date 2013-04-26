import java.util.Scanner;

//Calvin Tham
//Generates number of moves to change based on two 3 letter words
public class NumMovesGen {

	public static void main(String[]args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 1st three letter word");
		String firstWord = sc.nextLine().toLowerCase();
		
		while(firstWord.length()!=3)
		{
			System.out.println("That is not a three letter word, reenter the 1st three letter word.");
			firstWord = sc.nextLine().toLowerCase();
		}
		
		System.out.println("Enter the 2nd three letter word");
		String secondWord = sc.nextLine().toLowerCase();
		
		while(secondWord.length()!=3)
		{
			System.out.println("That is not a three letter word, reenter the 2nd three letter word.");
			secondWord = sc.nextLine().toLowerCase();
		}
		
		//max of three moves
		int numMoves = 0;
		System.out.println("\nHow many moves does it take to change '"+firstWord+"' to '"+secondWord+"'?");
		System.out.print(firstWord);
		
		for(int c = 0; c < firstWord.length(); c++)
			if(firstWord.charAt(c) != secondWord.charAt(c))
			{
				numMoves++;
				
				if(c == 0)
					firstWord = secondWord.charAt(c) + firstWord.substring(1);
				else if(c == 1)
					firstWord = firstWord.substring(0, c) + secondWord.charAt(c) + firstWord.substring(c+1,firstWord.length());
				else if(c == 2)
					firstWord = firstWord.substring(0, c) + secondWord.charAt(c);
				
				System.out.print(" -> "+firstWord);
			}
		
		System.out.println(". "+numMoves+" moves.");
	}
	
}
