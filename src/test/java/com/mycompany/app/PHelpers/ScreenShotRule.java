package com.mycompany.app.PHelpers;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Vitalii_Oborskyi on 1/16/2015.
 */
public class ScreenShotRule  implements MethodRule {
//    public class ScreenshotTestRule implements MethodRule {
        private WebDriver myDriver;
            public ScreenShotRule(WebDriver dr){
            myDriver = dr;
        }
        public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        statement.evaluate();
                    } catch (Throwable t) {
                        captureScreenshot(frameworkMethod.getName());
                        throw t; // rethrow to allow the failure to be reported to JUnit
                    }
                }

                public void captureScreenshot(String fileName) {
                    try {
                        new File("D:/reports/").mkdirs(); // Insure directory is there
                        FileOutputStream out = new FileOutputStream("D:/reports/screenshot-" + fileName + ".png");
                        out.write(((TakesScreenshot) myDriver).getScreenshotAs(OutputType.BYTES));
                        out.close();
                        myDriver.quit();
                    } catch (Exception e) {
                        // No need to crash the tests if the screenshot fails
                    }
                }
            };
        }
    }


//}


