package com.david.admin.mapper;

import com.david.admin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by GW on 2019/7/1.
 */
@Component
@Mapper
public interface UserMapper {

    User getUserByUsername(String username);
}
