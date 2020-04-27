package com.ixuea.courses.helloworld.FilterBar;

public class PlaceBean implements BaseFilter {


    /**
     * 时间str
     */
    private String placeStr;


    public String getPlaceStr() {
        return placeStr;
    }
    public void setPlaceStr(String placeStr) {
        this.placeStr = placeStr;
    }
    PlaceBean(String placeStr) {
        this.placeStr = placeStr;
    }

    @Override
    public String getFilterStr() {
        return placeStr;
    }
}
