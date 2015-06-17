/*
 * Author : Vasudha Advani
 * Class to initate the process
 */

package airportBaggageProblem;

import java.util.Scanner;

public class GetUserInput {
	
	public static void main(String[] args) {
		  String input;		 
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter details of baggage system :");
	      input = in.nextLine();
	      new ReadingInput().readInput(input);
	}

}
