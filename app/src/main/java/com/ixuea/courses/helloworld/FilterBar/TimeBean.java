package com.ixuea.courses.helloworld.FilterBar;

public class TimeBean implements BaseFilter{
    /**
     * 时间str
     */
    private String timeStr;
    /**
     * 时间事件
     */
    private String timeEvent;

    TimeBean(String timeStr, String timeEvent) {
        this.timeStr = timeStr;
        this.timeEvent = timeEvent;
    }

    String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(String timeEvent) {
        this.timeEvent = timeEvent;
    }

    @Override
    public String getFilterStr() {
        return timeStr;
    }
}