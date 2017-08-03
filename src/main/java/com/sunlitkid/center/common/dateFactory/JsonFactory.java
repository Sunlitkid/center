package com.sunlitkid.center.common.dateFactory;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.bean.Command;

/**
 * Created by sunke on 2017/7/7.
 */
public class JsonFactory {

    private static final String CODE_SUCCESS_COMMAND = "0000";
    private static final String CODE_SUCCESS_BOOLEAN = "0001";
    private static final String CODE_SUCCESS_STRING = "0002";
    private static final String CODE_SUCCESS_NUMBER = "0003";
    private static final String CODE_SUCCESS_JSON = "0004";


    private static final String CODE_EXCEPTION = "1000";
    private static final String CODE_ERROR = "2000";
    private static final String CODE_PERMISSION_DENIED = "3000";

    private JsonFactory(){};

    ///////////////////success/////////////////////
    public static JSONObject successJson(Command result){
        JSONObject json = successJson();
        json.put("code",CODE_SUCCESS_COMMAND);
        json.put("data",result.getCommand());
        return  json;
    }
    public static JSONObject successJson(Boolean result){
        JSONObject json = successJson();
        json.put("code",CODE_SUCCESS_BOOLEAN);
        json.put("data",result);
        return  json;
    }
    public static JSONObject successJson(String data){
        JSONObject json = successJson();
        json.put("code",CODE_SUCCESS_STRING);
        json.put("data",data);
        return  json;
    }
    public static JSONObject successJson(Number data){
        JSONObject json = successJson();
        json.put("code",CODE_SUCCESS_NUMBER);
        json.put("data",data);
        return  json;
    }
    public static JSONObject successJson(JSONObject jsonObject){
        JSONObject json = successJson();
        json.put("code",CODE_SUCCESS_JSON);
        json.put("data",jsonObject);
        return  json;
    }
    public static JSONObject exceptionJson(Exception e){
        JSONObject json = new JSONObject();
        json.put("code",CODE_EXCEPTION);
        json.put("description",e.getClass().getSimpleName());
        json.put("date",e.getMessage());
        return  json;
    }
    //---------------private----------------
    private static JSONObject successJson(){
        JSONObject json = new JSONObject();
        json.put("description","ok");
        return  json;
    }

    //--------------------------------------------------------------------------------------------------
    ////////////////////////error////////////////////////////
    public static JSONObject errorJson(String data){
        JSONObject json = new JSONObject();
        json.put("code",CODE_ERROR);
        json.put("description","error");
        json.put("data",data);
        return  json;
    }
    public static JSONObject permissionDeniedJson(){
        JSONObject json = new JSONObject();
        json.put("code",CODE_PERMISSION_DENIED);
        json.put("description","permission denied");
        json.put("data","permission denied");
        return  json;
    }
}
