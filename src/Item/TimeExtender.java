package Item;

public class TimeExtender extends Item{
	
	
	public TimeExtender(int xcon, int ycon){
		super("TimeExtender", int xcon, int ycon);
	}
	
	public boolean checkPerson(int personX, int personY){
		if(personX==getxLoc()&&personY == getyLoc()){
			return true;
		}return false;
	}
}