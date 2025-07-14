package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileReader;

public class ReadJsonFile {
    static String fileName;
    static String jsonPathFile = "src/test/resources/testData/";
    static String jsonReader;


    public ReadJsonFile(String fileName) {
        ReadJsonFile.fileName = fileName;
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonPathFile + fileName + ".json")) ;
            jsonReader = jsonObject.toJSONString();
            LogClass.info("json file converted to string");
        } catch (Exception e) {
            LogClass.error("fail to convert  json file to string", e.getMessage());
        }
    }


    public static String getJsonKey(String key) {
        String jsonData = "";
        try {
            jsonData = JsonPath.read(jsonReader, key);
            LogClass.info("json key is " + jsonData);
        } catch (Exception e) {
            LogClass.error("fail to get json key", e.getMessage());
            return "0";
        }
        return jsonData;
    }





}
