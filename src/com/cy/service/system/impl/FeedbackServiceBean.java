package com.cy.service.system.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.system.Feedback;
import com.cy.service.base.DAOSupport;
import com.cy.service.system.FeedbackService;

/**
 * 反馈接口实现类
 * @author CY
 *
 */
@Service
@Transactional
public class FeedbackServiceBean extends DAOSupport<Feedback> implements FeedbackService {

}
