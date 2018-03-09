package co.com.core.evaluator;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.FlightLeg;

@Component
public class FlightsEvaluator {
	
	public boolean checkStatusFlight(final Exchange exchange) {
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		
		return !leg.getStatus().equals("COMPLETED");
	}

	public boolean checkIngate(final Exchange exchange) {
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		//System.out.println("JAVIER");
		//return leg.getStatus().equals("OUTGATE");
		//return leg.getFlightAttributes().getStatus().equals("OUTGATE");

		return true;
	}
	
	public boolean checkOutgate(final Exchange exchange) {

		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		//return leg.getFlightAttributes().getStatus().equals("INGATE");
		return true;
	}

}
