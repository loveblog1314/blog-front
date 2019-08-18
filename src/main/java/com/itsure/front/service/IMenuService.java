package com.itsure.front.service;

import com.itsure.front.dto.FrontMenuInfo;

import java.util.List;

public interface IMenuService {
    /**
     * 查询菜单
     * @param parentId
     * @return
     */
    List<FrontMenuInfo> getMenus(Integer parentId);
}
