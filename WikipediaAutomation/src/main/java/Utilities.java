import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static int input;
	public static JSONObject jsonObject;

	//Method to validate URL through status code using RestAssured
	public static boolean validateLink(String url){
		RestAssured.baseURI= url;
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "");
		
		int statusCode = response.getStatusCode();
		
		if(statusCode == 200) {
			return true;
		}else {
			return false;	
		}
	}
	
	//Method to get valid integer from User
	public static void getValidInteger() {
		System.out.println("Enter interger: ");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			input = sc.nextInt();
			if(input<0) {
                System.out.println("You entered a negative integer "+input);
                getValidInteger();
            }
	     }else {
	    	 System.out.println("Please Enter Valid Integer");
	         getValidInteger();   
	    }	
	}
	
	//Method to remove duplicate element from List and generate new List without duplicate elements
	public static List<String> removeDuplicateLink(List<String> linksList){
		List<String> newlist = new ArrayList<String>();
		for(String s: linksList) {
			if(!newlist.contains(s)) {
				newlist.add(s);
			}
		}
		return newlist;
	}
	
	
	public static void createJSONFile(String FileName, int allFoundLinks, int allUniqueLinks, List<String> allWikiLinksList) {
		jsonObject = new JSONObject();
		jsonObject.put("Numbers of found links", allFoundLinks);
		jsonObject.put("Number of unique liks", allUniqueLinks);
		jsonObject.put("All found links", allWikiLinksList);
		try {
			FileWriter file = new FileWriter(FileName);
			file.write(jsonObject.toJSONString().replace("\\/","/"));
			file.flush();
			file.close();
			System.out.println("JSON file created sucessfully at" + FileName);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
}
