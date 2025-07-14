package Utils.AllureUil;

import Utils.FileUtill.FileClass;
import Utils.LogUtil.LogClass;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static Utils.DataUtil.ReadPropertyFile.getPropertyKey;
import static Utils.Terminal.ExecuteTerminal.executeTerminal;

public class AllureClass {

    // add screenshot to allure report
    public static void addScreenshotToAllureReport(String screenname, String screenPath) {

        try {
            Allure.addAttachment(screenname, Files.newInputStream(Path.of(screenPath)));
            LogClass.info("Screenshot added to allure report");
        } catch (Exception e) {
            LogClass.error("Unable to add screenshot to allure report", e.getMessage());
        }

    }

    //add log to allure report
    public static void addLogToAllureReport() {
        try {
            File lastFile = FileClass.getLastFile(LogClass.logPath);

            assert lastFile != null;
            Allure.addAttachment("Logs", Files.readString(lastFile.toPath()));
            LogClass.info("Logs added to allure report");
        } catch (Exception e) {
            LogClass.error("Unable to add log to allure report", e.getMessage());
        }


    }


    //generate  allure report
    static String USER_HOME = System.getProperty("user.home");
    static String ALLURE_REPORT_PATH = "test-outputs/allure-report/";
    static String ALLURE_RESULT_PATH = "test-outputs/target/allure-results/";
    static String Allure_Bin = USER_HOME + File.separator + ".m2" + File.separator + "repository" + File.separator + "allure" + File.separator + "2.34.1" + File.separator + "bin" + File.separator + "allure";


    public static void generateAllureReport() {
        if (System.getProperty("os.name").toLowerCase().contains("wind")) {
            String WIN = Allure_Bin + ".bat";
            executeTerminal(WIN, "generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
            LogClass.info("Generating allure report on windows");
        } else {
            executeTerminal("generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
            LogClass.info("Generating allure report on linux");
        }

    }


    //open allure report

    public static void openAllureReport() {
        String Allure_Index = ALLURE_REPORT_PATH + File.separator + "index.html";

        if (getPropertyKey("openAllureReport").equalsIgnoreCase("true")) {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                executeTerminal("cmd", "/c", "start", Allure_Index);
                LogClass.info("Opening allure report on windows");
            } else {
                executeTerminal("xdg-open", Allure_Index);
                LogClass.info("Opening allure report on linux");
            }

        } else {
            LogClass.info("check openAllureReport in property file");
        }


    }


}
