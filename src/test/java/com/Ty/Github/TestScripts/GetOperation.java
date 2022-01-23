package com.Ty.Github.TestScripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetOperation extends BaseClass {
	@Test
	public void tc1() throws FileNotFoundException, IOException {
		given()
		.pathParam("ownerName",pdata.getData("owner"))
		.pathParam("repoName", pdata.getData("repo"))
		
		.when()
		.get("/repos/{ownerName}/{repoName}")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON);
		
		Reporter.log("getOperation is succesfull",true);
	}

}
