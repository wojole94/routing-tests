package pl.woleszko.staz2017.camel.routing.tutorials;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import pl.woleszko.staz2017.camel.routing.tutorials.Entity;
import sun.misc.FloatingDecimal;

@CsvRecord(separator = ";")
public class ConfigFromFile implements Entity{
	
	@DataField(pos = 1)
	private String name;
	@DataField(pos = 2)
	private String komunikat;
	
	public ConfigFromFile() {
		this.name = null;
		this.komunikat = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKomunikat() {
		return komunikat;
	}

	public void setKomunikat(String komunikat) {
		this.komunikat = komunikat;
	}

	
}
