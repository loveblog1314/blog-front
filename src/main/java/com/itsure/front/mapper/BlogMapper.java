package com.itsure.front.mapper;

import com.itsure.front.entity.Article;
import com.itsure.front.entity.Menu;
import com.itsure.front.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {

    @Select("select * from sys_menu where parent_id = #{parentId}")
    List<Menu> getMenus(Integer parentId);

    @Select("select * from sys_permission where parent_id = #{parentId}")
    List<Permission> getFrontMenu(Integer parentId);

    @Select("select * from sys_article where menu_id = #{menuId} order by update_time desc limit #{index},#{limit}")
    List<Article> getArticleByTimeDesc(@Param("menuId") int menuId,@Param("index") int index, @Param("limit") int limit);

    @Select("select * from sys_article where id = #{id}")
    Article getArticleById(int id);

    @Select("select count(id) from sys_article where menu_id = #{id}")
    Integer getArticleCountsById(int id);
}
