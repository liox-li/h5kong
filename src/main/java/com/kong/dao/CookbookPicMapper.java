package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.CookbookPic;
/**CookbookPicMapper*/
@Mapper
public interface CookbookPicMapper{
	int listCount(CookbookPic cookbookPic);

	List<CookbookPic> selectByEntity(CookbookPic cookbookPic);

	CookbookPic view(java.lang.Long id);

	int create(CookbookPic cookbookPic);

	int updateById(CookbookPic cookbookPic);

	int deleteById(CookbookPic cookbookPic);

	int delete(CookbookPic cookbookPic);
}
