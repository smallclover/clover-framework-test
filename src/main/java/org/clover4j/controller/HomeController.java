package org.clover4j.controller;

import org.clover4j.framework.annoation.Action;
import org.clover4j.framework.annoation.Controller;
import org.clover4j.framework.bean.Param;
import org.clover4j.framework.bean.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 主页
 * @author smallclover
 * @create 2017-01-10
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Action(value = "get:/home")
    public View home(){
        logger.debug("home");
        return new View("home.jsp").addModel("welcome", "HelloWorld");
    }
}
