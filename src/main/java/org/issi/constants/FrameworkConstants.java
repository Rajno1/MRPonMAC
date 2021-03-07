package org.issi.constants;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String MAINRESOURCEPATH = System.getProperty("user.dir") + "/src/main/resources";
    private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final int EXPLICITWAIT = 10;

    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/config.properties";
    private static final String EXCELFILEPATH = TESTRESOURCESPATH +"/Test_Data/Testdata.xlsx";


    private static final String powerOfAttorneyFormPath = "/Users/rajasekhar/Desktop/Manual Testing.pdf";
   // private static final String powerOfAttorneyFormPath = "C:/Users/Admin/Downloads/AuthorizedRep-Web.pdf";


    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getPowerOfAttorneyFormPath() {
        return powerOfAttorneyFormPath;
    }




}
