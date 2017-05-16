package org.clover4j.controller;

import org.clover4j.framework.annoation.Action;
import org.clover4j.framework.annoation.Controller;
import org.clover4j.framework.annoation.Inject;
import org.clover4j.framework.bean.Data;
import org.clover4j.framework.bean.Param;
import org.clover4j.framework.bean.View;
import org.clover4j.framework.helper.ServletHelper;
import org.clover4j.service.UserService;
import org.clover4j.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author smallclover
 * @create 2017-02-15
 * @since 2.1.0
 */
@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Inject //有问题
//    private UserService userService;
    private UserServiceImpl userService;

    /**
     * 跳转到注册用户界面
     * @return
     */
    @Action("get:/addUser")
    public View addUserPage(){
        logger.debug("addUser");
        return new View("user/add.jsp");
    }

    /**
     * 注册用户
     * @param param
     * @return
     */
    @Action("post:/add")
    public View addUser(Param param){
        boolean flag = userService.register(param.getMap());
        return new View("user/success.jsp");
    }

    @Action("get:/userLogin")
    public View userLoginPage(){
        return new View("user/login.jsp");
    }
    @Action("post:/login")
    public View login(Param param){
        boolean flag = userService.login(param.getMap());
        if (flag == true){
            ServletHelper.setSessionAttribute("username", param.getMap().get("username"));
            return new View("user/success.jsp");
        }else {
            return new View("user/fail.jsp");
        }
    }

    @Action("post:/search")
    public Data search(Param param){
        return new Data(userService.search(param.getMap()));
    }
}
