/*
 *  Author : Vasudha Advani
 *  This Java class will process the input
 */
package airportBaggageProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ReadingInput {

	/*
	 * This method takes string input and as per different section process each type of input section
	 * Also it'll make a call to find shortest path for each bag in baglist
	 */
	public void readInput(String input) {
		
		String inputSections[] = input.split("# Section: ");
		
		for(int i=0; i < inputSections.length ; i++)

		{
			if(inputSections[i].contains("Conveyor System"))
			{
				HashSet<String> nodesAdd = new HashSet<String>();
				String convSection[] = inputSections[i].replaceAll("Conveyor System", "").split("\n");
				for (int j=0; j < convSection.length; j++)
				{
					String nodeDest[] = convSection[i].split(" ");
					for (int k=0; k < nodeDest.length ; k++)
					{
						String nodeName1 = nodeDest[0];
						nodesAdd.add(nodeName1);
						String nodeName2 = nodeDest[1];
						nodesAdd.add(nodeName1);
						String distance = nodeDest[2];		
					}		
				}
				
				FindPaths populatingConveyorDetails = new FindPaths();
				populatingConveyorDetails.addNodes(nodesAdd);
				int count = 1;
				String laneId="";
				for (int j=0; j < convSection.length; j++)
				{
					String nodeDest[] = convSection[i].split(" ");
					for (int k=0; k < nodeDest.length ; k++)
					{
						String nodeName1 = nodeDest[0];
						Vertex node1 = new Vertex(nodeName1, nodeName1);
						String nodeName2 = nodeDest[1];
						Vertex node2 = new Vertex(nodeName2, nodeName2);
						int distance = Integer.getInteger(nodeDest[2]);
						laneId = "Edge_"+count;
						populatingConveyorDetails.addLane(laneId, node1, node2, distance);						
					}		
				}
				
		   }
			
			if (inputSections[i].contains("Departures"))
			{
				String depSection[] = inputSections[i].replaceAll("Departures", "").split("\n");
				for (int j=0; j < depSection.length; j++)
				{
					String flightTerminal[] = depSection[j].split(" ");
					for (int k=0; k < flightTerminal.length ; k++)
					{
						String flightId = flightTerminal[0];
						String flightGate = flightTerminal[1];
						new SaveDepartureDetails(flightId,flightGate);
					}
				}
							
			}
			
			if (inputSections[i].contains("Bags"))
			{
				String bagsSection[] = inputSections[i].replaceAll("Bags", "").split("\n");
				for(int j=0; j< bagsSection.length; j++)
				{
					String bagsList[] = bagsSection[j].split(" ");
					for (int k=0; k < bagsList.length ; k++)
					{
						String bagNum = bagsList[0];
						String entryPoint = bagsList[1];
						Vertex sourceNode = new Vertex(entryPoint, entryPoint);
						String flightId = bagsList[2];
						new SaveBagsList(flightId,entryPoint,flightId);
						Vertex destinationNode = new SaveBagsList().findPaths(flightId);
						new FindPaths().shortestPath(sourceNode,destinationNode);
					}
				}
			}
			
		}
	}
}
