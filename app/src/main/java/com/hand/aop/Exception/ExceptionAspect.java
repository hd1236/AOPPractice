package com.hand.aop.Exception;


import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 测试捕获全局异常
 */
@Aspect
public class ExceptionAspect {

    @Pointcut("execution(* com.hand.aop..*(..))")
    public void catchException(){};

    @AfterThrowing(pointcut = "catchException()",throwing = "throwable")
    public void catchExceptionMethod(Throwable throwable){
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        for(StackTraceElement e : stackTraceElements){
            Log.i("ExceptionAspect","catch exception:"+e.toString());
        }

    }
}
