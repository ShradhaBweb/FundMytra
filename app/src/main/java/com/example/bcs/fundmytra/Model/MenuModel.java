package com.example.bcs.fundmytra.Model;

import android.widget.ImageView;

public class MenuModel {

    public String menuName, url;
    public boolean hasChildren, isGroup;
    ImageView img_expandable ;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren) {

        this.menuName = menuName;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}