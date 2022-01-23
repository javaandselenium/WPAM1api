package com.Ty.Github.TestScripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Ty.Github.geericlib.IEndPoints;
import com.Ty.Github.geericlib.JavaUtility;
import com.Ty.Github.pojolib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostOperation extends BaseClass{
	@Test
	public void tc2() throws FileNotFoundException, IOException {
		String name = pdata.getData("repnames")+JavaUtility.getRandomNumb();
		Project pobj=new Project(name,"demo repo");
		
		Response resp = given()
		.auth().oauth2(IEndPoints.verificationcode)
		.contentType(ContentType.JSON)
		.body(pobj)
		
		.when()
		.post(IEndPoints.postOperation);
		
		resp.then().log().all()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON);
		
		Reporter.log("Post operation is scuccess",true);
		
		String gitrepoName = resp.jsonPath().get("name");
		Reporter.log("The dynamic reponame "+gitrepoName,true);
		
		//patch operation on dynamic repo created
		Project p1=new Project(name,"Hello dummy repo");
		given()
		.auth().oauth2(IEndPoints.verificationcode)
		.contentType(ContentType.JSON)
		.body(p1)
		.pathParam("ownerName",pdata.getData("owner"))
		.pathParam("repoName",gitrepoName)
		
		.when()
		.patch("/repos/{ownerName}/{repoName}")
		
		.then().log().all()
		.assertThat().statusCode(200);
		Reporter.log("repo is updated successfully",true);
		
		//delete the dynamically created repo
		given()
		.auth().oauth2(IEndPoints.verificationcode)
		.pathParam("ownerName",pdata.getData("owner"))
		.pathParam("repoName",gitrepoName)
		
		.when()
		.delete("/repos/{ownerName}/{repoName}")
		
		.then().log().all()
		.assertThat().statusCode(204);
		
		Reporter.log("repo is deleted successfully",true);
		
		
		
		
		
		
		
	}

}
