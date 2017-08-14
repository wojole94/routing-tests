package pl.woleszko.staz2017.camel.routing.tutorials;

public class DynamicRouter {
	public String slip(ConfigFromFile body) {
		//w tym miejscu mozna stworzyc sciezke do tego kanalu
		return "bean:" +body.getName();
		
	}
}
