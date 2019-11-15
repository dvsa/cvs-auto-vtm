package util;

import org.apache.commons.exec.environment.EnvironmentUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TypeLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";
    private static final List<String> PROFILE_LIST = Arrays.asList("CI");

    static {
        try {
            properties = new Properties();
            InputStream fileInput = EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH);

            if (fileInput != null) {
                properties.load(fileInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EnvironmentType getType() {
        return isProfileActive() ? EnvironmentType.get(getProfileName()) : EnvironmentType.get(properties.getProperty("type"));
    }

    public static String getBsUsername() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getenv("BROWSERSTACK_USERNAME");
                break;
            default:
                userName = properties.getProperty("browserstack.username");
                break;

        }
        return userName;
    }


    public static String getBsPass() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getenv("BROWSERSTACK_ACCESS_KEY");
                break;
            default:
                userName = properties.getProperty("browserstack.password");
                break;

        }
        return userName;
    }


    private static boolean isProfileActive() {
        return PROFILE_LIST.stream().anyMatch(t -> t.equalsIgnoreCase(getProfileName()));
    }

    private static String getProfileName() {
        return System.getProperty("environment");
    }

}
