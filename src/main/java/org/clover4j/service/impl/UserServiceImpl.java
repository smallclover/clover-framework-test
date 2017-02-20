package org.clover4j.service.impl;

import org.clover4j.bean.User;
import org.clover4j.framework.annoation.Service;
import org.clover4j.framework.annoation.Transaction;
import org.clover4j.framework.helper.DatabaseHelper;
import org.clover4j.service.UserService;

import java.util.Map;

/**
 * @author smallclover
 * @create 2017-02-15
 * @since 2.1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public boolean register(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(User.class, fieldMap);
    }
}
