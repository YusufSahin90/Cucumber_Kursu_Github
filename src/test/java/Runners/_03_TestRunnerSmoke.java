package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Aşağıdaki seçenekde tags eklendi içinde grup adına
 * sahip senaryolar çalıştıralacak sadece tüm senaryolardan
 * tags etiketi sınırlama yaptı sadece bu etikete veya grup adına sahip
 * olanlar çalışacak
 */

@CucumberOptions(
        tags = {"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = { //basit rapor oluşturan plugin     // bu bolum sonradan jenkins report icin eklendi
                "html:target/cucumber-report",
                "json:target/cucumber.json"
        }
)
public class _03_TestRunnerSmoke extends AbstractTestNGCucumberTests {

}
