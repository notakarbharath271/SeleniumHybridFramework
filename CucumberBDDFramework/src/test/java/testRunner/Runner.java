package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions
// if we want to execute all the feature file in the feature folder mention below
// if we want to execute specify feature file use like this----> .//Features/login.feature or .//Features/Customer.feature 
	(features= {".//Features/"},
		glue="stepDefinations"	,
		dryRun=false,
		monochrome=true,
	 plugin= {"pretty","html:test-output"},
	 // if we want to execute specify scenario by using tags----->tags= {"@sanity"}
	 //if we want to execute all the scenarios by using tags------>tags= {"@sanity","@regression"}	
	tags= {"@sanity,@regression"}		)
public class Runner {

}
