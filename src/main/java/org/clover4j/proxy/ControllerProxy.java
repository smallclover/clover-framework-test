package org.clover4j.proxy;

import org.clover4j.framework.annoation.Aspect;
import org.clover4j.framework.annoation.Controller;
import org.clover4j.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author smallclover
 * @create 2017-03-14
 * @since 2.1.0
 */
@Aspect(Controller.class)
public class ControllerProxy extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerProxy.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("----debug----");
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis()));
        LOGGER.debug("----end----");
    }
}
