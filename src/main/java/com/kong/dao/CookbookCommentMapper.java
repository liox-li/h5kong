package com.kong.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kong.entity.CookbookComment;
/**CookbookCommentMapper*/
@Mapper
public interface CookbookCommentMapper{
	int listCount(CookbookComment cookbookComment);

	List<CookbookComment> selectByEntity(CookbookComment cookbookComment);

	CookbookComment view(java.lang.Long id);

	int create(CookbookComment cookbookComment);

	int updateById(CookbookComment cookbookComment);

	int deleteById(CookbookComment cookbookComment);

	int delete(CookbookComment cookbookComment);
}
