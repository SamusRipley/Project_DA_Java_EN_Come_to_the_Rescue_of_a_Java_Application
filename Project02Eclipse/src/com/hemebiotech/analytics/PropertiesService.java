package com.hemebiotech.analytics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

    //new instance of properteis appProps
    private Properties appProps = new Properties();

    public PropertiesService(Properties properties) {
        //declaring the path of string "appConfig"
        String appConfigPath = "Project02Eclipse/src/resources/config.properties";
        try {
            this.appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //returns the file with properties to use in another class
    public String getProperty(String key) {
        return this.appProps.getProperty(key);
    }
}