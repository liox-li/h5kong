package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.CookbookMark;
/**CookbookMarkMapper*/
@Mapper
public interface CookbookMarkMapper{
	int listCount(CookbookMark cookbookMark);

	List<CookbookMark> selectByEntity(CookbookMark cookbookMark);

	CookbookMark view( );

	int create(CookbookMark cookbookMark);

	int updateById(CookbookMark cookbookMark);

	int deleteById(CookbookMark cookbookMark);

	int delete(CookbookMark cookbookMark);
}
