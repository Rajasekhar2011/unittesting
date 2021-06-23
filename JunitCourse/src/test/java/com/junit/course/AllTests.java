package com.junit.course;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ParameterizedTests.class, StringHelperTest.class })
public class AllTests {

}
