package pl.woleszko.staz2017.camel.routing.tutorials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.main.Main;
import org.apache.camel.spi.Registry;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.impl.SimpleRegistry;

//import pl.woleszko.staz2017.camel.routing.tutorials.MainExample.Events;

public class RoutingTestBean {

	private static Main mainContext;

	public static void main(String[] args) throws Exception {
		Logger log = LoggerFactory.getLogger(RoutingTestBean.class);
		log.debug("<<--Program started...-->>");
		// create a Main instance
		mainContext = new Main();
		// bind MyBean into the registry
		mainContext.bind("testBean", new TestBean());
		// add routes
		

		
		mainContext.addRouteBuilder(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				final BindyCsvDataFormat bindy = new BindyCsvDataFormat(ConfigFromFile.class);
				from("file:D:/?fileName=config.csv&noop=false&delay=1000")
						.unmarshal(bindy)
						.process(new Processor() {
							public void process(Exchange exchange) throws Exception {
								CamelContext context = exchange.getContext();
								
								//Pobranie konfiguracji endpointu z 'requesta'
								ConfigFromFile config = (ConfigFromFile) exchange.getIn().getBody();
								
								//Dodanie endpointu do kontekstu (tutaj robie na beanach wiec tak robie
								//skoro mozna dodawac na biezaco endpointy xmpp to ta czesc mozna juz zrobic w dynamicRouterze
								SimpleRegistry registry = context.getRegistry(SimpleRegistry.class);
								if(config.getName().equals("Endpoint1"))
								registry.put(config.getName(), new Endpoint1());
								if(config.getName().equals("Endpoint2"))
								registry.put(config.getName(), new Endpoint2());
								if(config.getName().equals("Endpoint3"))
								registry.put(config.getName(), new Endpoint3());
								//---------------------------------------
								
							}
						}
						)
						.dynamicRouter(method(DynamicRouter.class,"slip"));

			}

		});
		// add event listener
//		mainContext.addMainListener(new Events());
		// run until you terminate the JVM
		System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
		mainContext.run();

		mainContext.start();
		System.out.println("Context started... ");

		mainContext.stop();

	}

}
