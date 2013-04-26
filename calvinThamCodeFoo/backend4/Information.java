import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//Contains information:
//in nodes
//out nodes
//in edges
//out edges

  public class Information {
	  public Map <String, String> outRelationships; //relationships with other people (relationship, Person)
	  public Map <String, String> inRelationships; //relationships to this person (relationship, Person)
	    
	  //relationships:
	  //brother
	  //sister
	  //mother
	  //father
	  //partner
	  //son
	  //daughter
	  
    public Information()
    {
    	outRelationships = new HashMap <String, String> ();
    	inRelationships = new HashMap <String, String> ();
    }
    
  }