/*
 * Author : Vasudha Advani
 * This class will be used to find shortest distance for a bag
 */

package airportBaggageProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindPaths {

  private List<Vertex> nodes  = new ArrayList<Vertex>();;
  private List<Edge> edges =  new ArrayList<Edge>();;

//  @Test
  /*
   * This method save all flightGates details
   */
  public void addNodes(HashSet<String> nodesList) {
	  for (Iterator<String> iterator = nodesList.iterator(); iterator.hasNext();) {
		Vertex location = new Vertex((String)iterator.next(), (String)iterator.next());
	    nodes.add(location);		
	}
  }
  
  /*
   * This method will save distances between two flight gates
   */

  public void addLane(String laneId, Vertex sourceLocNo, Vertex destLocNo,int duration) {
    Edge lane = new Edge(laneId,sourceLocNo, destLocNo, duration);    
    edges.add(lane);
  }

  /*
   * This method will find shortest path
   */
  public void shortestPath(Vertex sourceNode,Vertex destinationNode) {
  Graph graph = new Graph(nodes, edges);
  FindShortestPath dijkstra = new FindShortestPath(graph);
  dijkstra.execute(sourceNode);
  LinkedList<Vertex> path = dijkstra.getPath(destinationNode);    
  String pathLength = "";
  for (Vertex vertex : path) {
    pathLength  = pathLength + " " + vertex;
    System.out.println(vertex); 
    
  }    
  System.out.println("pathlength : " + pathLength);    
}
 } 
