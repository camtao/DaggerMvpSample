package com.lianqi.union.daggermvpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lianqi.union.daggermvpsample.bean.PhoneLocationBean;
import com.lianqi.union.daggermvpsample.component.ApiServiceComponent;
import com.lianqi.union.daggermvpsample.component.DaggerMainPresenterComponent;
import com.lianqi.union.daggermvpsample.component.MainPresenterComponent;
import com.lianqi.union.daggermvpsample.module.MainPresenterModule;
import com.lianqi.union.daggermvpsample.presenter.MainPresenterImpl;
import com.lianqi.union.daggermvpsample.view.IMainView;

import javax.inject.Inject;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements IMainView {

    @Bind(R.id.et)
    EditText et;
    @Bind(R.id.tv_location)
    TextView tvLocation;
    private ApiServiceComponent apiServiceComponent;


    Retrofit retrofit;

    @Inject
    MainPresenterImpl mainPresenter;
    private MainPresenterComponent mainPresenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiServiceComponent = ((MyApp) getApplicationContext()).getApiServiceComponent();
        retrofit = apiServiceComponent.getRetrofit();
        mainPresenterComponent = DaggerMainPresenterComponent.builder().mainPresenterModule(new MainPresenterModule(this, this.retrofit)).build();
        mainPresenterComponent.inject(this);
    }

    @OnClick(R.id.bt)
    public void onClick() {
        String phone = et.getText().toString();
        mainPresenter.queryPhoneLocation(phone);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLocationMsg(PhoneLocationBean phoneLocationBean) {
        tvLocation.setText(phoneLocationBean.getProvince()+phoneLocationBean.getCity()+phoneLocationBean.getSupplier());
    }
}
