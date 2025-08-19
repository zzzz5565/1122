package com.huitong.business.service.impl;

import com.huitong.business.mapper.TestMapper;
import com.huitong.business.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 业务层处理
 * 
 * 
 */
@Service
public class TestServiceImpl implements ITestService
{
    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestMapper testMapper;


}
