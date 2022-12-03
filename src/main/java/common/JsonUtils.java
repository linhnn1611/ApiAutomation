package common;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class JsonUtils {
	public String getValueByKey(String jsonBody, String key) {
		String value = "";
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
	
	public void copyJsonFile(File sourceFile, File destinationFile) {
		 if(destinationFile.exists()) {
			  destinationFile.delete();
		  }
		  try {
		  Files.copy(sourceFile.toPath(), destinationFile.toPath());
		  System.out.println("Copy successfully");
		  } catch(Exception e) {
			  System.out.println("Json request body is not found");
		  }
		  
	}
	
	 //Pass value by fieldName
		public String changeValueByFieldName(File file, String fieldName, String value) {
			String resultFile = null;
			String filePath = file.getAbsolutePath();
			try {
			String originalFile = new String (Files.readAllBytes(Paths.get(filePath)));
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(originalFile);
			if (value.equals("missing")) {
				jsonObject.remove(fieldName);
			} else if(value.equals("null")) {
				jsonObject.put(fieldName, null);
			
			} else if(value.equals("true")) {
				jsonObject.put(fieldName, true);
			} else if (value.equals("\"\"" )) {
				jsonObject.put(fieldName, "");
			}
			else {
			jsonObject.put(fieldName, value);
			}
			resultFile=jsonObject.toJSONString();
			
			} catch (Exception e) {
				System.out.println("File not found");
			}
			
			return resultFile;
			
		}
		
		public String getFilePath(String requestBodyName) {
			String result = System.getProperty("user.dir") + "/src/main/resources/" + requestBodyName;
		
			return result;
		}
		
		public String getRequestBodyByName(String requestBodyName) {
			String requestBody="";
			String filePath = getFilePath(requestBodyName);
			try {
				File file = new File(filePath);
				if (file.exists()) {
					requestBody = new String(Files.readAllBytes(Paths.get(filePath)));
				}
			} catch (Exception e) {
			}
			System.out.println("file Path" + filePath);
			System.out.println("requestBody" + requestBody);
			return requestBody;
		}

}
