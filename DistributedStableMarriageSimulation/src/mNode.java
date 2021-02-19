
public class mNode extends pNode{

	mNode(int n, int ident) {
		super(n, ident);
	}
	
	//Determines says whether node marries the suitor
	//Returns alternate WomenId to marry and sameWomenId to decline
	//-1 Means this is the first marriage
	//Updates the currentPref to match current partner
	public int except(int suitorId)
	{
		if(married==false)
		{
			
			currentPref=pref.indexOf(suitorId);
			return -1;
		}
		
		if(pref.indexOf(suitorId) < pref.indexOf(currentPref))
		{
			int oldPartner=currentPref;
			currentPref=pref.indexOf(suitorId);
			return oldPartner;
		}else
			return suitorId;
			
		
	}
}
