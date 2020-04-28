package pages;

import com.jayway.jsonpath.PathNotFoundException;
import exceptions.AutomationException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import util.TypeLoader;
import util.backend.GenericData;
import util.backend.JsonPathAlteration;
import util.model.TestTypes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class GenericBackendRequestPage extends PageObject {

    private static String token;
    public static String vin;
    public static String vrm;
    public static String trailerId;
    public static String systemNumber;
    public static int noOfAxles;
    public static String vehicleClassCode;
    public static String vehicleClassDescription;
    public static ArrayList<String> vehicleSubclass;
    public static String vehicleConfiguration;
    public static String vehicleSize;
    public static String vehicleType;
    public static String vehicleVin;
    public static String vehicleVrm;
    public static String euVehicleCategory;
    public static int numberOfWheelsDriven;
    public static String firstUseDate;
    public static String regnDate;
    public static String testNumber;
    public static String testCode;
    public static String testTypeName;
    public static String testStartTimestamp;
    public static String testEndTimestamp;
    public static String testTypeStartTimestamp;
    public static String testTypeEndTimestamp;
    public static String testExpiryDate;
    public static String testAnniversaryDate;
    public static String certificateNumber;

    public void createTechRecord(String typeOfVehicle, String withWithoutAdr) {

        // TEST SETUP
        //generate random Vin
        String randomVin = GenericData.generateRandomVin();
        //generate random Vrm
        String randomVrm = GenericData.generateRandomVrm();
        if (!typeOfVehicle.equals("hgv") && !typeOfVehicle.equals("trl")) {
            throw new AutomationException("Invalid vehicle type '" + typeOfVehicle +  "' or vehicle type '"
                    + typeOfVehicle + "' does not support ADR");
        }
        if ((!withWithoutAdr.equals("with")) && (!withWithoutAdr.equals("without"))) {
            throw new AutomationException("This parameter needs to be 'with' or 'without'");
        }
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("technical-records_" + typeOfVehicle +
                "_all_fields_" + withWithoutAdr + "_adr_details.json","$");
        // create alteration to change Vin in the request body with the random generated Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin,"","REPLACE");
        // create alteration to change primary vrm in the request body with the random generated primary vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.primaryVrm", randomVrm,"","REPLACE");
        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationVin, alterationVrm));

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
        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", randomVin)
                .queryParam("status", "all")
                .queryParam("searchCriteria", "vin")
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", randomVin)
                    .queryParam("status", "all")
                    .queryParam("searchCriteria", "vin")
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);

        systemNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].systemNumber");
        noOfAxles = GenericData.extractIntegerValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].noOfAxles");
        vehicleClassCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.code");
        vehicleClassDescription = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.description");
        vehicleType = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleType");
        if (vehicleType.contentEquals("car") || vehicleType.contentEquals("motorcycle")) {
            vehicleSubclass = GenericData.extractArrayListStringFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSubclass");
        }
        else {
            vehicleSubclass = null;
        }
        vehicleConfiguration = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleConfiguration");
        vehicleVin = vin;
        vehicleVrm = vrm;
        if (vehicleType.contentEquals("trl")) {
            trailerId = GenericData.extractStringValueFromJsonString(getRequestResponse.prettyPrint(), "$[0].trailerId");
        }
        else {
            trailerId = null;
        }
        if (vehicleType.contentEquals("psv")) {
            vehicleSize = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSize");
        }
        else {
            vehicleSize = null;
        }
        euVehicleCategory = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].euVehicleCategory");
        if (vehicleType.contentEquals("trl")) {
            firstUseDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].firstUseDate");
        }
        else {
            firstUseDate = null;
        }
        if (vehicleType.contentEquals("psv") || vehicleType.contentEquals("hgv")) {
            regnDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].regnDate");
            numberOfWheelsDriven = GenericData.extractIntegerValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].numberOfWheelsDriven");
        }
        else {
            regnDate = null;
        }

    }

    public void createTechRecord(String typeOfVehicle) {

        // TEST SETUP
        //generate random Vin
        String randomVin = GenericData.generateRandomVin();
        //generate random Vrm
        String randomVrm = GenericData.generateRandomVrm();
        if (!typeOfVehicle.equals("hgv") && !typeOfVehicle.equals("psv") && !typeOfVehicle.equals("trl")) {
            throw new AutomationException("Invalid vehicle type");
        }
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("technical-records_" + typeOfVehicle + ".json","$");
        // create alteration to change Vin in the request body with the random generated Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin,"","REPLACE");
        // create alteration to change primary vrm in the request body with the random generated primary vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.primaryVrm", randomVrm,"","REPLACE");
        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationVin, alterationVrm));

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
        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", randomVin)
                .queryParam("status", "all")
                .queryParam("searchCriteria", "vin")
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", randomVin)
                    .queryParam("status", "all")
                    .queryParam("searchCriteria", "vin")
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);

        systemNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].systemNumber");
        noOfAxles = GenericData.extractIntegerValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].noOfAxles");
        vehicleClassCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.code");
        vehicleClassDescription = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.description");
        vehicleType = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleType");
        if (vehicleType.contentEquals("car") || vehicleType.contentEquals("motorcycle")) {
            vehicleSubclass = GenericData.extractArrayListStringFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSubclass");
        }
        else {
            vehicleSubclass = null;
        }
        vehicleConfiguration = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleConfiguration");
        vehicleVin = vin;
        vehicleVrm = vrm;
        if (vehicleType.contentEquals("trl")) {
            trailerId = GenericData.extractStringValueFromJsonString(getRequestResponse.prettyPrint(), "$[0].trailerId");
        }
        else {
            trailerId = null;
        }
        if (vehicleType.contentEquals("psv")) {
            vehicleSize = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSize");
        }
        else {
            vehicleSize = null;
        }
        euVehicleCategory = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].euVehicleCategory");
        if (vehicleType.contentEquals("trl")) {
            firstUseDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].firstUseDate");
        }
        else {
            firstUseDate = null;
        }
        if (vehicleType.contentEquals("psv") || vehicleType.contentEquals("hgv")) {
            regnDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].regnDate");
            numberOfWheelsDriven = GenericData.extractIntegerValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].numberOfWheelsDriven");
        }
        else {
            regnDate = null;
        }

    }

    public void createTestRecord(String testStatus, String testResult, String testCode, boolean withWithoutDefects) {
        if (vehicleType.contentEquals("hgv")) {
            createHgvTestRecord(testStatus, testResult, testCode, withWithoutDefects);
        }
        else if (vehicleType.contentEquals("psv")) {
            createPsvTestRecord(testStatus, testResult, testCode, withWithoutDefects);
        }
        else if (vehicleType.contentEquals("trl")) {
            createTrlTestRecord(testStatus, testResult, testCode, withWithoutDefects);
        }
    }

    public void createHgvTestRecord(String testStatus, String testResult, String code, boolean withWithoutDefects) {

        // TEST SETUP

        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("test-results_hgv.json","$");
        String testResultId = UUID.randomUUID().toString();
        // create alteration to change testStatus
        JsonPathAlteration alterationTestStatus =
                new JsonPathAlteration("$.testStatus", testStatus,"","REPLACE");
        // create alteration to change testResultId
        JsonPathAlteration alterationTestResultId =
                new JsonPathAlteration("$.testResultId", testResultId,"","REPLACE");
        // create alteration to change testResult
        JsonPathAlteration alterationTestResult =
                new JsonPathAlteration("$.testTypes[0].testResult", testResult,"","REPLACE");
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String endDate = currentDate.plusHours(1).format(formatter);
        String expiryDate = currentDate.plusYears(1).format(formatter);
         // create alteration to change testStartTimestamp
        JsonPathAlteration alterationTestStartTimestamp =
                new JsonPathAlteration("$.testStartTimestamp", currentDate.format(formatter),"","REPLACE");
         // create alteration to change testEndTimestamp
        JsonPathAlteration alterationTestEndTimestamp =
                new JsonPathAlteration("$.testEndTimestamp", endDate,"","REPLACE");
        JsonPathAlteration alterationTestTypeStartTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeStartTimestamp", currentDate.format(formatter),"","REPLACE");
        // create alteration to change testTypeEndTimestamp
        JsonPathAlteration alterationTestTypeEndTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeEndTimestamp", endDate,"","REPLACE");
        // create alteration to change testExpiryDate
        JsonPathAlteration alterationTestExpiryDate =
                new JsonPathAlteration("$.testTypes[0].testExpiryDate", expiryDate,"","REPLACE");
        if (!(testResult.toLowerCase().contentEquals("pass"))) {
            alterationTestExpiryDate = new JsonPathAlteration("$.testTypes[0].testExpiryDate",
                    "","","DELETE");
        }


        // create alteration to change systemNumber
        JsonPathAlteration alterationSystemNumber =
                new JsonPathAlteration("$.systemNumber", systemNumber,"","REPLACE");
        // create alteration to change Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", vin,"","REPLACE");
        // create alteration to change vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.vrm", vrm,"","REPLACE");

        // create alteration to change noOfaxles
        JsonPathAlteration alterationNoOfAxles =
                new JsonPathAlteration("$.noOfAxles", noOfAxles,"","REPLACE");
        // create alteration to change vehicleClass.code
        JsonPathAlteration alterationVehicleClassCode =
                new JsonPathAlteration("$.vehicleClass.code", vehicleClassCode,"","REPLACE");
        // create alteration to change vehicleClass.description
        JsonPathAlteration alterationVehicleClassDescription =
                new JsonPathAlteration("$.vehicleClass.description", vehicleClassDescription,"","REPLACE");
        // create alteration to change vehicleType
        JsonPathAlteration alterationVehicleType =
                new JsonPathAlteration("$.vehicleType", vehicleType,"","REPLACE");
        // create alteration to change vehicleConfiguration
        JsonPathAlteration alterationVehicleConfiguration =
                new JsonPathAlteration("$.vehicleConfiguration", vehicleConfiguration,"","REPLACE");
        // create alteration to change euVehicleCategory
        JsonPathAlteration alterationEuVehicleCategory =
                new JsonPathAlteration("$.euVehicleCategory", euVehicleCategory,"","REPLACE");
        // create alteration to change numberOfWheelsDriven
        JsonPathAlteration alterationNumberOfWheelsDriven =
                new JsonPathAlteration("$.numberOfWheelsDriven", numberOfWheelsDriven,"","REPLACE");
        // create alteration to change regnDate
        JsonPathAlteration alterationRegnDate = new JsonPathAlteration("$.regnDate", regnDate,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationTestStatus, alterationTestResultId,
                alterationTestResult, alterationSystemNumber, alterationVin, alterationVrm, alterationNoOfAxles,
                alterationVehicleClassCode, alterationVehicleClassDescription, alterationVehicleType,
                alterationVehicleConfiguration, alterationEuVehicleCategory, alterationNumberOfWheelsDriven, alterationRegnDate,
                alterationTestExpiryDate, alterationTestStartTimestamp, alterationTestEndTimestamp, alterationTestTypeStartTimestamp,
                alterationTestTypeEndTimestamp));

        if (testResult.toLowerCase().contentEquals("abandoned")) {
            // create alteration to change reasonForAbandoning
            JsonPathAlteration alterationReasonForAbandoning = new JsonPathAlteration("$.testTypes[0].reasonForAbandoning",
                            "reason for abandoning","","REPLACE");
            // create alteration to change additionalCommentsForAbandon
            JsonPathAlteration alterationAdditionalCommentsForAbandon = new JsonPathAlteration("$.testTypes[0].additionalCommentsForAbandon",
                            "additional comments for abandon","","REPLACE");
            alterations.add(alterationReasonForAbandoning);
            alterations.add(alterationAdditionalCommentsForAbandon);
        }
        if (!withWithoutDefects) {
            // create alteration to remove defects
            JsonPathAlteration alterationDefects = new JsonPathAlteration("$.testTypes[0].defects",
                    "[]","","REPLACE");
            alterations.add(alterationDefects);
        }
        for (TestTypes testType : TestTypes.values()) {
            if (testType.getTestCode().contentEquals(code.toLowerCase())) {
                // create alteration to change testTypeId
                JsonPathAlteration alterationTestTypeId =
                        new JsonPathAlteration("$.testTypes[0].testTypeId", testType.getId(),"","REPLACE");
                alterations.add(alterationTestTypeId);
                // create alteration to change testTypeName
                JsonPathAlteration alterationTestTypeName =
                        new JsonPathAlteration("$.testTypes[0].testTypeName", testType.getTestTypeName(),"","REPLACE");
                alterations.add(alterationTestTypeName);
                // create alteration to change testName
                JsonPathAlteration alterationTestName =
                        new JsonPathAlteration("$.testTypes[0].name", testType.getName(),"","REPLACE");
                alterations.add(alterationTestName);
                try {
                    JSONObject json = testType.getRestrictions();
                    int length = json.length();
                    if (length != 0) {
                        Iterator iterator = json.keys();
                        Object[] names = new Object[length];
                        int i = 0;
                        while (iterator.hasNext()) {
                            names[i] = iterator.next();
                            JsonPathAlteration additionalAlteration =
                                    new JsonPathAlteration("$." + names[i].toString(), json.get(names[i].toString()), "", "REPLACE");
                            alterations.add(additionalAlteration);
                            i += 1;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
        }


        String alteredBody = GenericData.applyJsonAlterations(postRequestBody, alterations);


        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/test-results");
        response.prettyPrint();
        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            response = given()
                    .headers(
                            "Authorization",
                            "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(alteredBody)
                    .log().method().log().uri().log().body()
                    .post(TypeLoader.getBasePathUrl() + "/test-results");
            response.prettyPrint();
        }
        Assert.assertEquals(response.statusCode(), 201);

        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", systemNumber)
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403 ||
                getRequestResponse.getStatusCode() == 404) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", systemNumber)
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);
        testNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testNumber");
        testCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testCode");
        testTypeName = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeName");
        testStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testStartTimestamp");
        testEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testEndTimestamp");
        testTypeStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeStartTimestamp");
        testTypeEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeEndTimestamp");
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testAnniversaryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testAnniversaryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testAnniversaryDate' field is not present because it is not applicable");
            testAnniversaryDate = "-";
        }
        certificateNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].certificateNumber");
    }

    public void createTrlTestRecord(String testStatus, String testResult, String code, boolean withWithoutDefects) {

        // TEST SETUP

        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("test-results_trl.json","$");
        String testResultId = UUID.randomUUID().toString();
        // create alteration to change testStatus
        JsonPathAlteration alterationTestStatus =
                new JsonPathAlteration("$.testStatus", testStatus,"","REPLACE");
        // create alteration to change testResultId
        JsonPathAlteration alterationTestResultId =
                new JsonPathAlteration("$.testResultId", testResultId,"","REPLACE");
        // create alteration to change testResult
        JsonPathAlteration alterationTestResult =
                new JsonPathAlteration("$.testTypes[0].testResult", testResult,"","REPLACE");
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String endDate = currentDate.plusHours(1).format(formatter);
        String expiryDate = currentDate.plusYears(1).format(formatter);
        // create alteration to change testStartTimestamp
        JsonPathAlteration alterationTestStartTimestamp =
                new JsonPathAlteration("$.testStartTimestamp", currentDate.format(formatter),"","REPLACE");
        // create alteration to change testEndTimestamp
        JsonPathAlteration alterationTestEndTimestamp =
                new JsonPathAlteration("$.testEndTimestamp", endDate,"","REPLACE");
        JsonPathAlteration alterationTestTypeStartTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeStartTimestamp", currentDate.format(formatter),"","REPLACE");
        // create alteration to change testTypeEndTimestamp
        JsonPathAlteration alterationTestTypeEndTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeEndTimestamp", endDate,"","REPLACE");
        // create alteration to change testExpiryDate
        JsonPathAlteration alterationTestExpiryDate =
                new JsonPathAlteration("$.testTypes[0].testExpiryDate", expiryDate,"","REPLACE");
        if (!(testResult.toLowerCase().contentEquals("pass"))) {
            alterationTestExpiryDate = new JsonPathAlteration("$.testTypes[0].testExpiryDate",
                    "","","DELETE");
        }


        // create alteration to change systemNumber
        JsonPathAlteration alterationSystemNumber =
                new JsonPathAlteration("$.systemNumber", systemNumber,"","REPLACE");
        // create alteration to change Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", vin,"","REPLACE");
        // create alteration to change vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.vrm", vrm,"","REPLACE");
        // create alteration to change trailerId
        JsonPathAlteration alterationTrailerId = new JsonPathAlteration("$.trailerId", trailerId,"","REPLACE");

        // create alteration to change noOfaxles
        JsonPathAlteration alterationNoOfAxles =
                new JsonPathAlteration("$.noOfAxles", noOfAxles,"","REPLACE");
        // create alteration to change vehicleClass.code
        JsonPathAlteration alterationVehicleClassCode =
                new JsonPathAlteration("$.vehicleClass.code", vehicleClassCode,"","REPLACE");
        // create alteration to change vehicleClass.description
        JsonPathAlteration alterationVehicleClassDescription =
                new JsonPathAlteration("$.vehicleClass.description", vehicleClassDescription,"","REPLACE");
        // create alteration to change vehicleType
        JsonPathAlteration alterationVehicleType =
                new JsonPathAlteration("$.vehicleType", vehicleType,"","REPLACE");
        // create alteration to change vehicleConfiguration
        JsonPathAlteration alterationVehicleConfiguration =
                new JsonPathAlteration("$.vehicleConfiguration", vehicleConfiguration,"","REPLACE");
        // create alteration to change euVehicleCategory
        JsonPathAlteration alterationEuVehicleCategory =
                new JsonPathAlteration("$.euVehicleCategory", euVehicleCategory,"","REPLACE");
        // create alteration to change numberOfWheelsDriven
        JsonPathAlteration alterationNumberOfWheelsDriven =
                new JsonPathAlteration("$.numberOfWheelsDriven", numberOfWheelsDriven,"","REPLACE");
        // create alteration to change regnDate
        JsonPathAlteration alterationRegnDate = new JsonPathAlteration("$.regnDate", regnDate,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationTestStatus, alterationTestResultId,
                alterationTestResult, alterationSystemNumber, alterationVin, alterationVrm, alterationNoOfAxles,
                alterationVehicleClassCode, alterationVehicleClassDescription, alterationVehicleType, alterationTrailerId,
                alterationVehicleConfiguration, alterationEuVehicleCategory, alterationNumberOfWheelsDriven, alterationRegnDate,
                alterationTestExpiryDate, alterationTestStartTimestamp, alterationTestEndTimestamp, alterationTestTypeStartTimestamp,
                alterationTestTypeEndTimestamp));

        if (testResult.toLowerCase().contentEquals("abandoned")) {
            // create alteration to change reasonForAbandoning
            JsonPathAlteration alterationReasonForAbandoning = new JsonPathAlteration("$.testTypes[0].reasonForAbandoning",
                    "reason for abandoning","","REPLACE");
            // create alteration to change additionalCommentsForAbandon
            JsonPathAlteration alterationAdditionalCommentsForAbandon = new JsonPathAlteration("$.testTypes[0].additionalCommentsForAbandon",
                    "additional comments for abandon","","REPLACE");
            alterations.add(alterationReasonForAbandoning);
            alterations.add(alterationAdditionalCommentsForAbandon);
        }
        if (!withWithoutDefects) {
            // create alteration to remove defects
            JsonPathAlteration alterationDefects = new JsonPathAlteration("$.testTypes[0].defects",
                    "[]","","REPLACE");
            alterations.add(alterationDefects);
        }
        for (TestTypes testType : TestTypes.values()) {
            if (testType.getTestCode().contentEquals(code.toLowerCase())) {
                // create alteration to change testTypeId
                JsonPathAlteration alterationTestTypeId =
                        new JsonPathAlteration("$.testTypes[0].testTypeId", testType.getId(),"","REPLACE");
                alterations.add(alterationTestTypeId);
                // create alteration to change testTypeName
                JsonPathAlteration alterationTestTypeName =
                        new JsonPathAlteration("$.testTypes[0].testTypeName", testType.getTestTypeName(),"","REPLACE");
                alterations.add(alterationTestTypeName);
                // create alteration to change testName
                JsonPathAlteration alterationTestName =
                        new JsonPathAlteration("$.testTypes[0].name", testType.getName(),"","REPLACE");
                alterations.add(alterationTestName);
                try {
                    JSONObject json = testType.getRestrictions();
                    int length = json.length();
                    if (length != 0) {
                        Iterator iterator = json.keys();
                        Object[] names = new Object[length];
                        int i = 0;
                        while (iterator.hasNext()) {
                            names[i] = iterator.next();
                            JsonPathAlteration additionalAlteration =
                                    new JsonPathAlteration("$." + names[i].toString(), json.get(names[i].toString()), "", "REPLACE");
                            alterations.add(additionalAlteration);
                            i += 1;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
        }


        String alteredBody = GenericData.applyJsonAlterations(postRequestBody, alterations);


        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/test-results");
        response.prettyPrint();
        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            response = given()
                    .headers(
                            "Authorization",
                            "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(alteredBody)
                    .log().method().log().uri().log().body()
                    .post(TypeLoader.getBasePathUrl() + "/test-results");
            response.prettyPrint();
        }
        Assert.assertEquals(response.statusCode(), 201);

        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", systemNumber)
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403 ||
                getRequestResponse.getStatusCode() == 404) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", systemNumber)
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);
        testNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testNumber");
        testCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testCode");
        testTypeName = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeName");
        testStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testStartTimestamp");
        testEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testEndTimestamp");
        testTypeStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeStartTimestamp");
        testTypeEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeEndTimestamp");
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testAnniversaryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testAnniversaryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testAnniversaryDate' field is not present because it is not applicable");
            testAnniversaryDate = "-";
        }
        certificateNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].certificateNumber");
    }

    public void createPsvTestRecord(String testStatus, String testResult, String code, boolean withWithoutDefects) {

        // TEST SETUP

        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("test-results_psv.json","$");

        String testResultId = UUID.randomUUID().toString();
        // create alteration to change testStatus
        JsonPathAlteration alterationTestStatus =
                new JsonPathAlteration("$.testStatus", testStatus,"","REPLACE");
        // create alteration to change testResultId
        JsonPathAlteration alterationTestResultId =
                new JsonPathAlteration("$.testResultId", testResultId,"","REPLACE");
        // create alteration to change testResult
        JsonPathAlteration alterationTestResult =
                new JsonPathAlteration("$.testTypes[0].testResult", testResult,"","REPLACE");
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String endDate = currentDate.plusHours(1).format(formatter);
        String expiryDate = currentDate.plusYears(1).format(formatter);
        // create alteration to change testStartTimestamp
        JsonPathAlteration alterationTestStartTimestamp =
                new JsonPathAlteration("$.testStartTimestamp", currentDate.format(formatter),"","REPLACE");
        // create alteration to change testEndTimestamp
        JsonPathAlteration alterationTestEndTimestamp =
                new JsonPathAlteration("$.testEndTimestamp", endDate,"","REPLACE");
        JsonPathAlteration alterationTestTypeStartTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeStartTimestamp", currentDate.format(formatter),"","REPLACE");
        // create alteration to change testTypeEndTimestamp
        JsonPathAlteration alterationTestTypeEndTimestamp =
                new JsonPathAlteration("$.testTypes[0].testTypeEndTimestamp", endDate,"","REPLACE");
        // create alteration to change testExpiryDate
        JsonPathAlteration alterationTestExpiryDate =
                new JsonPathAlteration("$.testTypes[0].testExpiryDate", expiryDate,"","REPLACE");
        if (!(testResult.toLowerCase().contentEquals("pass"))) {
            alterationTestExpiryDate = new JsonPathAlteration("$.testTypes[0].testExpiryDate",
                    "","","DELETE");
        }


        // create alteration to change systemNumber
        JsonPathAlteration alterationSystemNumber =
                new JsonPathAlteration("$.systemNumber", systemNumber,"","REPLACE");
        // create alteration to change Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", vin,"","REPLACE");
        // create alteration to change vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.vrm", vrm,"","REPLACE");

        // create alteration to change noOfaxles
        JsonPathAlteration alterationNoOfAxles =
                new JsonPathAlteration("$.noOfAxles", noOfAxles,"","REPLACE");
        // create alteration to change vehicleClass.code
        JsonPathAlteration alterationVehicleClassCode =
                new JsonPathAlteration("$.vehicleClass.code", vehicleClassCode,"","REPLACE");
        // create alteration to change vehicleClass.description
        JsonPathAlteration alterationVehicleClassDescription =
                new JsonPathAlteration("$.vehicleClass.description", vehicleClassDescription,"","REPLACE");
        // create alteration to change vehicleType
        JsonPathAlteration alterationVehicleType =
                new JsonPathAlteration("$.vehicleType", vehicleType,"","REPLACE");
        // create alteration to change vehicleConfiguration
        JsonPathAlteration alterationVehicleConfiguration =
                new JsonPathAlteration("$.vehicleConfiguration", vehicleConfiguration,"","REPLACE");
        // create alteration to change euVehicleCategory
        JsonPathAlteration alterationEuVehicleCategory =
                new JsonPathAlteration("$.euVehicleCategory", euVehicleCategory,"","REPLACE");
        // create alteration to change numberOfWheelsDriven
        JsonPathAlteration alterationNumberOfWheelsDriven =
                new JsonPathAlteration("$.numberOfWheelsDriven", numberOfWheelsDriven,"","REPLACE");
        // create alteration to change regnDate
        JsonPathAlteration alterationRegnDate = new JsonPathAlteration("$.regnDate", regnDate,"","REPLACE");
        // create alteration to change vehicleSize
        JsonPathAlteration alterationVehicleSize = new JsonPathAlteration("$.vehicleSize", vehicleSize,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationTestStatus, alterationTestResultId,
                alterationTestResult, alterationSystemNumber, alterationVin, alterationVrm, alterationNoOfAxles,
                alterationVehicleClassCode, alterationVehicleClassDescription, alterationVehicleType,
                alterationVehicleConfiguration, alterationEuVehicleCategory, alterationNumberOfWheelsDriven, alterationRegnDate,
                alterationTestExpiryDate, alterationTestStartTimestamp, alterationTestEndTimestamp, alterationTestTypeStartTimestamp,
                alterationTestTypeEndTimestamp, alterationVehicleSize));

        if (testResult.toLowerCase().contentEquals("abandoned")) {
            // create alteration to change reasonForAbandoning
            JsonPathAlteration alterationReasonForAbandoning = new JsonPathAlteration("$.testTypes[0].reasonForAbandoning",
                    "reason for abandoning","","REPLACE");
            // create alteration to change additionalCommentsForAbandon
            JsonPathAlteration alterationAdditionalCommentsForAbandon = new JsonPathAlteration("$.testTypes[0].additionalCommentsForAbandon",
                    "additional comments for abandon","","REPLACE");
            alterations.add(alterationReasonForAbandoning);
            alterations.add(alterationAdditionalCommentsForAbandon);
        }
        if (!withWithoutDefects) {
            // create alteration to remove defects
            JsonPathAlteration alterationDefects = new JsonPathAlteration("$.testTypes[0].defects",
                    "[]","","REPLACE");
            alterations.add(alterationDefects);
        }
        for (TestTypes testType : TestTypes.values()) {
            if (testType.getTestCode().contentEquals(code.toLowerCase())) {
                // create alteration to change testTypeId
                JsonPathAlteration alterationTestTypeId =
                        new JsonPathAlteration("$.testTypes[0].testTypeId", testType.getId(),"","REPLACE");
                alterations.add(alterationTestTypeId);
                // create alteration to change testTypeName
                JsonPathAlteration alterationTestTypeName =
                        new JsonPathAlteration("$.testTypes[0].testTypeName", testType.getTestTypeName(),"","REPLACE");
                alterations.add(alterationTestTypeName);
                // create alteration to change testName
                JsonPathAlteration alterationTestName =
                        new JsonPathAlteration("$.testTypes[0].name", testType.getName(),"","REPLACE");
                alterations.add(alterationTestName);
                try {
                    JSONObject json = testType.getRestrictions();
                    int length = json.length();
                    if (length != 0) {
                        Iterator iterator = json.keys();
                        Object[] names = new Object[length];
                        int i = 0;
                        while (iterator.hasNext()) {
                            names[i] = iterator.next();
                            JsonPathAlteration additionalAlteration =
                                    new JsonPathAlteration("$." + names[i].toString(), json.get(names[i].toString()), "", "REPLACE");
                            alterations.add(additionalAlteration);
                            i += 1;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
        }


        String alteredBody = GenericData.applyJsonAlterations(postRequestBody, alterations);


        Response response = given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/test-results");
        response.prettyPrint();
        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            response = given()
                    .headers(
                            "Authorization",
                            "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(alteredBody)
                    .log().method().log().uri().log().body()
                    .post(TypeLoader.getBasePathUrl() + "/test-results");
            response.prettyPrint();
        }
        Assert.assertEquals(response.statusCode(), 201);

        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", systemNumber)
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403 ||
                getRequestResponse.getStatusCode() == 404) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", systemNumber)
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/test-results/{searchIdentifier}");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);
        testNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testNumber");
        testCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testCode");
        testTypeName = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeName");
        testStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testStartTimestamp");
        testEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testEndTimestamp");
        testTypeStartTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeStartTimestamp");
        testTypeEndTimestamp = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testTypeEndTimestamp");
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testExpiryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testExpiryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testExpiryDate' field is not present because it is not applicable");
            testExpiryDate = "-";
        }
        try {
            testAnniversaryDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].testTypes[0].testAnniversaryDate");
        } catch (PathNotFoundException pathNotFoundException) {
            System.out.println("'testAnniversaryDate' field is not present because it is not applicable");
            testAnniversaryDate = "-";
        }
        certificateNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].testTypes[0].certificateNumber");
    }

    public String getNewVehicleAttribute(String attribute) {
        switch (attribute.toLowerCase()) {
            case "vin":
                return vin;
            case "vrm":
                return vrm;
            case "trailerid":
                return trailerId;
            default:
                throw new AutomationException("Invalid tech record attribute '" + attribute + "'");
        }
    }

    public String getNewTestTypeAttribute(String attribute) {
        // initial date format
        DateTimeFormatter initialDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // date format for date
        DateTimeFormatter dateFormatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // date format for time
        DateTimeFormatter dateFormatterTime = DateTimeFormatter.ofPattern("h:mm a");

        switch (attribute) {
            case "certificateNumber":
                return certificateNumber;
            case "testNumber":
                return testNumber;
            case "testCode":
                return testCode.substring(0, 1).toUpperCase() + testCode.substring(1);
            case "testTypeName":
                return testTypeName;
            case "testStartTimestamp":
                try {
                    return dateFormatterDate.format(LocalDateTime.parse(testStartTimestamp, initialDateFormatter));
                } catch (DateTimeParseException e) {
                    return "-";
                }
            case "testEndTimestamp":
                try {
                    return dateFormatterDate.format(LocalDateTime.parse(testEndTimestamp, initialDateFormatter));
                } catch (DateTimeParseException e) {
                    return "-";
                }
            case "testTypeStartTimestamp":
                try {
                    return dateFormatterTime.format(LocalDateTime.parse(testTypeStartTimestamp, initialDateFormatter));
                } catch (DateTimeParseException e) {
                    return "-";
                }
            case "testTypeEndTimestamp":
                try {
                    return dateFormatterTime.format(LocalDateTime.parse(testTypeEndTimestamp, initialDateFormatter));
                }
                catch (DateTimeParseException e) {
                    return "-";
                }
            case "testExpiryDate":
                try {
                    return dateFormatterDate.format(LocalDateTime.parse(testExpiryDate, initialDateFormatter));
                } catch (DateTimeParseException e) {
                    return "-";
                }
            case "testAnniversaryDate":
                try {
                    return dateFormatterDate.format(LocalDateTime.parse(testAnniversaryDate, initialDateFormatter));
                } catch (DateTimeParseException e) {
                    return "-";
                }
            default:
                if (attribute.contains("expiryDate")) {
                    try {
                        return dateFormatterDate.format(LocalDateTime.parse(testExpiryDate, initialDateFormatter));
                    } catch (DateTimeParseException e) {
                        return "-";
                    }
                } else if (attribute.contains("EndTimestamp")) {
                    try {
                        return dateFormatterDate.format(LocalDateTime.parse(testTypeEndTimestamp, initialDateFormatter));
                    }
                    catch (DateTimeParseException e) {
                        return "-";
                    }
                }
                else if (attribute.contains("certificateNumber")) {
                    return certificateNumber;
                }
                else {
                    throw new AutomationException("Invalid test record attribute '" + attribute + "'");
                }
        }
    }

    public void goToAuthTokenUrl() {
        getDriver().get(TypeLoader.getMicrosoftOnlineUrl());
        token = StringUtils.
                substringBetween(getDriver().getCurrentUrl(), "id_token=", "&session_state=");
        getDriver().navigate().back();
    }

    public void createTestRecordWithStatusAndResultAndTestTypeForNewVehicle(String status, String result, String testCode,
                                                                            String typeOfVehicle) {
        // TEST SETUP
        //generate random Vin
        String randomVin = GenericData.generateRandomVin();
        //generate random Vrm
        String randomVrm = GenericData.generateRandomVrm();
        if (!typeOfVehicle.equals("hgv") && !typeOfVehicle.equals("psv") && !typeOfVehicle.equals("trl")) {
            throw new AutomationException("Invalid vehicle type");
        }
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("technical-records_" + typeOfVehicle + ".json","$");
        // create alteration to change Vin in the request body with the random generated Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin,"","REPLACE");
        // create alteration to change primary vrm in the request body with the random generated primary vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.primaryVrm", randomVrm,"","REPLACE");
        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationVin, alterationVrm));

        for (TestTypes testType : TestTypes.values()) {
            if (testType.getTestCode().contentEquals(testCode.toLowerCase())) {
                try {
                    JSONObject json = testType.getRestrictions();
                    int length = json.length();
                    if (length != 0) {
                        Iterator iterator = json.keys();
                        Object[] names = new Object[length];
                        int i = 0;
                        while (iterator.hasNext()) {
                            names[i] = iterator.next();
                            JsonPathAlteration additionalAlteration =
                                    new JsonPathAlteration("$.techRecord[0]." + names[i].toString(), json.get(names[i].toString()), "", "REPLACE");
                            alterations.add(additionalAlteration);
                            i += 1;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

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
        Response getRequestResponse = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("searchIdentifier", randomVin)
                .queryParam("status", "all")
                .queryParam("searchCriteria", "vin")
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        if (getRequestResponse.getStatusCode() == 401 || getRequestResponse.getStatusCode() == 403) {
            getRequestResponse = given().headers(
                    "Authorization",
                    "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .pathParam("searchIdentifier", randomVin)
                    .queryParam("status", "all")
                    .queryParam("searchCriteria", "vin")
                    .log().method().log().uri().log().body()
                    .get(TypeLoader.getBasePathUrl() + "/vehicles/{searchIdentifier}/tech-records");
        }
        getRequestResponse.prettyPrint();
        Assert.assertEquals(getRequestResponse.statusCode(), 200);

        systemNumber = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].systemNumber");
        noOfAxles = GenericData.extractIntegerValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].noOfAxles");
        vehicleClassCode = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.code");
        vehicleClassDescription = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleClass.description");
        vehicleType = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleType");
        if (vehicleType.contentEquals("car") || vehicleType.contentEquals("motorcycle")) {
            vehicleSubclass = GenericData.extractArrayListStringFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSubclass");
        }
        else {
            vehicleSubclass = null;
        }
        vehicleConfiguration = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleConfiguration");
        vehicleVin = vin;
        vehicleVrm = vrm;
        if (vehicleType.contentEquals("trl")) {
            trailerId = GenericData.extractStringValueFromJsonString(getRequestResponse.prettyPrint(), "$[0].trailerId");
        }
        else {
            trailerId = null;
        }
        if (vehicleType.contentEquals("psv")) {
            vehicleSize = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].vehicleSize");
        }
        else {
            vehicleSize = null;
        }
        euVehicleCategory = GenericData.extractStringValueFromJsonString
                (getRequestResponse.prettyPrint(), "$[0].techRecord[0].euVehicleCategory");
        if (vehicleType.contentEquals("trl")) {
            firstUseDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].firstUseDate");
        }
        else {
            firstUseDate = null;
        }
        if (vehicleType.contentEquals("psv") || vehicleType.contentEquals("hgv")) {
            regnDate = GenericData.extractStringValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].regnDate");
            numberOfWheelsDriven = GenericData.extractIntegerValueFromJsonString
                    (getRequestResponse.prettyPrint(), "$[0].techRecord[0].numberOfWheelsDriven");
        }
        else {
            regnDate = null;
        }

        createTestRecord(status, result, testCode, true);
    }
}
