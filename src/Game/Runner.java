package Game;


import People.Person;
import Rooms.DistractionRoom;
import Rooms.Room;
import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[6][6];
        Board map= new Board(building);
        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                map.getBoard()[x][y] = new Room(x,y);
            }
        }

        //Create a random  room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        map.getBoard()[x][y] = new Room(x, y);

        //Create a distraction  room.
        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);
        map.getBoard()[a][b] = new DistractionRoom(a, b);


        //Create a random Math Room
        int z = (int)(Math.random()*building.length);
        int w = (int)(Math.random()*building.length);
        map.getBoard()[z][w] = new Rooms.Math_Major (z,w);

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        map.print();
		
		//setup variables for timer
		int futureTime = 0;
		int seconds = 0; //replace 0 with number of seconds the game should run
		futureTime = System.nanoTime() + (long) (seconds * 1e9);
        while(gameOn)
        {
            if(System.nanoTime()<futureTime{//checks if the current time is less than max time
				System.out.println("Where would you like to move? (Choose N, S, E, W)");
				String move = in.nextLine();
				if(validMove(move, player1, building))
				{
					System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

				}
				else {
					System.out.println("Please choose a valid move.");
				}
				
				/*if(checkPerson(x,y)){
					futureTime+=System.nanoTime() + (long) (30 * 1e9);
				}*/
				
			}else{
				gameOn = false;
			}
			
        }
		
		//add stuff here when game ends
		
		
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}