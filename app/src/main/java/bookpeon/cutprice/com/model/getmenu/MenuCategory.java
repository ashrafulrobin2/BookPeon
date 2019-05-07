package bookpeon.cutprice.com.model.getmenu;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory {
    private String mc_id = "";
    private String mc_name = "";
    private String en_mc_name = "";
    private String mc_active = "";
    private String mc_possition = "";
    private List<SubCategory> sub = new ArrayList<>();

    public MenuCategory() {
    }

    public MenuCategory(String mc_id, String mc_name, String en_mc_name, String mc_active, String mc_possition, List<SubCategory> sub) {
        this.mc_id = mc_id;
        this.mc_name = mc_name;
        this.en_mc_name = en_mc_name;
        this.mc_active = mc_active;
        this.mc_possition = mc_possition;
        this.sub = sub;
    }

    public String getMc_id() {
        return mc_id;
    }

    public void setMc_id(String mc_id) {
        this.mc_id = mc_id;
    }

    public String getMc_name() {
        return mc_name;
    }

    public void setMc_name(String mc_name) {
        this.mc_name = mc_name;
    }

    public String getEn_mc_name() {
        return en_mc_name;
    }

    public void setEn_mc_name(String en_mc_name) {
        this.en_mc_name = en_mc_name;
    }

    public String getMc_active() {
        return mc_active;
    }

    public void setMc_active(String mc_active) {
        this.mc_active = mc_active;
    }

    public String getMc_possition() {
        return mc_possition;
    }

    public void setMc_possition(String mc_possition) {
        this.mc_possition = mc_possition;
    }

    public List<SubCategory> getSub() {
        return sub;
    }

    public void setSub(List<SubCategory> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "mc_id='" + mc_id + '\'' +
                ", mc_name='" + mc_name + '\'' +
                ", en_mc_name='" + en_mc_name + '\'' +
                ", mc_active='" + mc_active + '\'' +
                ", mc_possition='" + mc_possition + '\'' +
                ", sub=" + sub +
                '}';
    }
}
