package bookpeon.cutprice.com.model.getmenu;

public class SubCategory {
    private String sub_cat_id = "";
    private String sub_cat_name = "";
    private String en_sub_cat_name = "";
    private String categories_id = "";
    private String subCat_active = "";

    public SubCategory() {
    }

    public SubCategory(String sub_cat_id, String sub_cat_name, String en_sub_cat_name, String categories_id, String subCat_active) {
        this.sub_cat_id = sub_cat_id;
        this.sub_cat_name = sub_cat_name;
        this.en_sub_cat_name = en_sub_cat_name;
        this.categories_id = categories_id;
        this.subCat_active = subCat_active;
    }

    public String getSub_cat_id() {
        return sub_cat_id;
    }

    public void setSub_cat_id(String sub_cat_id) {
        this.sub_cat_id = sub_cat_id;
    }

    public String getSub_cat_name() {
        return sub_cat_name;
    }

    public void setSub_cat_name(String sub_cat_name) {
        this.sub_cat_name = sub_cat_name;
    }

    public String getEn_sub_cat_name() {
        return en_sub_cat_name;
    }

    public void setEn_sub_cat_name(String en_sub_cat_name) {
        this.en_sub_cat_name = en_sub_cat_name;
    }

    public String getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(String categories_id) {
        this.categories_id = categories_id;
    }

    public String getSubCat_active() {
        return subCat_active;
    }

    public void setSubCat_active(String subCat_active) {
        this.subCat_active = subCat_active;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "sub_cat_id='" + sub_cat_id + '\'' +
                ", sub_cat_name='" + sub_cat_name + '\'' +
                ", en_sub_cat_name='" + en_sub_cat_name + '\'' +
                ", categories_id='" + categories_id + '\'' +
                ", subCat_active='" + subCat_active + '\'' +
                '}';
    }
}
