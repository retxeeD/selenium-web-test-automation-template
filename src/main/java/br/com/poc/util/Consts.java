package br.com.poc.util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public final class Consts {
    static Yaml yaml = new Yaml();
    static InputStream inputStream;

    static {
        try {
            inputStream = new FileInputStream("data.yaml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static Map<String, Object> data = yaml.load(inputStream);

    public static final String BASE_URL = data.get("baseUrl").toString();
    public static final String ENDPOINT_REGISTER_PAGE = data.get("endpointRegisterPage").toString();
    public static final String ENVIROMENT = data.get("enviroment").toString();
    public static final String SPRINT = data.get("sprint").toString();


}
