package Utils.LogUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClass {

    public static final String logPath = "test-outputs/Logs";

    //set logger
    public static Logger setLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }


    //get logger
    public static void info(String... msg) {
        setLogger().info(String.join(" ", msg));
    }

    public static void error(String... msg) {
        setLogger().error(String.join(" ", msg));
    }

    public static void debug(String... msg) {
        setLogger().debug(String.join(" ", msg));
    }


}
