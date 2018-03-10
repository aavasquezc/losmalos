package co.com.core.transformer;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
//
//import co.com.canonical.flights.AlertOnAir;
//import co.com.canonical.flights.DomainEvents;
import co.com.canonical.flights.FlightLeg;

@Component
public class FlightsTransformer {

	public void transform(final Exchange exchange) {
		
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		
		StringBuilder xml = new StringBuilder();
		xml.append("<flight-leg>\n");
		
		xml.append("<external-key>");
		xml.append(leg.getExternalKey());
		xml.append("</external-key>\n");
//		xml.append("<status>");
//		xml.append(leg.getStatus());
//		xml.append("</status>\n");

		xml.append("<domain-events>");
//		
//		DomainEvents domainEvents = leg.getDomainEvents();
//		AlertOnAir alertOnAir = domainEvents.getAlertOnAir();
//		String description = alertOnAir.getDescription();
//		if(!description.isEmpty()) {
//			xml.append("<alert-on-air>\n");
//			xml.append("<description>\n");
//			xml.append(description);
//			xml.append("</description>\n");
//			xml.append("</alert-on-air>\n");
//		}
//
		xml.append("</domain-events>\n");
		
		xml.append("</flight-leg>");

		exchange.getIn().setBody(xml.toString());
		
//		exchange.getIn();
	}

}
