package co.com.core.evaluator;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.flights.DomainEventsInfo;

@Component
public class DomainEventsInfoEvaluator {
	
	public boolean checkBlizard(final Exchange exchange) {
		DomainEventsInfo domainEventsInfo = exchange.getIn().getBody(DomainEventsInfo.class);
		
		return true;
	}

}
