package com.mockito.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.mockito.repoistory.DependencyPowerMock;
import com.mockito.service.SystemUnderTestPowermock;
import com.mockito.service.UtilityClass;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class SUTPowerMockTest {
	
	@Mock
	DependencyPowerMock dependencyMock;
	
	@InjectMocks
	SystemUnderTestPowermock sutmock;

	@Test
	public void test_Static() {
		// given
		given(dependencyMock.retrieveAllStats()).willReturn(Arrays.asList(1,2,3,4));
		
		//preparation for mocking a  class that contains static method
		PowerMockito.mockStatic(UtilityClass.class);
		given(UtilityClass.staticMethod(10)).willReturn(150);
		
		// when
		int finalOutput = sutmock.methodCallingAStaticMethod();
		
		// then
		PowerMockito.verifyStatic();
		assertThat(finalOutput, is(150));
		
	}
	
	@Test
	public void test_private() throws Exception {
		// given
		given(dependencyMock.retrieveAllStats()).willReturn(Arrays.asList(1,2,3,4));
		
		// preparation for calling a private method and when
		long result = Whitebox.invokeMethod(sutmock, "privateMethodUnderTest");
		
		// then
		assertThat(result, is(10l));
		
	}

}
