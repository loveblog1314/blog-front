package com.itsure.front.service.impl;

import com.itsure.front.dto.FrontMenuInfo;
import com.itsure.front.entity.Menu;
import com.itsure.front.entity.Permission;
import com.itsure.front.mapper.BlogMapper;
import com.itsure.front.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public List<FrontMenuInfo> getMenus(Integer parentId) {
        List<FrontMenuInfo> res = new ArrayList<>();
        FrontMenuInfo index = new FrontMenuInfo();
        index.setName("首页");
        index.setId(0);
        index.setUrl("/");
        index.setSubMenus(new ArrayList<FrontMenuInfo>());
        res.add(index);
        List<Permission> permissions = blogMapper.getFrontMenu(parentId);
        for (Permission permission : permissions) {
            FrontMenuInfo frontMenu = new FrontMenuInfo();
            frontMenu.setId(permission.getId());
            frontMenu.setName(permission.getPermissionName());
            frontMenu.setUrl("/category?id="+ frontMenu.getId());
            List<Menu> subMenus = blogMapper.getMenus(permission.getId());
            List<FrontMenuInfo> subFrontMenus = new ArrayList<>();
            for (Menu subMenu : subMenus) {
                FrontMenuInfo subFrontMenu = new FrontMenuInfo();
                subFrontMenu.setId(subMenu.getId());
                subFrontMenu.setName(subMenu.getName());
                subFrontMenu.setUrl("/list?id="+subFrontMenu.getId()+"&pageId=0");
                subFrontMenus.add(subFrontMenu);
            }
            frontMenu.setSubMenus(subFrontMenus);
            res.add(frontMenu);
        }
        return res;
    }
}
