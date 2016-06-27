package com.lianqi.union.daggermvpsample.component;

import com.lianqi.union.daggermvpsample.MainActivity;
import com.lianqi.union.daggermvpsample.module.MainPresenterModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/6/27.
 */
@Component(modules = {MainPresenterModule.class})
public interface MainPresenterComponent {
    void inject(MainActivity mainActivity);
}
