package com.lianqi.union.daggermvpsample.presenter;

import com.lianqi.union.daggermvpsample.RequestResult;
import com.lianqi.union.daggermvpsample.bean.PhoneLocationBean;
import com.lianqi.union.daggermvpsample.service.IApiService;
import com.lianqi.union.daggermvpsample.view.IMainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MainPresenterImpl implements IMainPresenter {

    IMainView iMainView;
    Retrofit retrofit;

    public MainPresenterImpl(IMainView iMainView,Retrofit retrofit) {
        this.iMainView = iMainView;
        this.retrofit=retrofit;
    }

    @Override
    public void queryPhoneLocation(String phone) {
        IApiService iApiService = retrofit.create(IApiService.class);
        iApiService.queryPhoneLocation("2f8bf1f62111d1dd81712b0aee792b8a",phone).enqueue(new Callback<RequestResult<PhoneLocationBean>>() {
            @Override
            public void onResponse(Call<RequestResult<PhoneLocationBean>> call, Response<RequestResult<PhoneLocationBean>> response) {
                RequestResult<PhoneLocationBean> locationBeanRequestResult = response.body();
                switch (locationBeanRequestResult.errNum){
                    case 0:
                        iMainView.showLocationMsg(locationBeanRequestResult.getRetData());
                        break;
                    case -1:
                        iMainView.showToast(locationBeanRequestResult.retMsg);
                        break;
                }
            }

            @Override
            public void onFailure(Call<RequestResult<PhoneLocationBean>> call, Throwable t) {
                iMainView.showToast(t.getMessage());
            }
        });
    }
}
