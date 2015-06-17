/*
 * Author : Vasudha Advani
 * This class will save different departure details
 */

package airportBaggageProblem;

import java.util.HashMap;

public class SaveDepartureDetails {
	
	private HashMap<String, String> departuresMap = new HashMap<String, String>();
	public SaveDepartureDetails(String flightId, String flightGate) {
		// TODO Auto-generated constructor stub
		departuresMap.put(flightId, flightGate);
	}
	
	public SaveDepartureDetails () {
		
	}
	
	/*
	 * This method will return Gate for each flight
	 */
	public String getFlightGate(String flightId) {
		String flightGate = departuresMap.get(flightId);		
		return flightGate;
	}
	

}
