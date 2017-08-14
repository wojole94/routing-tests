package pl.woleszko.staz2017.camel.routing.tutorials;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endpoint2 {
	Logger log = LoggerFactory.getLogger(Endpoint2.class);
	@Handler
	public void callMe(ConfigFromFile config) {
		log.debug("Endpoint 2 begun! " + config.getKomunikat());
	}
}
