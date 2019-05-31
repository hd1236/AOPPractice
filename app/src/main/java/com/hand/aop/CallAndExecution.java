package com.hand.aop;

import android.util.Log;

import com.hand.aop.CallAndExecutionAspect.CallAndExecutionAspect;
import com.hand.aop.CallAndExecutionAspect.CallLog;

public class CallAndExecution {


    @CallLog
    public void handle(){
        Log.i("CallAndExecutionAspect","handle");
    }

}
