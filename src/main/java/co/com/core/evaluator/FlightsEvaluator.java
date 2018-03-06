package co.com.core.evaluator;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.FlightLeg;

@Component
public class FlightsEvaluator {

	public boolean checkIngate(final Exchange exchange) {

		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		return leg.getFlightAttributes().getStatus().equals("INGATE");
	}
	
	public boolean checkOutgate(final Exchange exchange) {

		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		return leg.getFlightAttributes().getStatus().equals("OUTGATE");
	}

}
