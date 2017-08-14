package pl.woleszko.staz2017.camel.routing.tutorials;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
//
//import pl.woleszko.staz2017.camel.routing.tutorials.MainExample.Events;
//import pl.woleszko.staz2017.camel.routing.tutorials.MainExample.MyBean;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Main;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

public class RoutingTestProcessor {
	private static Main mainContext;
    
    
	
	public static void main(String[] args) throws Exception {
		Logger log = LoggerFactory.getLogger(RoutingTestProcessor.class);  
		log.debug("<<--Program started...-->>");
        // create a Main instance
        mainContext = new Main();
        // bind MyBean into the registry
//        mainContext.bind("foo", new MyBean());
        // add routes
//        mainContext.addRouteBuilder(new RouteBuilder() {
        
//        	@Override
//			public void configure() throws Exception {

//				final BindyCsvDataFormat bindy = new BindyCsvDataFormat(NozzleMeasuresEntity.class);
//				from("file:D:/?fileName=nozzleMeasures.csv&noop=true")
//					.unmarshal(bindy)
//					.log("pol route'a")
//					.process(new Processor() {
//						public void process(Exchange exchange) throws Exception {
//							System.out.println("List initialiazation.. ");
//							String output = new String();
//							ArrayList<NozzleMeasuresEntity> listOfEntities =(ArrayList<NozzleMeasuresEntity>) exchange.getIn().getBody();
//							for(NozzleMeasuresEntity entity : listOfEntities) {
//								output += entity.toString() + "\n";
//								log.debug(entity.toString());
//							}
//					        exchange.getIn().setBody(output);
//					        
//						}
//					}
//					)
//					.log("za procesem")
//					.to("file:D:/?fileName=nowy.txt");
//				
//			}
//        	
//        });
        // add event listener
//        mainContext.addMainListener(new Events());
        // run until you terminate the JVM
        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        mainContext.run();
		
		mainContext.start();
		System.out.println("Context started... ");
		
		mainContext.stop();
		
		
	}

}
