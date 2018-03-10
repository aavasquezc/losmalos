package co.com.core.evaluator;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.FlightLeg;

@Component
public class FlightsEvaluator {
	
	public boolean checkStatusFlight(final Exchange exchange) {
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		return true;
//		return !leg.getStatus().value().equals("COMPLETED");
	}

}
