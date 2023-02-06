package br.com.poc.util.commons;

import br.com.poc.properties.PropertiesLoader;

public final class Constant {
    static PropertiesLoader pl = PropertiesLoader.getInstance();

    public static final String BASE_URL = pl.getValue("base.url");
    public static final String ENDPOINT_REGISTER_PAGE =pl.getValue("endpoint.register.page");
    public static final String ENDPOINT_INDEX_PAGE = pl.getValue("endpoint.index.page");
    public static final String ENVIROMENT = pl.getValue("enviroment");
    public static final String SPRINT = pl.getValue("sprint");

    public static final String PROJECT_NAME = "POC";

}
