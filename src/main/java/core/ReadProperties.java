package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    protected Properties properties;

    public ReadProperties(){
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getBrowserName(){
        return properties.getProperty("browser");
    }

    public int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getDbUrl() {
        return properties.getProperty("db_url");
    }

    public String getDbUsername() {
        return properties.getProperty("db_username");
    }

    public String getDbPsw() {
        return properties.getProperty("db_psw");
    }
}
