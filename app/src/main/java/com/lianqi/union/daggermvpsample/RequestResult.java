package com.lianqi.union.daggermvpsample;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/27.
 */

public class RequestResult<T> implements Serializable {
    public String retMsg;
    /** 请求状态, 0失败，1成功 */
    public int errNum;
    private T retData;

    public String getRetMsg() {
        return retMsg;
    }

    public int getErrNum() {
        return errNum;
    }

    public T getRetData() {
        return retData;
    }
}
