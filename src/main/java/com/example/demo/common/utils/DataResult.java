package com.example.demo.common.utils;

import com.example.demo.common.exception.code.BaseResponseCode;
import com.example.demo.common.exception.code.ResponseCodeInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回值DataResult
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
public class DataResult {

    /**
     * 请求响应code，0为成功 其他为失败
     */
    @ApiModelProperty(value = "请求响应code，0为成功 其他为失败", name = "code")
    private int code;

    /**
     * 响应异常码详细信息
     */
    @ApiModelProperty(value = "响应异常码详细信息", name = "msg")
    private String message;

    @ApiModelProperty(value = "需要返回的数据", name = "data")
    private Object result;

    public DataResult(int code, Object data) {
        this.code = code;
        this.result = data;
        this.message=null;
    }

    public DataResult(int code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.result = data;
    }

    public DataResult(int code, String msg) {
        this.code = code;
        this.message = msg;
        this.result=null;
    }


    public DataResult() {
        this.code= BaseResponseCode.SUCCESS.getCode();
        this.message=BaseResponseCode.SUCCESS.getMsg();
        this.result=null;
    }

    public DataResult(Object data) {
        this.result = data;
        this.code=BaseResponseCode.SUCCESS.getCode();
        this.message=BaseResponseCode.SUCCESS.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface) {
        this.result = null;
        this.code = responseCodeInterface.getCode();
        this.message = responseCodeInterface.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface, Object data) {
        this.result = data;
        this.code = responseCodeInterface.getCode();
        this.message = responseCodeInterface.getMsg();
    }
    /**
     * 操作成功 data为null
     */
    public static DataResult success(){
        return new DataResult();
    }
    /**
     * 操作成功 data 不为null
     */
    public static DataResult success(Object data){
        return new DataResult(data);
    }

    /**
     * 操作失败 data 不为null
     */
    public static DataResult fail(String msg){
        return new DataResult(BaseResponseCode.OPERATION_ERRO.getCode(),msg);
    }
    /**
     *  自定义返回  data为null
     */
    public static DataResult getResult(int code,String msg){
        return new DataResult(code,msg);
    }
    /**
     * 自定义返回 入参一般是异常code枚举 data为空
     */
    public static DataResult getResult(BaseResponseCode responseCode){
        return new DataResult(responseCode);
    }


}
