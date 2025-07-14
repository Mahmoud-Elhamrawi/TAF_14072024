package Utils.Terminal;

import Utils.LogUtil.LogClass;

public class ExecuteTerminal {

    public static void executeTerminal(String... command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            LogClass.error("fail to execute terminal", e.getMessage());
        }


    }


}
