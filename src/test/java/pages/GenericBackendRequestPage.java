package pages;

import exceptions.AutomationException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import util.TypeLoader;
import util.backend.GenericData;
import util.backend.JsonPathAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GenericBackendRequestPage extends PageObject {

    private static String token;
    public static String vin;
    public static String vrm;

    public void createVehicle(String vehicleType, String withOrWithout) {

        // TEST SETUP
        //generate random system number
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        //generate random Vin
        String randomVin = GenericData.generateRandomVin();
        //generate random Vrm
        String randomVrm = GenericData.generateRandomVrm();
        if (!vehicleType.equals("hgv") && !vehicleType.equals("psv") && !vehicleType.equals("trl")) {
            throw new AutomationException("Invalid vehicle type");
        }
        if ((!withOrWithout.equals("with")) && (!withOrWithout.equals("without"))) {
            throw new AutomationException("This parameter needs to be 'with' or 'without'");
        }
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("technical-records_" + vehicleType +
                "_all_fields_" + withOrWithout + "_adr_details.json","$");
        // create alteration to change system number in the request body with the random system number
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber,"","REPLACE");
        // create alteration to change Vin in the request body with the random generated Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin,"","REPLACE");
        // create alteration to change primary vrm in the request body with the random generated primary vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.primaryVrm", randomVrm,"","REPLACE");
        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationVin, alterationVrm, alterationSystemNumber));

        String alteredBody = GenericData.applyJsonAlterations(postRequestBody, alterations);


        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/vehicles");
        response.prettyPrint();
        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            response = given()
                    .headers(
                            "Authorization",
                            "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(alteredBody)
                    .log().method().log().uri().log().body()
                    .post(TypeLoader.getBasePathUrl() + "/vehicles");
            response.prettyPrint();
        }
        Assert.assertEquals(response.statusCode(), 201);
        vin = randomVin;
        vrm = randomVrm;
    }

    public String getNewVehicleAttribute(String attribute) {
        switch (attribute.toLowerCase()) {
            case "vin":
                return vin;
            case "vrm":
                return vrm;
            default:
                throw new AutomationException("Invalid tech record attribute '" + attribute + "'");
        }
    }

    public void goToAuthTokenUrl() {
        getDriver().get(TypeLoader.getMicrosoftOnlineUrl());
        token = StringUtils.
                substringBetween(getDriver().getCurrentUrl(), "id_token=", "&session_state=");
        getDriver().navigate().back();
    }
}
