package apitestdata;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.restassured.AllureRestAssured;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class AppleApi {

    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "https://itunes.apple.com/search";

    public AppleApi() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public Response searchByParameters(Map<String,String> params) {
        return given(requestSpecification)
                .params(params)
                .get(BASE_URL)
                .then().log().all()
                .extract().response();
    }


}
