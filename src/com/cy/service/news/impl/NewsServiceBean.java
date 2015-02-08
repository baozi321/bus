package com.cy.service.news.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.news.News;
import com.cy.service.base.DAOSupport;
import com.cy.service.news.NewsService;
/**
 * 新闻Service接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class NewsServiceBean extends DAOSupport<News> implements NewsService {

}
