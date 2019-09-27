package appvn.report.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class MyObject{	
	private Map<String, Object> properties;
    
    public MyObject() {
    	properties = new HashMap<>();
	}

	//Create object with properties
    public MyObject(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    //Set properties
    public void setProperty(String key, Object value) {
        this.properties.put(key, value); //Returns old value if existing
    }

    //Get properties
    public Object getProperty(String key) {
        return this.properties.getOrDefault(key, null);
    }
}