package stepDef;

import base.BaseBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.PageInfo;
import utilities.PropertyReader;

import static base.BaseBuilder.requestSpecification;
import static utilities.CommonStepDef.jsonSchemaValidator;
import static utilities.GlobalConstant.getUser;

/**
 * @author Divakar Verma
 * @created_at : 23/05/2024 - 1:42 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class Users extends BaseBuilder{

    private String pageId;
    private Response response;
    private String userId;
    private static PropertyReader reader = new PropertyReader();
    private static PageInfo pageInfo = new PageInfo();

    @Given("the user has a page ID {string}")
    public void user_has_a_page_id(String pageId) {
       this.pageId = pageId;
    }
    @Given("the user calls the user info API")
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

    @Given("converts the JSON object to a Java object")
    public void convert_the_json_object_to_a_java_object() {
        JsonPath jsonPath = response.jsonPath();
        pageInfo.setPage(jsonPath.getString("page"));
        pageInfo.setPerPage(jsonPath.getString("per_page"));
        pageInfo.setTotal(jsonPath.getString("total"));
        pageInfo.setTotalPage(jsonPath.getString("total_pages"));
        pageInfo.setData(jsonPath.getList("data"));
        System.out.println(pageInfo.getPage());
        System.out.println(pageInfo.getData());
    }

    @Then("the user's data is verified")
    public void verify_users_data() {

        Assert.assertEquals("2",pageInfo.getPage());
        Assert.assertEquals("6",pageInfo.getPerPage());
    }


    /* ********************************************** */
    @Given("User has a user id {string}")
    public void user_has_a_user_id(String userId) {
        this.userId = userId;
    }
    @Given("User call get user by id api")
    public void user_call_get_user_by_id_api() {
        response = RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get(getUser+"/"+userId)
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Then("Verify users data for user id")
    public void verify_users_data_for_user_id() {
        jsonSchemaValidator(response,reader.getValueFromConfig("user.info.by.user.id.valid.schema"));
        Assert.assertTrue(true);
    }
}
