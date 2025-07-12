package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDT_ReadingDatafromJSONFile {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Get access of physical file using filereader
		
		FileReader fr=new FileReader("C:\\Users\\anjal\\Desktop\\DDT Files\\jsoncommondata.json");
		
		//Parse the json physical file into java file using JSONParserClass
		
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fr);
		
		//Convert java object into JSONObject using downcasting
		
		JSONObject jsboj=(JSONObject)obj;
		
		//Read the data using get() by passing the key
		
		String brow = jsboj.get("browser").toString();
		System.out.println(brow);
		String url = jsboj.get("url").toString();
		System.out.println(url);
		String username = jsboj.get("username").toString();
		System.out.println(username);
		String password = jsboj.get("password").toString();
		System.out.println(password);
		
		

	}

}
