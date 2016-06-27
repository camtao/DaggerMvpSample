package com.lianqi.union.daggermvpsample.module;

import com.lianqi.union.daggermvpsample.MainActivity;
import com.lianqi.union.daggermvpsample.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/27.
 */
@Module
public class MainPresenterModule {

    MainPresenterImpl mainPresenter;

    MainActivity mainActivity;
    Retrofit retrofit;

    public MainPresenterModule(MainActivity mainActivity, Retrofit retrofit) {
        this.mainActivity = mainActivity;
        this.retrofit=retrofit;
    }

    @Provides
    MainPresenterImpl provideMainPresenter(){
        return new MainPresenterImpl(mainActivity,retrofit);
    }
}
