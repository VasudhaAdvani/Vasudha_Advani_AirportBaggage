/*
 * Author : Vasudha Advani
 * This class will save distance between two flightGates as a edge
 */
package airportBaggageProblem;

public class SaveBagsList {

	private String bagNum;
	private String entryPoint;
	private String flightId;
	private String startPoint;
	
	public SaveBagsList() {
		// TODO Auto-generated constructor stub
	}
	
	public SaveBagsList(String bagNum, String entryPoint, String flightId) {
		this.bagNum = bagNum;
		this.entryPoint = entryPoint;
		this.flightId = flightId;
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * This method will return a flightGate correponding to each flight(flightid)
	 */
	public Vertex findPaths(String flightId) {
		SaveDepartureDetails sdepDetail = new SaveDepartureDetails();
		startPoint = sdepDetail.getFlightGate(flightId);
		Vertex destinationNode = new Vertex(startPoint, startPoint);
		return destinationNode;		
	}
}
