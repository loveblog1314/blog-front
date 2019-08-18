package com.itsure.front.web;

import com.alibaba.fastjson.JSON;
import com.itsure.front.dto.FrontMenuInfo;
import com.itsure.front.dto.ResultInfo;
import com.itsure.front.entity.Article;
import com.itsure.front.service.IArticleService;
import com.itsure.front.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController implements ErrorController {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private IArticleService iArticleService;

    @RequestMapping("/")
    public String getIndex(ModelMap modelMap){
        List<FrontMenuInfo> menus = menuService.getMenus(34);
        modelMap.addAttribute("menus", menus);
        ResultInfo<List<Article>> articlesResult = iArticleService.getArticleByTimeDesc(1,0,10);
        if (articlesResult.getCode().equals("0")) {
            modelMap.addAttribute("articles", articlesResult.getData());
        } else {
            modelMap.addAttribute("error", articlesResult);
        }
        return "index";
    }

    @RequestMapping("/getArticle")
    public String getArticle(ModelMap modelMap,@RequestParam("id") int id){
        ResultInfo<List<Article>> articlesResult = iArticleService.getArticleByTimeDesc(id,0,10);
        if (articlesResult.getCode().equals("0")) {
            modelMap.addAttribute("articles", articlesResult.getData());
        } else {
            modelMap.addAttribute("error", articlesResult);
        }
        return "index::articlesdiv";
    }

    @RequestMapping("/error")
    public String getError(ModelMap modelMap){
        List<FrontMenuInfo> menus = menuService.getMenus(34);
        modelMap.addAttribute("menus", menus);
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "redirct:/error";
    }

    @RequestMapping("/list")
    public String getList(ModelMap modelMap, @RequestParam("id") int menuId, @RequestParam("pageId") int pageId){
        List<FrontMenuInfo> menus = menuService.getMenus(34);
        modelMap.addAttribute("menus", menus);
        ResultInfo<List<Article>> articlesResult = iArticleService.getArticleByTimeDesc(menuId, pageId,10);
        if (articlesResult.getCode().equals("0")) {
            modelMap.addAttribute("articles", articlesResult.getData());
        } else {
            modelMap.addAttribute("error", articlesResult);
        }
        return "list";
    }

    @RequestMapping("/getArticleByMenuId")
    public String getArticleListByMenuId(ModelMap modelMap, @RequestParam("id") int menuId, @RequestParam("pageId") int pageId){
        System.out.println(menuId+"menuid");
        ResultInfo<List<Article>> articlesResult = iArticleService.getArticleByTimeDesc(menuId, pageId,10);
        if (articlesResult.getCode().equals("0")) {
            modelMap.addAttribute("articles", articlesResult.getData());
        } else {
            modelMap.addAttribute("error", articlesResult);
        }
        return "list::artCont";
    }

    @RequestMapping("/category")
    public String getCategory(ModelMap modelMap){
        List<FrontMenuInfo> menus = menuService.getMenus(34);
        modelMap.addAttribute("menus", menus);
        return "list";
    }

    @RequestMapping("/show")
    public String getShow(ModelMap modelMap,@RequestParam("id") int id){
        List<FrontMenuInfo> menus = menuService.getMenus(34);
        modelMap.addAttribute("menus", menus);
        ResultInfo<Article> articlesResult = iArticleService.getArticleById(id);
        System.err.println(JSON.toJSONString(articlesResult));
        if (articlesResult.getCode().equals("0")) {
            modelMap.addAttribute("article", articlesResult.getData());
        } else {
            modelMap.addAttribute("error", articlesResult);
        }
        return "show";
    }
}
