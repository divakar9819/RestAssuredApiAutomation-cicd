package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import utilities.PropertyReader;

/**
 * @author Divakar Verma
 * @created_at : 23/05/2024 - 1:24 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Getter
public class BaseBuilder {

    private static RequestSpecBuilder builder;
    public static RequestSpecification requestSpecification;
    private static PropertyReader reader;

    public BaseBuilder (){
        System.out.println("basebuilder");
        builder = new RequestSpecBuilder();
        reader = new PropertyReader();
        String env = reader.getValueFromConfig("env");
        if(env.equalsIgnoreCase("dev")){
            builder.setBaseUri(reader.getValueFromConfig("dev.env.host"));
        }
        else if(env.equalsIgnoreCase("uat")){
            builder.setBaseUri(reader.getValueFromConfig("uat.env.host"));
        }
        else {
            builder.setBaseUri(reader.getValueFromConfig("local.host.env"));
        }

        builder.setContentType("application/json");
        requestSpecification = builder.build();
    }

}
