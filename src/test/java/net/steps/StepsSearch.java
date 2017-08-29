package net.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


import java.net.MalformedURLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StepsSearch {

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("Entered setUp in Simple Steps");
    }

    @After
    public void tearDown() throws Exception {
    }
}
