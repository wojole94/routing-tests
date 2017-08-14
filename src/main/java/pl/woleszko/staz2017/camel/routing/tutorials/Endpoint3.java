package pl.woleszko.staz2017.camel.routing.tutorials;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endpoint3 {
	Logger log = LoggerFactory.getLogger(Endpoint3.class);
	@Handler
	public void callMe(ConfigFromFile config) {
		log.debug("Endpoint 3 begun! " + config.getKomunikat());
	}
}
