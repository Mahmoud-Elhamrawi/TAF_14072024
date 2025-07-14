package Utils.FileUtill;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileClass {


    // get last file
    public static File getLastFile(String file) {
        File file1 = new File(file);
        if (!file1.exists()) {
            LogClass.error("File does not exist");
            return null;
        }

        File[] files = file1.listFiles();
        assert files != null;
        if (files.length == 0) {
            LogClass.error("File is empty");
            return null;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


    // clean folder
    public static void cleanFolder(File folder) {
        try {
            FileUtils.deleteQuietly(folder);
        }catch (Exception e)
        {
            LogClass.error("fail to clean folder",e.getMessage());
        }
    }

}
