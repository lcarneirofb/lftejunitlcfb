package runner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import scripted_tests.LiferayTestSuite;

public class TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(LiferayTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if(result.wasSuccessful()){
            System.out.println("-------------------------------------------");
            System.out.println("All tests passed successfully");
            System.out.println("Runned Tests: " + result.getRunCount() + "\nPassed Tests: "+ (result.getRunCount()-result.getFailureCount()) + "\nFailed Tests: " + result.getFailureCount());
            System.out.println("-------------------------------------------");
        }
        else{
            System.out.println("-------------------------------------------");
            System.out.println("One or more test failed");
            System.out.println("Runned Tests: " + result.getRunCount() + "\nPassed Tests: " + (result.getRunCount()-result.getFailureCount()) + "\nFailed Tests: " + result.getFailureCount());
            System.out.println("-------------------------------------------");
        }
    }
}