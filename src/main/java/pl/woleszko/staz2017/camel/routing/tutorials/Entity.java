package pl.woleszko.staz2017.camel.routing.tutorials;


import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ";")
public interface Entity {

}
