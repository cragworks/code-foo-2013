//Calvin Tham IGN CodeFOO
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.corba.se.impl.orbutil.graph.Graph;


public class FamilyTree {


Map <String, Information> personMap; //holds every person with their information

//holds last name (key) to person in the last name (destination),
//basically tells you what people have this last name
Map <String, HashSet<String>> lastNameMap; //lastname set of people to first names

	public FamilyTree()
	{
		personMap = new HashMap<String, Information> (); //the information is basically relationships and people he has relationships with
		lastNameMap = new HashMap<String, HashSet<String>>();
	}
	
	public void addPerson(String fullName)
	{
		personMap.put(fullName, new Information());
		String lastName = fullName.substring(fullName.indexOf(' ')+1);
		
		if(lastNameMap.get(lastName) != null)
			lastNameMap.get(lastName).add(fullName);
		else
		{
			HashSet<String> temp = new HashSet<String>();
			temp.add(fullName);
			lastNameMap.put(lastName, temp);
		}
	}
	
	//Print the persons relationships and to whom.
	public void printPersonStats(String fullName)
	{
		System.out.println("\n"+fullName);
		
		//assuming person exists in graph
		for(String relationship: personMap.get(fullName).inRelationships.keySet())
			System.out.println("-"+relationship+" to "+personMap.get(fullName).inRelationships.get(relationship));
		
		for(String relationship: personMap.get(fullName).outRelationships.keySet())
			System.out.println("-"+personMap.get(fullName).outRelationships.get(relationship)+" is the "+relationship);
	}
	public void printPeopleWithLastName(String lastName)
	{
		lastName = lastName.toUpperCase();
		
		if(lastNameMap.containsKey(lastName))
		{
			for(String fullName : lastNameMap.get(lastName))
				printPersonStats(fullName);
		}
		else
			System.out.println(lastName+" is not in the family tree.");
	}
	
	public boolean checkLastNameExists(String fullName)
	{
		fullName = fullName.toUpperCase();
		String lastName = fullName.substring(fullName.indexOf(' ')+1);
		
		if(lastNameMap.containsKey(lastName))
				if(lastNameMap.get(lastName).contains(fullName))
					return true;
		
		System.out.println(fullName+" is not in the family tree.");
		return false;
	}
	
	public boolean checkPersonIsInMap(String fullName)
	{
		if(personMap.get(fullName.toUpperCase()) == null)
		{
			System.out.println(fullName+" is not in the family tree. You must add them before you can add relationship/search.");
			return false;
		}
		return true;
	}
	
	public void addBrotherSister(String brother, String sister)
	{
		personMap.get(brother).inRelationships.put("BROTHER", sister);
		personMap.get(brother).outRelationships.put("SISTER", sister);
		
		personMap.get(sister).inRelationships.put("SISTER", brother);
		personMap.get(sister).outRelationships.put("BROTHER", brother);
	}
	
	public void addBrotherBrother(String one, String two)
	{
		personMap.get(one).inRelationships.put("BROTHER", two);
		personMap.get(one).outRelationships.put("BROTHER", two);
		
		personMap.get(two).inRelationships.put("BROTHER", one);
		personMap.get(two).outRelationships.put("BROTHER", one);
	}

	public void addSisterSister(String sister, String sister2)
	{
		personMap.get(sister).inRelationships.put("SISTER", sister2);
		personMap.get(sister).outRelationships.put("SISTER", sister2);
		
		personMap.get(sister2).inRelationships.put("SISTER", sister);
		personMap.get(sister2).outRelationships.put("SISTER", sister);
	}
	public void addFatherSon(String father, String son)
	{
		personMap.get(father).inRelationships.put("FATHER", son);
		personMap.get(father).outRelationships.put("SON", son);
		
		personMap.get(son).inRelationships.put("SON", father);
		personMap.get(son).outRelationships.put("FATHER", father);
	}
	
	public void addFatherDaughter(String father, String daughter)
	{
		personMap.get(father).inRelationships.put("FATHER", daughter);
		personMap.get(father).outRelationships.put("DAUGHTER", daughter);
		
		personMap.get(daughter).inRelationships.put("DAUGHTER", father);
		personMap.get(daughter).outRelationships.put("FATHER", father);
	}
	
	public void addMotherSon(String mother, String son)
	{
		personMap.get(mother).inRelationships.put("MOTHER", son);
		personMap.get(mother).outRelationships.put("SON", son);
		
		personMap.get(son).inRelationships.put("SON", mother);
		personMap.get(son).outRelationships.put("MOTHER", mother);
	}
	
	public void addMotherDaughter(String mother, String daughter)
	{
		personMap.get(mother).inRelationships.put("MOTHER", daughter);
		personMap.get(mother).outRelationships.put("DAUGHTER", daughter);
		
		personMap.get(daughter).inRelationships.put("DAUGHTER", mother);
		personMap.get(daughter).outRelationships.put("MOTHER", mother);
	}
	
	public void addHusbandWife(String husband, String wife)
	{
		personMap.get(husband).inRelationships.put("HUSBAND", wife);
		personMap.get(husband).outRelationships.put("WIFE", wife);
		
		personMap.get(wife).inRelationships.put("WIFE", husband);
		personMap.get(wife).outRelationships.put("HUSBAND", husband);
	}
}
