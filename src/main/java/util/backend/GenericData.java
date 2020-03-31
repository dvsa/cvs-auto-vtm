package util.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static net.minidev.json.parser.JSONParser.DEFAULT_PERMISSIVE_MODE;

public class GenericData {

    public static String readJsonBodyFromFile(String fileName) throws IOException {
        ClassLoader classLoader = DataMapper.class.getClassLoader();
        return DataMapper.readFromInputStream(classLoader.getResourceAsStream("src/main/resources/loader/" + fileName));
    }

    public static String readBytesFromFile(String fileName) {
        String encodedString = "";
        try {
            byte[] input_file = Files.readAllBytes(Paths.get("src/main/resources/loader/" + fileName));
            byte[] encodedBytes = Base64.getEncoder().encode(input_file);
            encodedString =  new String(encodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedString;
    }

    public static String readJsonValueFromFile(String fileName, String path) {
        ClassLoader classLoader = DataMapper.class.getClassLoader();

        String jsonBody = null;
        try {
            jsonBody = DataMapper.readFromInputStream(classLoader.getResourceAsStream("loader/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = null;
        try {
            jsonResp = mapperObj.writeValueAsString(JsonPath.read(jsonBody, path));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (jsonResp.startsWith("\"") && jsonResp.endsWith("\"")) {
            return jsonResp.substring(1, jsonResp.length()-1);
        }
        else {
            return jsonResp;
        }
    }

    public static String getJsonObjectInPath(String json, String path) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = null;
        try {
            jsonResp = mapperObj.writeValueAsString(JsonPath.read(json, path));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (jsonResp.startsWith("\"") && jsonResp.endsWith("\"")) {
            return jsonResp.substring(1, jsonResp.length()-1);
        }
        else {
            return jsonResp;
        }
    }

    public static String getJsonValueFromFile(String fileName, String path) {
        ClassLoader classLoader = DataMapper.class.getClassLoader();

        String jsonBody = null;
        try {
            jsonBody = DataMapper.readFromInputStream(classLoader.getResourceAsStream("loader/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonPath.read(jsonBody, path).toString();
    }

    public static String applyJsonAlterations(
            @NonNull final String json, @NonNull final List<JsonPathAlteration> alterations) {
        DocumentContext jsonContext = JsonPath.parse(json);
        for (final JsonPathAlteration alteration : alterations) {
            Objects.requireNonNull(alteration.getPath(), "The 'path' is required for any alteration");

            final boolean valueIsJson = alteration.getValue() != null &&
                    alteration.getValue().getClass().getName().equals("java.lang.String")
                    && !alteration.getValue().toString().isEmpty()
                    && ((alteration.getValue().toString().startsWith("{") && alteration.getValue().toString().endsWith("}"))
                    || (alteration.getValue().toString().startsWith("[") && alteration.getValue().toString().endsWith("]")));
            final Object value = valueIsJson ? readJson(alteration.getValue().toString()) : alteration.getValue();

            switch (alteration.getAction()) {
                case "ADD_FIELD":
                    if (alteration.getField() != null) {
                        jsonContext = jsonContext.put(alteration.getPath(), alteration.getField(), value);
                        break;
                    }
                    // Intentional fall through to ADD_VALUE
                case "ADD_VALUE":
                    jsonContext = jsonContext.add(alteration.getPath(), value);
                    break;
                case "DELETE":
                    jsonContext = jsonContext.delete(alteration.getPath());
                    break;
                case "REPLACE":
                    System.out.println("replacing the value in path: " + alteration.getPath() + " with value: " + value);
                    jsonContext = jsonContext.set(alteration.getPath(), value);
                    break;
            }
        }

        return jsonContext.jsonString();
    }

    public static Object extractValueFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static String extractStringValueFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static int extractIntegerValueFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static Boolean extractBooleanValueFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static ArrayList<String> extractArrayListStringFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static ArrayList<Integer> extractArrayListIntegerFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    public static JsonArray extractJsonArrayValueFromJsonString(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    private static Object readJson(final String json) {
        try {
            final JSONParser parser = new JSONParser(DEFAULT_PERMISSIVE_MODE);

            return parser.parse(json);
        } catch (final ParseException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static String generateRandomVin() {
        return RandomStringUtils.randomAlphanumeric(new Random().nextInt(13) + 3).toUpperCase() + RandomStringUtils.randomNumeric(6);
    }

    public static String generateRandomSystemNumber() {
        return RandomStringUtils.randomAlphanumeric(16).toUpperCase();
    }

    public static String generateRandomVrm() {
        return RandomStringUtils.randomAlphanumeric(new Random().nextInt(6) + 3).toUpperCase();
    }

    public static String generateRandomVrmForEmailValidations() {
        return "AUT" + RandomStringUtils.randomAlphanumeric(5).toUpperCase();
    }

    public static String getJsonStringFromJsonPath(String fileName, String path) {
        ClassLoader classLoader = DataMapper.class.getClassLoader();

        String jsonBody = null;
        try {
            jsonBody = DataMapper.readFromInputStream(classLoader.getResourceAsStream("loader/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = null;
        try {
            jsonResp = mapperObj.writeValueAsString(JsonPath.read(jsonBody, path));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonResp;
    }

    public static String getValueFromJsonPath(String jsonBody, String path) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = null;
        try {
            jsonResp = mapperObj.writeValueAsString(JsonPath.read(jsonBody, path));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (jsonResp.startsWith("\"") && jsonResp.endsWith("\"")) {
            return jsonResp.substring(1, jsonResp.length()-1);
        }
        else {
            return jsonResp;
        }
    }

    public static String getJsonStringFromHashMap(HashMap<String, String> hashMap) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = null;
        try {
            jsonResp = mapperObj.writeValueAsString(hashMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonResp;
    }

    public static String getPartialVinFromVin(String randomVin) {
        if (randomVin.length() >= 6) {
            return randomVin.substring(randomVin.length()-6);
        }
        else {
            return randomVin;
        }
    }
}
