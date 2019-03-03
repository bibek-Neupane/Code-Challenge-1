
import static java.lang.System.exit;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BIBEK
 */
public class Pacman {
    
    public static void main(String []args){
       int xPosition = 0;
       int yPosition = 0;
       int index = 0;
       
       //Since the game boundary is considered to be 5*5 we can provide maximum and minimum coordinates as 4 and 0 respectively
       int maxXPosition = 4;
       int maxYPosition = 4;
       int minXPosition = 0;
       int minYPosition = 0;
       int maxIndex = 3;
       int minIndex = 0;
       
       //the directions the pacman will be facing
       final String face[] = {"north","east","south","west"};
       int newXPostion;
       int newYPosition;
       String newFace;
       String action="";
       System.out.println("**************************************PACMAN******************************************");
       System.out.println("Enter the position of your pacman");
       
       Scanner scan = new Scanner(System.in);
       
       System.out.println("Enter X-coordinate?");
       xPosition = scan.nextInt();
       CheckXCoordinate(xPosition, minXPosition, maxXPosition);
       
       System.out.println("Enter Y-coordinate?");
       yPosition = scan.nextInt();
       CheckYCoordinate(yPosition, minYPosition, maxYPosition);
       
       System.out.println("Initial Direction of Pacman - East,West,North,South?");
       String direction = scan.next();
       direction.toLowerCase();
       for(int i=0; i<face.length; i++) {
           if(direction.equals(face[i])){
               index = i;// the index will determine the position of the array of which the pacman is facing
               break;
           }
           
       }
       
       System.out.println("Place "+xPosition+","+yPosition+","+direction);
       
       while(!"Report".equals(action)){
        
       System.out.println("Choose your next action - Move, Left, Right, Report");
       action = scan.next();
       System.out.println(action);
       if (action.equalsIgnoreCase("Move")){
           Move(direction, maxXPosition, xPosition, minXPosition, yPosition, maxYPosition, minYPosition);
       }
       else if (action.equalsIgnoreCase("Left")){
           LeftTurn(index,minIndex,maxIndex);
           System.out.println(index);
       }
       else if (action.equalsIgnoreCase("Right")){
           RightTurn(index,minIndex,maxIndex);
           System.out.println(index);
       }
        else if (action.equalsIgnoreCase("Report")){
           System.out.println("Output :" +xPosition+ ","+yPosition+","+face[index]);
           break;
       }
    }
    }
    
    private static void CheckXCoordinate(int xPos, int xMin, int xMax){
        if (xPos >= xMin && xPos <= xMax ) {
            System.out.println("the value of x-position is "+xPos);
       } else {
           System.out.println("Incorrect value please stay within the game boundaries");
           exit(0);
       }
       
    }
    
    private static void CheckYCoordinate (int yPos, int yMin, int yMax) {
       if (yPos >= yMin && yPos <= yMax) {
           System.out.println("the value of x-position is "+yPos); 
       } else {
           System.out.println("Incorrect value please stay within the game boundaries");
           exit(0);
       }
       
    }
    
    private static void Move(String direction, int xMax, int xPos, int xMin, int yPos, int yMax, int yMin){
        if (direction.equals("East") && xPos <= xMax){
            xPos = xPos+1;
        } 
        
        else if (direction.equals("West") && xPos > xMin) {
            xPos = xPos-1;
        }
        
        else if (direction.equals("North") && yPos <= yMax) {
            yPos = yPos+1;
        }
        
         else if (direction.equals("South") && yPos > yMin) {
            yPos = yPos-1;
        }
      
        else {
            System.out.println("No moves possible");
        }
    }
    
    private static void LeftTurn(int index, int minIndex, int maxIndex){
        if(index>minIndex){
            index=index-1;
        } else{
            index = maxIndex;
        }
            
    }
    
    private static void RightTurn(int index, int maxIndex, int minIndex){
        if(index<maxIndex) {
            index=index+1;
        } else {
            index = minIndex;
        }
    }
    
}

