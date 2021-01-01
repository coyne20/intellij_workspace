package co.edureka;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

public class AssertMain {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(Assert.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Result == "+result.wasSuccessful());
    }

}
