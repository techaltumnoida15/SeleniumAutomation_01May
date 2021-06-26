package com.project.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.project.utils.ExcelUtility;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<Map<String, String>> testDetails;
		List<IMethodInstance> testToRun = new ArrayList<>();
		
		try {
			testDetails = ExcelUtility.getTestDetails("RunnerConfig");
			
			for(int i = 0; i<methods.size(); i++) {
				for (int j = 0; j < testDetails.size(); j++) {
					
					if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testDetails.get(j).get("TestName")) 
						&&
						testDetails.get(j).get("Run").equalsIgnoreCase("yes")) {
							methods.get(i).getMethod().setDescription(testDetails.get(j).get("Description"));
							methods.get(i).getMethod().setRetryAnalyzerClass(ReTryListiner.class);
							testToRun.add(methods.get(i));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testToRun;
	}
}
