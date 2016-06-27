package com.lianqi.union.daggermvpsample.service;

import com.lianqi.union.daggermvpsample.RequestResult;
import com.lianqi.union.daggermvpsample.bean.PhoneLocationBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/27.
 */
public interface IApiService {

    @GET("mobilenumber/mobilenumber")
    Call<RequestResult<PhoneLocationBean>> queryPhoneLocation(@Header("apikey") String apikey, @Query("phone") String phone);
}
