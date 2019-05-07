package bookpeon.cutprice.com.retrofit;

import com.google.gson.Gson;

/**
 * @author Md. Rashadul Alam
 * Email: rashed.droid@gmail.com
 */
public class APIResponse<F> {

    private String success = "";
    private String msg = "";
    private int total_count= 0;
    private F response;

    public static <T> T getResponseObject(String jsonString, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> String getResponseString(T object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public F getResponse() {
        return response;
    }

    public void setResponse(F response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "success='" + success + '\'' +
                ", msg='" + msg + '\'' +
                ", total_count=" + total_count +
                ", response=" + response +
                '}';
    }
}
