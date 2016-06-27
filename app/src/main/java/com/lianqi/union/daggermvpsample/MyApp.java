package com.lianqi.union.daggermvpsample;

import android.app.Application;

import com.lianqi.union.daggermvpsample.component.ApiServiceComponent;
import com.lianqi.union.daggermvpsample.component.DaggerApiServiceComponent;
import com.lianqi.union.daggermvpsample.module.ApiServiceModule;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MyApp extends Application {

    private ApiServiceComponent apiServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiServiceComponent = DaggerApiServiceComponent.builder().apiServiceModule(new ApiServiceModule("http://apis.baidu.com/apistore/")).build();
    }

    public ApiServiceComponent getApiServiceComponent() {
        return apiServiceComponent;
    }
}
