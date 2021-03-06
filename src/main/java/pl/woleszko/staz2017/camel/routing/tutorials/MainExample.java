package pl.woleszko.staz2017.camel.routing.tutorials;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Main;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.MainSupport;
import org.apache.camel.main.MainListenerSupport;

public class MainExample {
	
	private Main main;
	 
    public static void main(String[] args) throws Exception {
        MainExample example = new MainExample();
        example.boot();
    }
 
    public void boot() throws Exception {
        // create a Main instance
        main = new Main();
        // bind MyBean into the registry
        main.bind("foo", new MyBean());
        // add routes
        main.addRouteBuilder(new MyRouteBuilder());
        // add event listener
        main.addMainListener(new Events());
        // set the properties from a file
  //      main.setPropertyPlaceholderLocations("example.properties");
        // run until you terminate the JVM
        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }
 
    private static class MyRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            from("timer://myTimer?period=2000")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Invoked timer at " + new Date());
                    }
                })
                .bean("foo");
        }
    }
 
    public static class MyBean {
        public void callMe() {
            System.out.println("MyBean.callMe method has been called");
        }
    }
 
    public static class Events extends MainListenerSupport {
 
        public void afterStart(MainSupport main) {
            System.out.println("MainExample with Camel is now started!");
        }
 
        public void beforeStop(MainSupport main) {
            System.out.println("MainExample with Camel is now being stopped!");
        }
    }

}
