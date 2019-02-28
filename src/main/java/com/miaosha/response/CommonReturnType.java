package com.miaosha.response;

public class CommonReturnType {

    //返回对应的处理结果（success/fail）
    public String status;

    //success:data内返回正确相应的数据
    //fail:data内使用通用的错误码格式内容
    public Object data;

    //Controller返回结果调用此方法，若只有结果则默认返回状态success
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
