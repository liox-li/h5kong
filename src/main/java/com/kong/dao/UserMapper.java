package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.User;
/**UserMapper*/
@Mapper
public interface UserMapper{
	int listCount(User user);

	List<User> selectByEntity(User user);

	User view(java.lang.Long id);

	int create(User user);

	int updateById(User user);

	int deleteById(User user);

	int delete(User user);
}
