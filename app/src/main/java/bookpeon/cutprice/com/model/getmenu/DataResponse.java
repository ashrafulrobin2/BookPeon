package bookpeon.cutprice.com.model.getmenu;

public class DataResponse {
    private MenuCategory data ;
    private String success = "";

    public MenuCategory getData() {
        return data;
    }

    public void setData(MenuCategory data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "data=" + data +
                ", success='" + success + '\'' +
                '}';
    }
}
