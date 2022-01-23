package com.Ty.Github.TestScripts;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.Ty.Github.geericlib.PropertyFile;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public PropertyFile pdata=new PropertyFile();
	@BeforeSuite
	public void configBS() {
		baseURI="https://api.github.com";
	}
	
	@AfterSuite
	public void configAS() {
		Reporter.log("sucess",true);
	}

}
