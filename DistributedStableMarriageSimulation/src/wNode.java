
public class wNode extends pNode{

	wNode(int n, int ident) {
		super(n, ident);
	}
	
	//Proposes to someone (by giving their id)
	//returns -1 if happily married
	public int act()
	{
		if(married==true)
			return -1;
		
		return pref.get(currentPref);
	}

}
