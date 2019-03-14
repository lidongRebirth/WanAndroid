package com.myfittinglife.app.wanandroid.text;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/29 20:54
 * @Describe
 * @Modify
 */
public class NavigationItem {

    private String name;
    private boolean isSelected=false;
    List<String> articles;          //该分类下的所有子项


    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public NavigationItem(String name, List<String> articles) {
        this.name = name;
        this.articles = articles;
    }

    public NavigationItem(String name) {
        this.name = name;
        this.isSelected = false;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
