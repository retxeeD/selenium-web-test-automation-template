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

    public static final String base_url = data.get("baseUrl").toString();
    public static final String endpoint_register_page = data.get("endpointRegisterPage").toString();
    public static final String enviroment = data.get("enviroment").toString();
    public static final String tester = data.get("tester").toString();
    public static final String sprint = data.get("sprint").toString();


}
