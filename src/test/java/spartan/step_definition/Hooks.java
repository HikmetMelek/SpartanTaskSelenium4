package spartan.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import spartan.utilities.DBUtils;
import spartan.utilities.Driver;

import java.time.Duration;

public class Hooks {

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tConnecting to database...");
        DBUtils.createConnection();
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tDisconnecting to database...");
        DBUtils.destroy();
        Driver.closeDriver();
    }
}
