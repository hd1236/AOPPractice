package com.hand.aop.IgnoreFastClick;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class IgnoreFastClickAspect {

    private long mLastClickTime;
    /**
     * 定义切点，标记切点为所有被@IgnoreFastClick 注解修饰的方法
     */
    @Pointcut("execution(@com.hand.aop.IgnoreFastClick.IgnoreFastClick * *(..))")
    public void ignoreFastClick(){}


    @Around("ignoreFastClick()")
    public void handleFastClick(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取view
        View view  = null;
        for(Object arg : joinPoint.getArgs()){
            if(arg instanceof View){
                view = (View) arg;
            }
        }
        if(view == null){
            return;
        }

        //注解只修饰在方法上
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if(!method.isAnnotationPresent(IgnoreFastClick.class)){
            return;
        }

        //获取注解对象
        IgnoreFastClick ignoreFastClick = method.getAnnotation(IgnoreFastClick.class);
        long value = ignoreFastClick.value();
        long currentTime = System.currentTimeMillis();
        Log.i("yzmhand",mLastClickTime+"---"+currentTime+"---"+value);
        if(currentTime - mLastClickTime > value){
            mLastClickTime = currentTime;
            joinPoint.proceed();
        }
    }
}
