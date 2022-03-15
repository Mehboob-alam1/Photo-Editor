package com.mehboob.myapplication;

public class ViewPagerModel {
    int image;
    String desc;

    public ViewPagerModel(int image, String desc) {
        this.image = image;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
