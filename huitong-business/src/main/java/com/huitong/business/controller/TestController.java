package com.huitong.business.controller;

import com.huitong.business.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.core.controller.BaseController;


/**
 * 测试
 * 
 *
 */
@Controller
@RequestMapping("/business/newUiBtn")
public class TestController extends BaseController
{
    private String prefix = "business/newUiBtn";

    @Autowired
    private ITestService service;

    @GetMapping()
    public String newUiBtn()
    {
        return prefix + "/newUiBtn";
    }

}
