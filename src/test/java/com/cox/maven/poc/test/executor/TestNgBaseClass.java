package com.cox.maven.poc.test.executor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * @author asreekanta
 *
 */
public class TestNgBaseClass {
	
	private static final Logger logger = LoggerFactory.getLogger(TestNgBaseClass.class);

	WebDriver driver;
	WebDriverWait wait;
	protected String baseUrl;
	private final String macPath;
	private final String windowsPath;
	private static final DesiredCapabilities capability = new DesiredCapabilities();
	private Map<String, String> testParameters;
	private final ArrayList<ArrayList<String>> systemParameters;
	String region="QA";

	/**
	 * Constructor
	 * 
	 */
	public TestNgBaseClass() {
		this.testParameters = new HashMap<>();
		this.systemParameters = new ArrayList<>();
		baseUrl = "";
		this.macPath = "src//test//resources//drivers//mac//";
		this.windowsPath = "src//test//resources//drivers//windows";
	}

	@BeforeClass(alwaysRun = true)
	@Parameters("browserName")
	public void setUp(String browserName) throws Exception {
		setupDriver(browserName);
		baseUrl = capability.getCapability("baseUrl").toString();
		if (System.getProperty("region") != null) {
	        region = System.getProperty("region");
	    }
		if(region.equalsIgnoreCase("QA")){
			
		}
		System.out.println("System.getProperty"+System.getProperty("region"));
	}

	/**
	 * Made this function for readability. For example, instead of doing this
	 * loginScreenModule.loginToDealerSite(capability.getCapability("userName").toString(),
	 * capability.getCapability ("userPassword").toString()) by doing this
	 * loginScreenModule.loginToDealerSite(parameter("userName"),
	 * parameter("userPassword")) is cleaner. Additionally, use this method for
	 * arbitrary parameters such as logging into the database, navigating to
	 * another url, or etc. The code can be,
	 * loginScreenModule.thisExampleModuleToLoginTheDb(parameter("dbUserName"),
	 * parameter("dbUserPassword")) and your testng.xml will pass the dbUserName
	 * and dbUserPassword.
	 *
	 * @param paramName
	 *            in value
	 *
	 * @return out value
	 */
	protected String parameter(String paramName) {
		return capability.getCapability(paramName).toString();
	}

	@BeforeSuite(alwaysRun = true)
	public void suiteSetUp() throws Exception {
		setupCapabilities();
	}

	/**
	 * This will set all capabilities passed in from XML and CommandLine.
	 * CommandLine has precedence over XML.
	 */
	private void setupCapabilities() {
		// Gathers params from xml
		testParameters = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getTestParameters();

		ITestResult result = Reporter.getCurrentTestResult();
		if (testParameters != null) {
			for (Object o : testParameters.entrySet()) {
				Map.Entry pair = (Map.Entry) o;
				if (pair.getValue() != null) {
					capability.setCapability(pair.getKey() + "", pair.getValue() + "");
				}
			}
		}

		// if params were passed into command line it will place them into the
		// param list for the test
		// any duplicates will be overridden
		if (System.getProperty("testparameters") != null) {
			parseTestParameters(System.getProperty("testparameters"));

			for (ArrayList<String> systemParameter : systemParameters) {
				String key = systemParameter.get(0);
				String value = systemParameter.get(1);

				capability.setCapability(key, value);
			}
		}

		result.getTestContext().setAttribute("reportingParameters", capability.asMap());
	}

	/**
	 * This will parse the system params using -TP as a flag and place them into
	 * systemParameters Map. Ensure when you use the mvn commandline you are
	 * passing '-Dtestparameters' and NOT '-DtestParameters'. If you use the
	 * capital 'P' your mvn commandline will NOT overwrite the testng.xml
	 * parameters.
	 *
	 * @param testParameters
	 *            in value
	 */
	private void parseTestParameters(String testParameters) {
		for (String splitText : testParameters.split("-TP")) {
			String[] s = splitText.trim().split("='");
			if (s.length > 1) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(s[0]);
				temp.add(s[1].substring(0, s[1].length() - 1));
				systemParameters.add(temp);
			}
		}
	}

	/**
	 * Checks to see if local is set to false. If so it will setup a remoteUrl
	 * and use the capabilities set by setup Capabilities method. If local is
	 * true it will check to see if browserName is set to chrome or ie and if
	 * not it will default to the selenium default of firefox.
	 *
	 * @param browserName
	 *            in value
	 *
	 * @throws MalformedURLException
	 *             on error
	 */

	private void setupDriver(String browserName) throws MalformedURLException {
		if (!Boolean.parseBoolean(capability.getCapability("local").toString())) {
			capability.setCapability("browserstack.local", "true");
			capability.setCapability("browserstack.debug", "true");
			if (browserName.equalsIgnoreCase("firefox")) {
				capability.setCapability("browserName", "firefox");
			} else if (browserName.equalsIgnoreCase("chrome")) {
				capability.setCapability("browserName", "chrome");
			}
			capability.setCapability("acceptSslCerts", true);
			try {
				driver = new RemoteWebDriver(new URL(capability.getCapability("remoteUrl").toString()), capability);
			} catch (org.openqa.selenium.WebDriverException e) {
				driver = new RemoteWebDriver(new URL(capability.getCapability("remoteUrl").toString()), capability);
			}
		} else {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.out.println(System.getProperty("os.name"));
				if (System.getProperty("os.name").startsWith("Mac")) {
					System.setProperty("webdriver.chrome.driver", macPath.concat("chromedriver"));
				} else {
					System.setProperty("webdriver.chrome.driver", windowsPath.concat("chromedriver.exe"));
				}
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("internet explorer")) {
				System.setProperty("webdriver.ie.driver", windowsPath.concat("IEDriverServer.exe"));
				driver = new InternetExplorerDriver();
			} else {
				// You don't need to set the path as FireFox driver is built
				// into Selenium,
				// but you must have FireFox installed.
				if (System.getProperty("os.name").startsWith("Mac")) {
					//System.setProperty("webdriver.gecko.driver", macPath.concat("geckodriver"));
					//FirefoxDriverManager.getInstance().setup();
					//System.setProperty("webdriver.firefox.marionette", macPath.concat("geckodriver"));
				}
				driver = new FirefoxDriver();
			}
		}
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
	}
	
	/**
     * Tear down the Web Driver
     *
     * @throws IOException on error
     */
    @AfterClass(alwaysRun = true)
    public void teardown() throws IOException {
        // This takes a screenshot of the 'test(s)' when the @AfterClass is called. This is useful when using the
        // Selenium Grid.
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd hh mm a");
            Date date = new Date();

            FileUtils.copyFile(screenshot,
                new File(
                    "tmp" + File.separator + "ID-" + ((RemoteWebDriver) driver).getSessionId() + "-DATE-"
                        + dateFormat.format(date) + ".png"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        if (System.getProperty("os.name").startsWith("Windows")) {
            // Some folks have non-windows laptop and this causes failure since there is no such 'taskkill' executable
            // on non-windows OS
            Runtime.getRuntime().exec("taskkill /f /im plugin-container.exe");
        }
        driver.quit();
    }

}
