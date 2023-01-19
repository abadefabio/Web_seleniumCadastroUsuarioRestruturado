package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberReport.json", "html:target/reports/"},
        features = "classpath:/features",
        tags = {"@mensagem"},
//        tags = {"~@ignore"},
        glue = {"steps"}
)
public class RunCucumberTest extends RunBase {

    //public static WebDriver driver;

    @AfterClass
    public  static void stop(){
        driver.quit();
        System.out.println("Parou a aplicacao");
    }
}
