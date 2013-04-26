import java.util.Scanner;

//Calvin Tham
//IGN CODE FOO
//PROMPT: Write a program that searches a family tree for
//members that match name. How does
//this algorithm scale?

//In this class, I use the Family Tree graph I made
//Ask for input to make the family tree
// ask for full name to find the member in the family tree
//In FamilyTree class, I have a map holding the lastNames to people
//so that's easy to search

public class FamilyTreeTester {
	public static void main(String[]args)
	{
		FamilyTree familyTree = new FamilyTree();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("This program makes a family tree graph based on input. You can then search for a person's full name");
		System.out.println("and view their relationships.");
		
		String input = "";
		
		while(!input.equals("q"))
		{
			System.out.print("\n(p) to add a person, (r) to add a relationship btwn 2 people, (s) to search for a person, (l) print people with this last name, (q) to quit: ");
		
			input = sc.nextLine();
		
			if(input.equals("p"))
				familyTree = addPerson(familyTree);
			else if(input.equals("r"))
				familyTree = addRelationship(familyTree);
			else if(input.equals("s"))
				searchForPerson(familyTree);
			else if(input.equals("l"))
				printPeopleWithLastName(familyTree);
		}
		
	}
	
	public static FamilyTree addPerson(FamilyTree familyTree)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the person's first and last name seperated by a space: ");
		String fullName = sc.nextLine();
		
		familyTree.addPerson(fullName.toUpperCase());
		
		return familyTree;
	}
	
	public static FamilyTree addRelationship(FamilyTree familyTree)
	{
		Scanner sc = new Scanner(System.in);
		String input = "";
		System.out.println("What kind of relationship?");
		System.out.print("Choices are: \"fatherson\" \"motherson\" \"fatherdaughter\" \"motherdaughter\" \"brotherbrother\" \"brothersister\" \"sistersister\" \"husbandwife\": ");
		input = sc.nextLine();
		
		switch(input.toUpperCase())
		{
		case "FATHERSON":
			System.out.print("Enter father full name: ");
			String father = sc.nextLine();
			if(familyTree.checkPersonIsInMap(father) == false)
				break;
			System.out.print("Enter son full name: ");
			String son = sc.nextLine();
			if(familyTree.checkPersonIsInMap(son) == false)
				break;
			
			familyTree.addFatherSon(father.toUpperCase(), son.toUpperCase());
			break;
		case "MOTHERSON":
			System.out.print("Enter mother full name: ");
			String mother = sc.nextLine();
			if(familyTree.checkPersonIsInMap(mother) == false)
				break;
			System.out.print("Enter son full name: ");
			String son2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(son2) == false)
				break;
			
			familyTree.addMotherSon(mother.toUpperCase(), son2.toUpperCase());
			break;
		case "FATHERDAUGHTER":
			System.out.print("Enter father full name: ");
			String father2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(father2) == false)
				break;
			System.out.print("Enter daughter full name: ");
			String daughter = sc.nextLine();
			if(familyTree.checkPersonIsInMap(daughter) == false)
				break;
			
			familyTree.addFatherDaughter(father2.toUpperCase(), daughter.toUpperCase());
			break;
		case "MOTHERDAUGHTER":
			System.out.print("Enter mother full name: ");
			String mother2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(mother2) == false)
				break;
			System.out.print("Enter daughter full name: ");
			String daughter2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(daughter2) == false)
				break;
			
			familyTree.addMotherDaughter(mother2.toUpperCase(), daughter2.toUpperCase());
			break;
		case "BROTHERBROTHER":
			System.out.print("Enter brother1 full name: ");
			String brother1 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(brother1) == false)
				break;
			System.out.print("Enter brother2 full name: ");
			String brother2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(brother2) == false)
				break;
			
			familyTree.addBrotherBrother(brother1.toUpperCase(), brother2.toUpperCase());
			break;
		case "BROTHERSISTER":
			System.out.print("Enter brother full name: ");
			String brother3 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(brother3) == false)
				break;
			System.out.print("Enter sister full name: ");
			String sister1 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(sister1) == false)
				break;
			
			familyTree.addBrotherSister(brother3.toUpperCase(), sister1.toUpperCase());
			break;
		case "SISTERSISTER":
			System.out.print("Enter sister1 full name: ");
			String sister2 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(sister2) == false)
				break;
			System.out.print("Enter sister2 full name: ");
			String sister3 = sc.nextLine();
			if(familyTree.checkPersonIsInMap(sister3) == false)
				break;
			
			familyTree.addSisterSister(sister2.toUpperCase(), sister3.toUpperCase());
			break;
		case "HUSBANDWIFE":
			System.out.print("Enter husband full name: ");
			String husband = sc.nextLine();
			if(familyTree.checkPersonIsInMap(husband) == false)
				break;
			System.out.print("Enter wife full name: ");
			String wife = sc.nextLine();
			if(familyTree.checkPersonIsInMap(wife) == false)
				break;
			
			familyTree.addHusbandWife(husband.toUpperCase(), wife.toUpperCase());
			break;
		}
		
		return familyTree;
	}
	
	public static void searchForPerson(FamilyTree familyTree)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the person's first and last name seperated by a space: ");
		String fullName = sc.nextLine().toUpperCase();
		
		if(familyTree.checkLastNameExists(fullName))
			familyTree.printPersonStats(fullName);
		
	}
	
	public static void printPeopleWithLastName(FamilyTree familyTree)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the last name: ");
		String lastName = sc.nextLine().toUpperCase();
		
		familyTree.printPeopleWithLastName(lastName);
		
	}
}
