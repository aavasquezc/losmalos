package co.com.core.evaluator;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.canonical.responseFuse.*;

@Component
public class FlightsEvaluator {
		
	public boolean checkBlizard(final Exchange exchange) {
		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		try {
			String domainEventInfo = responseFuse.getDomainEventsInfo();
			if(domainEventInfo.equals("on-air-shopping")) {
				System.out.print("Entro a on-air-shopping");
				return true;
			}
			
		}
		catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public boolean checkFlightsGuard(final Exchange exchange) {
		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		try {
			String domainEventInfo = responseFuse.getDomainEventsInfo();
			if(domainEventInfo.equals("alert-on-air")) {
				System.out.print("Entro a alert-on-air");
				return true;
			}
			
		}
		catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public boolean checkCancelFlight(final Exchange exchange) {
		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		try {
			String domainEventInfo = responseFuse.getDomainEventsInfo();
			if(domainEventInfo.equals("cancel-flight")) {
				System.out.print("Entro a cancel-flight");
				return true;
			}
			
		}
		catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public boolean checkMaintenancePlanner(final Exchange exchange) {
		ResponseFuse responseFuse = exchange.getIn().getBody(ResponseFuse.class);
		try {
//			String domainEventInfo = responseFuse.getDomainEventsInfo();
//			if(domainEventInfo.equals("cancel-flight")) {
//				System.out.print("Entro a cancel-flight");
//				return true;
//			}
			
		}
		catch (Exception e) {
			return false;
		}
		
		return false;
	}

}
