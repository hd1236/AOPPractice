package com.hand.aop.CallAndExecutionAspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CallAndExecutionAspect {

    public static final String TAG = CallAndExecutionAspect.class.getSimpleName();

    public static final String POINTCUT_CALL = "(call(* com.hand.aop.CallAndExecution+.*(..)))";
    public static final String POINTCUT_EXECUTION = "execution(* com.hand.aop.CallAndExecution+.*(..))";

    @Pointcut(POINTCUT_CALL)
    public void methodCall(){
    }

    @Pointcut("execution(* com.hand.aop.CallAndExecution.*(..))")
    public void methodExecution(){}

    @Before("methodCall()")
    public void handleCall(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        Object it = joinPoint.getThis();
        Log.i(TAG,"Call target:"+target+"--this:"+it);
    }

    @Before("methodExecution()")
    public void handleExecution(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        Object it = joinPoint.getThis();
        Log.i(TAG,"Execution target:"+target+"--this:"+it);
    }

//    @Pointcut("call(@com.hand.aop.CallAndExecutionAspect.CallLog * *(..))")
//    public void methodAnnotation(){}
//
//    @Before("methodAnnotation()")
//    public void handleAnnotation(JoinPoint joinPoint){
//        Object target = joinPoint.getTarget();
//        Object it = joinPoint.getThis();
//        Log.i(TAG,"Call target:"+target+"--this:"+it);
//    }



}
