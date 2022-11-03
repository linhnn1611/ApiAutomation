package common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class JsonUtils {
	public String getValueByKey(String jsonBody, String key) {
		String value = " ";
		JSONParser responseParser = new JSONParser();
		try {
			JSONObject responseObject = (JSONObject) responseParser.parse(jsonBody);
			value = responseObject.get(key).toString();
		} catch (ParseException e) {
			System.out.println("Json");
			e.printStackTrace();
		}
		return value;
	}

}
