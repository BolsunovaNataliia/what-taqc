package service;


import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBWorker {

    public static void startFilling(){
        try(Connection conn = getConnectionToDB()) {

            System.out.println("Database connection established");

            ScriptRunner sr = new ScriptRunner(conn);
            runResourceScript(sr, "sqlScripts/generate_database.sql");
            runResourceScript(sr, "sqlScripts/data_for_testing.sql");

            System.out.println("Database connection terminated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static Connection getConnectionToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection (getConnectionString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getConnectionString(){
        try(InputStream fis = DBWorker.class.getClassLoader().getResourceAsStream("dbConnect.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            fis.close();
          return String.format("%s:%s://%s:%s@%s:%s/%s?%s",
                  prop.getProperty("typeConnection"),prop.getProperty("typeDB"),prop.getProperty("dbUserName"),
                  prop.getProperty("dbPassword"),prop.getProperty("dbUrl"),prop.getProperty("port"),
                  prop.getProperty("dbName"),prop.getProperty("other"));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void runResourceScript(ScriptRunner sr, String fileName){
        try(InputStream fis = DBWorker.class.getClassLoader().getResourceAsStream(fileName)) {
            Reader reader = new InputStreamReader(fis);
            sr.runScript(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
