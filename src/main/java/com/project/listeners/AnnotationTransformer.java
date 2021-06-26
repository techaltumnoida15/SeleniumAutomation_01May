package com.project.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//annotation.setRetryAnalyzer(c);
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IListenersAnnotation annotation, Class<?> testClass) {
		IAnnotationTransformer.super.transform(annotation, testClass);
	}

}
