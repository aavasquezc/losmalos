package co.com.core.transformer;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.FlightLeg;

@Component
public class FlightsTransformer {

	public void transform(final Exchange exchange) {
		
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		
		StringBuilder xml = new StringBuilder();
		xml.append("<OUTGATE-FLIGHTS>");
		xml.append("<EXTERNAL-KEY>");
		xml.append(leg.getFlightAttributes().getExternalKey());
		xml.append("</EXTERNAL-KEY>");
		xml.append("</OUTGATE-FLIGHTS>");
		
		exchange.getIn().setBody(xml.toString());
	}

}
