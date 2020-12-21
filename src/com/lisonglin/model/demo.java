package com.lisonglin.model;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/19 12:23
 */
public class demo {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        demo demo = new demo();
        demo.setName("name");
    }
}
