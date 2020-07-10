package util.backend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import util.TypeLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GenericBackendClient {

    public Response putTestResultsWithAlterationsNo400(String token, String systemNumber, String requestBody, List<JsonPathAlteration> alterations) {
        Response response = callPutTestResultsWithAlterations(token, systemNumber, requestBody, alterations);
        ArrayList<String> notApplicableFields;

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callPutTestResultsWithAlterations(token, systemNumber, requestBody, alterations);
        }
        int i =0;
        while ((response.getStatusCode() == HttpStatus.SC_BAD_REQUEST) && (i < 4)) {
            DocumentContext jsonContext = JsonPath.parse(response.asString());
            HashMap errorMessage = jsonContext.read("$");
            if (errorMessage.containsKey("errors")) {
                Object[] errors = ((JSONArray) errorMessage.get("errors")).toArray();
                if ((errors[0] != null) && (errors[0] instanceof String)) {
                    notApplicableFields = GenericData.extractArrayListStringFromJsonString(response.asString(), "$.errors");
                    for (String error : notApplicableFields) {
                        if (error.contains("is not allowed")) {
                            String fieldName = error.split("\"")[1];
                            JsonPathAlteration alterationDeleteTestResultField = new JsonPathAlteration(
                                    "$.testResult." + fieldName, "", "", "DELETE");
                            alterations.add(alterationDeleteTestResultField);
                            JsonPathAlteration alterationDeleteTestTypeField = new JsonPathAlteration(
                                    "$.testResult.testTypes[0]." + fieldName, "", "", "DELETE");
                            alterations.add(alterationDeleteTestTypeField);
                        }
                        if (error.contains("is required")) {
                            String fieldName = error.split("\"")[1];
                            if (fieldName.contentEquals("trailerId")) {
                                JsonPathAlteration alterationAddTestResultField = new JsonPathAlteration(
                                        "$.testResult", GenericData.generateRandomTrailerId(), fieldName, "ADD_FIELD");
                                alterations.add(alterationAddTestResultField);
                            }
                        }
                    }
                }
            }
            response = callPutTestResultsWithAlterations(token, systemNumber, requestBody, alterations);
            i++;
        }

        while ((response.getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) && (i < 4)) {
            response = callPutTestResultsWithAlterations(token, systemNumber, requestBody, alterations);
            i++;
        }

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN ||
                response.getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            response = callPutTestResultsWithAlterations(token, systemNumber, requestBody, alterations);
        }
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response;
    }

    private Response callPutTestResultsWithAlterations(String token, String systemNumber, String requestBody, List<JsonPathAlteration> alterations) {
        //the only actions accepted are ADD_FIELD, ADD_VALUE, DELETE and REPLACE
        String alteredBody = GenericData.applyJsonAlterations(requestBody, alterations);

        return given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(alteredBody)
                .pathParam("systemNumber", systemNumber)
                .log().method().log().uri().log().body()
                .put(TypeLoader.getBasePathUrl() + "/test-results/{systemNumber}");
    }

    public Response postTechRecordsWithAlterations(String token, String requestBody, List<JsonPathAlteration> alterations) {
        Response response = callPostTechRecordsWithAlterations(token, requestBody, alterations);

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callPostTechRecordsWithAlterations(token, requestBody, alterations);
        }
        Assert.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        return response;
    }

    private Response callPostTechRecordsWithAlterations(String token, String requestBody, List<JsonPathAlteration> alterations) {
        //the only actions accepted are ADD_FIELD, ADD_VALUE, DELETE and REPLACE
        String alteredBody = GenericData.applyJsonAlterations(requestBody, alterations);

        Response response = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/vehicles");
        return response;
    }

    public Response getTechRecords(String token, String vin) {
        Response response = callGetTechRecords(token, vin);

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callGetTechRecords(token, vin);
        }
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response;
    }

    public Response callGetTechRecords(String token, String vin) {
        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", vin)
                .queryParam("status", "all")
                .queryParam("searchCriteria", "vin")
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        return response;
    }

    public Response postTestResultsWithAlterations(String token, String requestBody, List<JsonPathAlteration> alterations) {

        Response response = callPostTestResultsWithAlterations(token, requestBody, alterations);

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callPostTestResultsWithAlterations(token, requestBody, alterations);
        }
        Assert.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        return response;
    }

    private Response callPostTestResultsWithAlterations(String token, String requestBody, List<JsonPathAlteration> alterations) {
        //the only actions accepted are ADD_FIELD, ADD_VALUE, DELETE and REPLACE
        String alteredBody = GenericData.applyJsonAlterations(requestBody, alterations);

        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/test-results");
        return response;
    }

    public Response getTestResults(String token, String systemNumber) {

        Response response = callGetTestResults(token, systemNumber);

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callGetTestResults(token, systemNumber);
        }
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response;
    }

    public Response getTestResultsNo404(String token, String systemNumber) {

        Response response = callGetTestResults(token, systemNumber);

        if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED || response.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
            response = callGetTestResults(token, systemNumber);
        }
        int i = 0;
        while (response.getStatusCode() == HttpStatus.SC_NOT_FOUND && i < 100) {
            response = callGetTestResults(token, systemNumber);
            i++;
        }
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response;
    }

    private Response callGetTestResults(String token, String systemNumber) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", systemNumber)
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");

        return response;
    }

}
