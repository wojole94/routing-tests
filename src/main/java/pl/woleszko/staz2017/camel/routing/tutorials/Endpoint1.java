package pl.woleszko.staz2017.camel.routing.tutorials;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endpoint1 {
	Logger log = LoggerFactory.getLogger(Endpoint1.class);
	@Handler
	public void callMe(ConfigFromFile config) {	
		log.debug("Endpoint 1 begun! " + config.getKomunikat());
	}

	
	
}
