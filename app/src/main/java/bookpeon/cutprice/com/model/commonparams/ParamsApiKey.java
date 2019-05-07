package bookpeon.cutprice.com.model.commonparams;

public class ParamsApiKey {
    private String api_key = "";

    public ParamsApiKey(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    @Override
    public String toString() {
        return "ParamsApiKey{" +
                "api_key='" + api_key + '\'' +
                '}';
    }
}
