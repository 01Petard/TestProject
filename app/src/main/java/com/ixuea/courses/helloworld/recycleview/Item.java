package com.ixuea.courses.helloworld.recycleview;

public class Item {
    private String name;
    private int ImageId;
    public String getName() {
        return name;
    }

    public int getImageId() {
        return ImageId;
    }
    public Item(String name,int ImageId){
        this.name = name;
        this.ImageId = ImageId;
    }
}
