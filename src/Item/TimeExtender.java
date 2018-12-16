package Item;

public class TimeExtender extends Item{
	
	
	public TimeExtender(int xLoc, int yLoc){
		super("TimeExtender", int xLoc, int yLoc);
	}
	
	public boolean checkPerson(int personX, int personY){
		if(personX==getxLoc()&&personY == getyLoc()){
			return true;
		}return false;
	}
}
//
//public Item
//}
//System.out.println
//}
