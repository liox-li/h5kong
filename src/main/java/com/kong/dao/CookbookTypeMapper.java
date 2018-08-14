package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.CookbookType;
/**CookbookTypeMapper*/
@Mapper
public interface CookbookTypeMapper{
	int listCount(CookbookType cookbookType);

	List<CookbookType> selectByEntity(CookbookType cookbookType);

	CookbookType view(java.lang.Long id);

	int create(CookbookType cookbookType);

	int updateById(CookbookType cookbookType);

	int deleteById(CookbookType cookbookType);

	int delete(CookbookType cookbookType);
}
