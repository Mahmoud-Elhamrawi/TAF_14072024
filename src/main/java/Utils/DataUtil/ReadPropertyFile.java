package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertyFile {


    public static String propertyFilePath = "src/main/resources/";


    //load property file
    public static Properties loadPropertyFile() {
        try {
            Properties properties = new Properties();
            Collection<File> collectionFiles;
            collectionFiles = FileUtils.listFiles(new File(propertyFilePath), new String[]{"properties"}, true);
            collectionFiles.forEach(
                    file -> {
                        try {
                            properties.load(new FileInputStream(file));
                            properties.putAll(System.getProperties());
                            System.getProperties().putAll(properties);
                        } catch (Exception e) {
                            LogClass.error("fail to load property file", e.getMessage());
                        }
                    });
            return properties;
        } catch (Exception e) {
            LogClass.error("fail to load property file", e.getMessage());
            return null;
        }
    }




    public static String getPropertyKey(String key) {
        {
            try {
                return System.getProperty(key);
            } catch (Exception e) {
                LogClass.error("fail to get property key", e.getMessage());
                return "0";
            }
        }
    }


}
