package com.itsure.front.dto;

import java.io.Serializable;
import java.util.List;


public class FrontMenuInfo implements Serializable {

    private Integer id;         // 菜单id

    private String name;        // 菜单名称

    private String url;         // 链接

    private List<FrontMenuInfo> subMenus;   // 子菜单

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<FrontMenuInfo> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<FrontMenuInfo> subMenus) {
        this.subMenus = subMenus;
    }
}
