package co.com.core.transformer;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.DomainEventsInfo;
import co.com.canonical.flights.DomainEventsInfo.OnAirShopping;

@Component
public class DomainEventsTransformer {

	public void transformBlizard(final Exchange exchange) {

		String blizardText;
		DomainEventsInfo domainEventsInfo = exchange.getIn().getBody(DomainEventsInfo.class);
		
		try {
			OnAirShopping onAirShopping = domainEventsInfo.getOnAirShopping();
			blizardText = "0000000001" + onAirShopping.getCreditCardNumber();
//					onAirShopping.getTransactionDate() + onAirShopping.getValue() + 
			
			exchange.getIn().setBody(blizardText);
		}
		catch (Exception e) {}
		
	}

}
