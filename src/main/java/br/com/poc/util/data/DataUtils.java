package br.com.poc.util.data;

import br.com.poc.config.BaseTest;

public class DataUtils {

    public static final String URLs = "src/test/resources/authentication.yaml";

    public static String getAuthData(String title, String param) throws Exception{
        String environment = BaseTest.getEnvironment();
        return YamlFileLoader
                .getAttribute(DataUtils.URLs, title, environment, param).toString();
    }

}
