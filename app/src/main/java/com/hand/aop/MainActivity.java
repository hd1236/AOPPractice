package com.hand.aop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hand.aop.IgnoreFastClick.IgnoreFastClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            /**
             *  通过注解定义切点
             * @param v
             */
            @IgnoreFastClick(value = 500)
            @Override
            public void onClick(View v) {
                Log.i("yzmhand","btn onClick");
            }
        });

        CallAndExecution cae = new CallAndExecution();
        cae.handle();
    }


    /**
     * 通过前后缀定义切点
     */
    @Override
    protected void onResume() {
        super.onResume();
    }
}
