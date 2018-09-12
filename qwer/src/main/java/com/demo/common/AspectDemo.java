package com.demo.common;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class AspectDemo {
	
	static{
		System.out.println("AspectDemo");
	}
	public void beforeAdvice(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();   
        List<Object> args = Arrays.asList(joinPoint.getArgs());  
        System.out.println("Before ǰ��֪ͨ : ������ �� " + methodName + " ��and args are " + args);  
		
	}
	
    public void afterAdvice(JoinPoint joinPoint){
		
    	String methodName = joinPoint.getSignature().getName();   
        List<Object> args = Arrays.asList(joinPoint.getArgs());  
        System.out.println("After ����֪ͨ : ������ �� " + methodName + " ��and args are " + args);  
    	
	}
    public void afterRunningAdvice(JoinPoint joinPoint, Object result) {  
    	 String methodName = joinPoint.getSignature().getName();   
         List<Object> args = Arrays.asList(joinPoint.getArgs());  
         System.out.println("AfterReturning ����֪ͨ : ������ �� " + methodName + " ��and args are " + args + " , result is " + result);  
    }  

    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
    	String methodName = joinPoint.getSignature().getName();   
        System.out.println("AfterThrowing �쳣֪ͨ : ������ �� " + methodName + " ��and  exception is " + exception);  
    }  
}
