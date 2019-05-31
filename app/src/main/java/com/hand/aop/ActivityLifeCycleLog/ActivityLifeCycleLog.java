package com.hand.aop.ActivityLifeCycleLog;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ActivityLifeCycleLog {

    /**
     * 定义切点,拦截MainActivity中所有on为前缀的方法
     */
    @Pointcut("execution(* com.hand.aop.MainActivity.on*(..))")
    public void onLifeCycleLog(){
    }

    @Before("onLifeCycleLog()")
    public void handleLifeCycleLog(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Log.e("yzmhand",name+"------>"+joinPoint);
    }
}
