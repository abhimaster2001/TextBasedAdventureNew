
package Rooms;

        import People.Person;

        import java.util.Scanner;

public class DistractionRoom extends Room
{
    Person occupant;
    int xLoc,yLoc;
    String contains;
	
	String[] questions;
	String[] answers;
	int roomNumber;

    public DistractionRoom(int a, int b) {
        super(a, b);
        this.contains="[Eng]";
		
		questions = new String[/*numquestions*/];
		answers = new String[/*numanswers*/];
		roomNumber = /*num roms*/
		
		questions[0] = "Whats crakin";
		answers[0] = "nah dawg";
    }
	
	
	
	public boolean checkAnswer(String userAnswer){
		if(userAnswer.toLowerCase().equals(answers[roomNumber].toLowerCase())){
			return true;
		}
		return false;
	
	}
	
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("Uh oh, you have entered your english class.  You have not handed in your assignment from last week and you have been spotted =O");
        Scanner engquestion = new Scanner(System.in);
        System.out.println(questions[roomNumber]);
        String answer = engquestion.nextLine();
		boolean isRight = checkAnswer(answer);
    }
    @Override
    public String toString()
    {
        return this.contains;
    }
}
