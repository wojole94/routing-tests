package pl.woleszko.staz2017.camel.routing.tutorials;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
	public void csvHandler(ArrayList<ConfigFromFile> body) throws Exception {
		Logger log = LoggerFactory.getLogger(RoutingTestBean.class);
		log.debug("<<--Program started...-->>");
		System.out.println("List initialiazation.. ");
		String output = new String();
//		ArrayList<NozzleMeasuresEntity> listOfEntities = (ArrayList<NozzleMeasuresEntity>) exchange
//				.getIn().getBody();
		for (ConfigFromFile entity : body) {
			output += entity.toString() + "\n";
			log.debug(entity.toString());
		}

	}
}
