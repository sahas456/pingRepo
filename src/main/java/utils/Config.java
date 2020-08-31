package utils;


import static utils.ConfigUtil.getProperty;


public class Config {
    public static final String URL= getProperty("URL");
    public static final String BROWSER = getProperty("BROWSER");
    public static final String USERNAME = getProperty("USERNAME");
    public static final String PASSWORD = getProperty("PASSWORD");
    public static final String PROFILEUSER = getProperty("PROFILENAME");
    public static final String DOCKUSERNAME1 = getProperty("DOCKUSERNAME1");
    public static final String DOCKPASSWORD1 = getProperty("DOCKPASSWORD1");
    public static final String DOCKUSERNAME2 = getProperty("DOCKUSERNAME2");
    public static final String DOCKPASSWORD2 = getProperty("DOCKPASSWORD2");

}
