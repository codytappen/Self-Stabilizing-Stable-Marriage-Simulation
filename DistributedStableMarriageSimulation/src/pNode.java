import java.util.*;

public abstract class pNode {
	
	//Holds preference order of other nodes by id
	//0 is highest pref, n is lowest
	public ArrayList<Integer> pref;
	public int id;//Its own id
	public int currentPref;//Counter for who it is currently paired w/
	public boolean married;
	
	//Creates a default random node based on the number of possible 
	//partners and its own id number
	pNode(int n, int ident)
	{
		
		pref=new ArrayList<Integer>(n);
		id=ident;
		married=false;
		currentPref=0;
		
		//Constructs a list of all ids
		ArrayList<Integer> tempId = new ArrayList<Integer>();
		for(int i=0; i < n; i++)
		{
			tempId.add(i);
		}
		//System.out.println(tempId);
		
		
		//Randomly creates pref from these ids
		for(int i=0; i < n; i++)
		{
			//Finds Random id
			int tempInt =(int)((tempId.size())*(Math.random()));
			
			//Sets random id for preference
			pref.add(tempId.get(tempInt));
			
			//Deletes that id from possible options in next list
			tempId.remove(tempInt);
			
		}
		//System.out.println(pref);
		
		
		
	}
	
	public void divorce()
	{
		married=false;
		currentPref++;
	}

	
}
