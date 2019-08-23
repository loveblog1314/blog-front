package com.itsure.front.service;

import com.itsure.front.dto.ResultInfo;
import com.itsure.front.entity.Article;
import java.util.List;

public interface IArticleService {
    ResultInfo<List<Article>> getArticleByTimeDesc(int menuId, int index, int limit);

    ResultInfo<Article> getArticleById(int id);

}
