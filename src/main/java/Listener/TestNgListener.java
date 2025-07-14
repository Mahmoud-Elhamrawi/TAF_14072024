package Listener;

import Utils.AllureUil.AllureClass;
import Utils.ClassesUtil.UtilClass;
import Utils.FileUtill.FileClass;
import Utils.LogUtil.LogClass;
import io.qameta.allure.internal.shadowed.jackson.databind.util.ClassUtil;
import org.testng.*;

import java.io.File;

import static Utils.AllureUil.AllureClass.generateAllureReport;
import static Utils.AllureUil.AllureClass.openAllureReport;
import static Utils.DataUtil.ReadPropertyFile.loadPropertyFile;

public class TestNgListener implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File screenshotPath = new File("test-outputs/screenshots/");
    File LogPath = new File("test-outputs/Logs/");
    File allureResults = new File("test-outputs/target/allure-results/");

    @Override
    public void onExecutionStart() {
        LogClass.info("Test started");
        loadPropertyFile();

        FileClass.cleanFolder(screenshotPath);
        LogClass.info("Delete Previous Screenshots");


        FileClass.cleanFolder(LogPath);
        LogClass.info("Delete Previous Logs");


        FileClass.cleanFolder(allureResults);
        LogClass.info("Delete Previous Allure Results");

    }

    @Override
    public void onExecutionFinish() {
        LogClass.info("Test finished");
        generateAllureReport();
        openAllureReport();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> UtilClass.takeScreenshot("Passed_" + testResult.getName());
                case ITestResult.FAILURE -> UtilClass.takeScreenshot("Failed_" + testResult.getName());
                case ITestResult.SKIP -> UtilClass.takeScreenshot("Skipped_" + testResult.getName());
            }
            AllureClass.addLogToAllureReport();
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case", result.getMethod().getMethodName(), "started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case", result.getMethod().getMethodName(), "passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.error("Test Case", result.getMethod().getMethodName(), "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.info("Test Case", result.getMethod().getMethodName(), "skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "finished");
    }

}
