package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.Cookbook;
/**CookbookMapper*/
@Mapper
public interface CookbookMapper{
	int listCount(Cookbook cookbook);

	List<Cookbook> selectByEntity(Cookbook cookbook);

	Cookbook view(java.lang.Long id);

	int create(Cookbook cookbook);

	int updateById(Cookbook cookbook);

	int deleteById(Cookbook cookbook);

	int delete(Cookbook cookbook);
}
