package com.king.togi.ggock.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tacademy on 2017-08-03.
 */

public class TotalModel {
    private String text_1, text_2, text_3;
    int zzimCount;
    Map<String, Boolean> zzim = new HashMap<>();

    public TotalModel(String text_1, String text_2, String text_3) {
        this.text_1 = text_1;
        this.text_2 = text_2;
        this.text_3 = text_3;
    }

    public String getText_1() {
        return text_1;
    }

    public void setText_1(String text_1) {
        this.text_1 = text_1;
    }

    public String getText_2() {
        return text_2;
    }

    public void setText_2(String text_2) {
        this.text_2 = text_2;
    }

    public String getText_3() {
        return text_3;
    }

    public void setText_3(String text_3) {
        this.text_3 = text_3;
    }

    public int getZzimCount() {
        return zzimCount;
    }

    public void setZzimCount(int likeCount) {
        this.zzimCount = likeCount;
    }

    public Map<String, Boolean> getZzim() {
        return zzim;
    }

    public void setZzim(Map<String, Boolean> zzim) {
        this.zzim = zzim;
    }
}
