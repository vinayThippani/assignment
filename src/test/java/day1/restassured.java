package day1;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restassured {

	@DataProvider(name="testdata1")
	public Object[][] data()
	{
		Object[][] studentsdata = new Object[1][7];
		studentsdata[0][0]= "vinay";
		studentsdata[0][1]= "t";
		studentsdata[0][2]=  "vinay";
		studentsdata[0][3]="vinay@t.com";
		studentsdata[0][4]="123456789";
		studentsdata[0][5]="9988776655";
		studentsdata[0][6]="1";
		return studentsdata;
		
	}

	@Test(enabled = true,dataProvider="testdata1")
	public void createuser(String uname,String fname,String lname,String email,String password,String phone,String userStatus)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj = new JSONObject();	
		obj.put("username", uname);
		obj.put("firstName", fname);
		obj.put("lastName", lname);
		obj.put("email", email);
		obj.put("password", password);
		obj.put("phone", phone);
		obj.put("userstatus", userStatus);
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.post("/user").
		then()
			.statusCode(200)
			.log().all();
			
	}
	
	@Test(enabled = false)
	public void getuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj = new JSONObject();
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.get("/user/vinay").
		then()
			.statusCode(200)
			.log().all();
			
	}
	
	@DataProvider(name="testdata")
	public Object[][] data1()
	{
		Object[][] studentsdata = new Object[1][7];
		studentsdata[0][0]= "vinay";
		studentsdata[0][1]= "t";
		studentsdata[0][2]=  "vinay";
		studentsdata[0][3]="vinay@t.com";
		studentsdata[0][4]="12345678";
		studentsdata[0][5]="9988776655";
		studentsdata[0][6]="1";
		return studentsdata;
		
	}

	@Test(enabled = false,dataProvider="testdata")
	public void modifyuser(String uname,String fname,String lname,String email,String password,String phone,String userStatus)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj = new JSONObject();	
		obj.put("username", uname);
		obj.put("firstName", fname);
		obj.put("lastName", lname);
		obj.put("email", email);
		obj.put("password", password);
		obj.put("phone", phone);
		obj.put("userstatus", userStatus);
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.put("/user/vinay").
		then()
			.statusCode(200)
			.log().all();
			
	}
	
	
	@Test(enabled = false)
	public void deleteuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj = new JSONObject();
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.delete("/user/vinay").
		then()
			.statusCode(200)
			.log().all();
			
	}
}
