package api_tests;

import org.testng.annotations.BeforeSuite;
import service.DBWorker;

public abstract class BaseSetUp {

    @BeforeSuite
    public void setUpDB() {
        DBWorker.startFilling();
    }

}
