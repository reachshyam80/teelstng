package com.coxautoinc.sfdc.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Utility class to allow failing tests to rerun.
 */
public class TestNGRetry implements IRetryAnalyzer {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(TestNGRetry.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private int retryCount = 0;

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to get the test result status
     *
     * @param status in value
     *
     * @return String containing test status
     */
    private String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }

    /**
     * Method to allow a test to run a maximum of three times if failures occur.
     *
     * @param result in value
     *
     * @return true if a test can be retried.
     */
    public boolean retry(ITestResult result) {
        int maxRetryCount = 2;
        if (retryCount <= maxRetryCount) {
            logger.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for retry number " + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
