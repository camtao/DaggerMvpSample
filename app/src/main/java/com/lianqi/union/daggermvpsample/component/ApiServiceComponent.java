package com.lianqi.union.daggermvpsample.component;

import com.lianqi.union.daggermvpsample.module.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/27.
 */
@Singleton
@Component(modules = {ApiServiceModule.class})
public interface ApiServiceComponent {
    Retrofit getRetrofit();
}
