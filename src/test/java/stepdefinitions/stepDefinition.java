package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.ashtech.utils.Base;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;


public class stepDefinition extends Base

{
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Given("I perform get operation")
    public void i_perform_get_operation() throws FileNotFoundException {
        requestSpecification = getRequestSpecification();

            response = given().spec(requestSpecification).when().get("/api/users");


    }
    @Then("i should see {string} response code")
    public void i_should_see_response_code(String string) {
        responseSpecification = getResponseSpecification(string);
        response.then().spec(responseSpecification).extract().response();
        System.out.println(response.asString());
    }

    @Given("I perform post operation")
    public void iPerformPostOperation() throws FileNotFoundException {
        requestSpecification = getRequestSpecification();

        response = given().spec(requestSpecification).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").when().post("/api/users");
    }
}
