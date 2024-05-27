package utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

/**
 * @author Divakar Verma
 * @created_at : 27/05/2024 - 12:04 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class CommonStepDef {

    public static void jsonSchemaValidator(Response response , String schemaFilePath){
        File file = new File(schemaFilePath);
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(file);
        response.then().assertThat().body(validator);
    }
}
