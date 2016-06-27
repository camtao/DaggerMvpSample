package com.lianqi.union.daggermvpsample.view;

import com.lianqi.union.daggermvpsample.bean.PhoneLocationBean;

/**
 * Created by Administrator on 2016/6/27.
 */
public interface IMainView extends BaseView {
    void showLocationMsg(PhoneLocationBean retData);
}
