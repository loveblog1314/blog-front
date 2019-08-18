package com.itsure.front.service.impl;

import com.itsure.front.dto.RequestCodeEnum;
import com.itsure.front.dto.ResultInfo;
import com.itsure.front.entity.Article;
import com.itsure.front.mapper.BlogMapper;
import com.itsure.front.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public ResultInfo<List<Article>> getArticleByTimeDesc(int menuId, int index, int limit) {
        List<Article> result = null;
        try {
           result = blogMapper.getArticleByTimeDesc(menuId,index,limit);
            for (Article article : result) {
                article.split(article.getSkillStack());
            }
        } catch (Exception e) {
            return new ResultInfo<>(RequestCodeEnum.DB_EXCEPTION.getCode(),RequestCodeEnum.DB_EXCEPTION.getMsg());
        }
        return new ResultInfo<>(result);
    }

    @Override
    public ResultInfo<Article> getArticleById(int id) {
        Article result = null;
        try {
            result = blogMapper.getArticleById(id);
        } catch (Exception e) {
            return new ResultInfo<>(RequestCodeEnum.DB_EXCEPTION.getCode(),RequestCodeEnum.DB_EXCEPTION.getMsg());
        }
        return new ResultInfo<>(result);
    }
}
