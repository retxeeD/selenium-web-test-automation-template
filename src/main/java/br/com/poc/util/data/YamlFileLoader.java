package br.com.poc.util.data;


import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/*
* This class allow that the ymal properties to be read
* */
public class YamlFileLoader {

    public static Object getAttribute(String path, String... param) throws Exception{
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        Yaml yaml = new Yaml();

        Map<?, ?> mapAux = (Map<?, ?>) yaml.load(inputStream);

        if (mapAux == null){
            throw new Exception(
                    String.format("Test mass not found in the file %s", file.getName())
            );
        }

        int count;

        for (count = 0; count < (param.length -1); count++) {
            mapAux = (Map<?, ?>) mapAux.get(param[count]);
        }
        if(Character.isDigit(param[count].charAt(0))){
            return mapAux.get(Integer.parseInt(param[count]));
        }

        return mapAux.get(param[count]);
    }
}
