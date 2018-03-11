package co.com.core.transformer;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.FlightLeg;
import co.com.canonical.flights.OperationalInfo;
import co.com.canonical.flights.ScheduledInfo;
import co.com.canonical.flights.DomainEventsInfo;
import co.com.canonical.flights.DomainEventsInfo.ActualIngate;
import co.com.canonical.flights.DomainEventsInfo.ActualOutgate;
import co.com.canonical.flights.DomainEventsInfo.AlertOnAir;
import co.com.canonical.flights.DomainEventsInfo.OnAirShopping;

@Component
public class FlightsTransformer {

	public void transform(final Exchange exchange) {
		
		FlightLeg leg = exchange.getIn().getBody(FlightLeg.class);
		
		StringBuilder xml = new StringBuilder();
		xml.append("<flight-leg>\n");
		
		xml.append("<external-key>");
		xml.append(leg.getExternalKey());
		xml.append("</external-key>\n");
		xml.append("<status>");
		xml.append(leg.getStatus());
		xml.append("</status>\n");

		try {
			OperationalInfo operationalInfo = leg.getOperationalInfo();

			xml.append("<departure-airport>");
			xml.append(operationalInfo.getDepartureAirport());
			xml.append("</departure-airport>\n");
			xml.append("<arrival-airport>");
			xml.append(operationalInfo.getArrivalAirport());
			xml.append("</arrival-airport>\n");
		}
		catch (Exception e) {}

		try {
			ScheduledInfo scheduledInfo = leg.getScheduledInfo();

			xml.append("<estimated-outgate>");
			xml.append(scheduledInfo.getEstimatedOutgate());
			xml.append("</estimated-outgate>\n");
			xml.append("<estimated-ingate>");
			xml.append(scheduledInfo.getEstimatedIngate());
			xml.append("</estimated-ingate>\n");
			xml.append("<estimated-outgate-time>");
			xml.append(scheduledInfo.getEstimatedOutgateTime());
			xml.append("</estimated-outgate-time>\n");
			xml.append("<estimated-ingate-time>");
			xml.append(scheduledInfo.getEstimatedIngateTime());
			xml.append("</estimated-ingate-time>\n");
		}
		catch (Exception e) {}


		DomainEventsInfo domainEventsInfo = leg.getDomainEventsInfo();
		xml.append("<domain-events>\n");
		
		try {
			AlertOnAir alertOnAir = domainEventsInfo.getAlertOnAir();
			xml.append("<alert-on-air>\n");

			xml.append("<description>");
			xml.append(alertOnAir.getDescription());
			xml.append("</description>\n");
			xml.append("<alert-type>");
			xml.append(alertOnAir.getAlertType());
			xml.append("</alert-type>\n");
			
			xml.append("</alert-on-air>\n");
		}
		catch (Exception e) {}

		
		try {
			OnAirShopping onAirShopping = domainEventsInfo.getOnAirShopping();
			xml.append("<on-air-shopping>\n");

			xml.append("<description>");
			xml.append(onAirShopping.getDescription());
			xml.append("</description>\n");
			xml.append("<credit-card-number>");
			xml.append(onAirShopping.getCreditCardNumber());
			xml.append("</credit-card-number>\n");
			xml.append("<value>");
			xml.append(onAirShopping.getValue());
			xml.append("</value>\n");
			xml.append("<transaction-date>");
			xml.append(onAirShopping.getTransactionDate());
			xml.append("</transaction-date>\n");
			
			xml.append("</on-air-shopping>\n");
		}
		catch (Exception e) {}
		

		try {
			ActualOutgate actualOutgate = domainEventsInfo.getActualOutgate();
			xml.append("<actual-outgate>\n");

			xml.append("<date>");
			xml.append(actualOutgate.getDate());
			xml.append("</date>\n");
			xml.append("<gate-code>");
			xml.append(actualOutgate.getGateCode());
			xml.append("</gate-code>\n");
			xml.append("<fuel-percentage>");
			xml.append(actualOutgate.getFuelPercentage());
			xml.append("</fuel-percentage>\n");
			
			xml.append("</actual-outgate>\n");
		}
		catch (Exception e) {}
		

		try {
			ActualIngate actualIngate = domainEventsInfo.getActualIngate();
			xml.append("<actual-ingate>\n");

			xml.append("<date>");
			xml.append(actualIngate.getDate());
			xml.append("</date>\n");
			xml.append("<gate-code>");
			xml.append(actualIngate.getGateCode());
			xml.append("</gate-code>\n");
			xml.append("<fuel-percentage>");
			xml.append(actualIngate.getFuelPercentage());
			xml.append("</fuel-percentage>\n");
			
			xml.append("</actual-ingate>\n");
		}
		catch (Exception e) {}
		
		
		
		xml.append("</domain-events>\n");
		
		xml.append("</flight-leg>");

		exchange.getIn().setBody(xml.toString());
		
//		exchange.getIn();
	}

}
