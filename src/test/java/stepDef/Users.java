package stepDef;

import base.BaseBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static base.BaseBuilder.requestSpecification;
import static utilities.GlobalConstant.getUser;

/**
 * @author Divakar Verma
 * @created_at : 23/05/2024 - 1:42 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class Users extends BaseBuilder{

    private String pageId;
    private Response response;

    @Given("User has a page id {string}")
    public void user_has_a_page_id(String pageId) {
       this.pageId = pageId;
    }
    @Given("User call user info api")
    public void user_call_user_info_api() {
        response = RestAssured.given()
                .spec(requestSpecification)
                .queryParam("page",pageId)
                .when()
                .get(getUser)
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Then("Verify users data")
    public void verify_users_data() {
        System.out.println(response.asPrettyString());
    }
}
