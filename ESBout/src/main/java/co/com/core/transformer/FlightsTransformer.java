package co.com.core.transformer;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.responseFuse.*;

@Component
public class FlightsTransformer {
	
	public void transformBlizard(final Exchange exchange) {

		String blizardText;
		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		
		try {
			String creditCardString = Integer.toString(responseFuse.getCreditCardNumber());
			String transactionDate = responseFuse.getTransactionDate().toString();
			blizardText = String.format("%-10s", responseFuse.getTransactionId()) + String.format("%-10s", creditCardString) + transactionDate.replace("-", "") +
					String.format("%-4s", responseFuse.getValue()) + responseFuse.getDescription();
			
			exchange.getIn().setBody(blizardText);
		}
		catch (Exception e) {
			
		}
		
	}
	
	public void transformFlightsGuard(final Exchange exchange) {

		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		
		try {
			System.out.print("genrando XML ActiveMQ");
			
			StringBuilder xml = new StringBuilder();
			xml.append("<security-incident>\n");
			
			xml.append("<level>");
			xml.append(responseFuse.getAlertType());
			xml.append("</level>\n");

			xml.append("<description>");
			xml.append(responseFuse.getDescription());
			xml.append("</description>\n");

			xml.append("<flight-external-key>");
			xml.append(responseFuse.getExternalKey());
			xml.append("</flight-external-key>\n");

			xml.append("<aircraft-tail-number>");
			xml.append(responseFuse.getTailNumber());
			xml.append("</aircraft-tail-number>\n");

			xml.append("<incident-date>");
			xml.append(responseFuse.getDate());
			xml.append("</incident-date>\n");

			xml.append("</security-incident>");
			
			exchange.getIn().setBody(xml.toString());
		}
		catch (Exception e) {
			
		}
		
	}
	
	public void transformCancelFlight(final Exchange exchange) {

		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		
		try {
			System.out.print("genrando XML REST API");
			
			StringBuilder xml = new StringBuilder();
			xml.append("<cancelRequest>\n");
			
			xml.append("<aircraftIdentifier>");
			xml.append(responseFuse.getTailNumber());
			xml.append("</aircraftIdentifier>\n");

			xml.append("<externalKey>");
			xml.append(responseFuse.getExternalKey());
			xml.append("</externalKey>\n");

			xml.append("<description>");
			xml.append(responseFuse.getDescription());
			xml.append("</description>\n");

			xml.append("<date>");
			xml.append(responseFuse.getDate());
			xml.append("</date>\n");

			xml.append("</cancelRequest>");
			
			exchange.getIn().setBody(xml.toString());
		}
		catch (Exception e) {
			
		}
		
	}

}
