import java.util.*;

//Main class of the algorithm
//Responsible for the actual running of all these functions
public class SimuClass {

	public static void main(String[] args) {
		
		
		
		
		
		//Allows user to set the desired values for the test
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the desired n(number of each sex)");
		int halfGroupSize=in.nextInt();

		//Creates a fixed size array of women nodes
		wNode[] women = new wNode [halfGroupSize];
		
		//Initializes them with their id and random preference
		for(int i = 0; i < women.length;i++)
			women[i]=new wNode(women.length,i);
		
		//Creates a fixed size array of men nodes
		mNode[] men = new mNode [halfGroupSize];
		
		//Initializes them with their id and random preference
		for(int i = 0; i < men.length;i++)
			men[i]=new mNode(men.length,i);
		
		
		int counterForMainRounds=0;
		
		//Loop of main algorithm
		while(true)
		{
			//System.out.println("main algorithm run");
			counterForMainRounds++;
			
			//Creates a list for the 
			ArrayList<Integer> activeWomenId=new ArrayList<Integer>();
			
			//Checks for active wNodes and if none are present ends
			boolean algorithmRunning=false;
			for(int i = 0; i < women.length;i++)
			{
				if(women[i].married == false)
				{
					activeWomenId.add(i);
					algorithmRunning=true;
				}
				
			}
			
			if(algorithmRunning != true)
				break;
			
			//Uses the active nodes to generate pseudo-random
			//unfair scheduler
			int numForRound=(int)(Math.random()*activeWomenId.size());
			
			//Scheduler itself
			while(numForRound >=0 )
			{
				numForRound--;
				int tempWomanId=
						activeWomenId.get((int) (activeWomenId.size()*Math.random()));
				
				
				int deleteLady=0;
				
				for(int i =0;i < activeWomenId.size();i++)
					if(activeWomenId.get(i) == tempWomanId)
						deleteLady = i;
						
					
					
				activeWomenId.remove(deleteLady);
				//Use of schedule
				
				//Number of times proposed counter
				int propCount=0;
				
				//Runs on tempWoman until she is actively married
				while(true)
				{
					//Gets the id of the man she would like to propose to
					int tempManId=women[tempWomanId].act();
					
					//Stops the loop when tempWoman is married
					if(tempManId == -1)
						break;
				
					propCount++;
					
					//Proposes to him
					int divorcee = men[tempManId].except(tempWomanId);
				
					//Based on returned number divorces or marries
					//Includes the divorce of possible former wife
					if(divorcee != tempWomanId)
					{
						women[tempWomanId].married=true;
						men[tempManId].married=true;
					
						if(divorcee != -1)
							women[divorcee].divorce();
					
					}else
						women[tempWomanId].divorce();
					
					
				}//End of loop for tempWoman
				
				System.out.println("Number of times woman"+ tempWomanId
						+" proposed in round "+counterForMainRounds +" is "+ propCount);
				
				
			}//End of scheduler
			

			
		}//End of main algorithm loop
		
		
		
		
		//Calculate number of checks to confirm no blocking pairs
		//For women
		double reqCheck=0;
		for(int i=0; i <women.length;i++)
		{
			reqCheck=reqCheck+women[i].currentPref;
		}
		
		System.out.println("\n\n\n\n\n\n\n"
				+ "For Women total "+reqCheck
				+"\n for the average woman "+ (reqCheck/halfGroupSize));
		
		//Calculate number of checks to confirm no blocking pairs
		//For men
		double reqCheck2=0;
		for(int i=0; i <men.length;i++)
		{
			reqCheck2=reqCheck2+men[i].currentPref;
		}
		
		System.out.println("For Men total "+reqCheck2
				+ "\n for the average man " + (reqCheck2/halfGroupSize));
		
		
		
	}

}

