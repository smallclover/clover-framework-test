package org.clover4j.service;

import org.clover4j.bean.User;
import org.clover4j.framework.annoation.Inject;

import java.util.Map;

/**
 * @author smallclover
 * @create 2017-02-15
 * @since 2.1.0
 */
public interface UserService {

    boolean register(Map<String, Object> fieldMap);
    boolean login(Map<String, Object> fieldMap);
}
