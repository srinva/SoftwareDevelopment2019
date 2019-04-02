package main.java.app;

public class Var {
    public static String username;
    public static String password;

    public static int points = 0;

    //public static final String LPURL = "jdbc:sqlite:S:\\SoftwareDevelopment2019\\SoftwareDev.db";
    public static final String LPURL = "jdbc:sqlite:C:\\Users\\Srinath\\com.srinath.coding\\SoftwareDevelopment2019\\SoftwareDev.db";
    //public static final String LPURL = "jdbc:sqlite:jasonlong24.crabdance.com/db/SoftwareDev.db";

    public static String id;

    public static double min = 0;


    public static double calculateDays(double min) {
        double power = Math.exp(-min);
        double constant = 1 + power;
        return constant*66;
    }

}
