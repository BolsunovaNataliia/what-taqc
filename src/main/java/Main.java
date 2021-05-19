package main.java;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TestNG testng = new TestNG();
        testng.setUseDefaultListeners(false);
        List<String> suites = Arrays.asList(args);
        testng.setTestSuites(suites);
        testng.run();
    }
}

