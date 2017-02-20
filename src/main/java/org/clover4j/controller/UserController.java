package org.clover4j.controller;

import org.clover4j.framework.annoation.Action;
import org.clover4j.framework.annoation.Controller;
import org.clover4j.framework.annoation.Inject;
import org.clover4j.framework.bean.Param;
import org.clover4j.framework.bean.View;
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

    //@Inject //有问题
    private UserService userService = new UserServiceImpl();

    @Action("get:/addUser")
    public View addUserPage(Param param){
        logger.debug("addUser");
        return new View("user/add.jsp");
    }

    @Action("post:/add")
    public View addUser(Param param){
        boolean flag = userService.register(param.getMap());

        return new View("user/success.jsp");
    }
}
