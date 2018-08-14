package com.kong.entity;
public class Cookbook  implements java.io.Serializable{
/***/
	private  java.lang.Long id;
 
/**发布菜单的用户*/
	private  java.lang.Long userId;
 
/**菜单类型*/
	private  java.lang.Long typeId;
 
/**菜单标题*/
	private  java.lang.String name;
 
/**菜谱 [("1":"面粉","2":"20k")]*/
	private  java.lang.String recipel;
 
/**菜单标题图片*/
	private  java.lang.String pic;
 
/**收藏次数*/
	private  java.lang.Integer markNum;
 
/**关注次数*/
	private  java.lang.Integer followNum;
 
/**购买次数*/
	private  java.lang.Integer buyNum;
 
/**查看次数*/
	private  java.lang.Integer viewNum;
 
/**描述*/
	private  java.lang.String description;
 
/***/
	private  java.util.Date createDate;
 



	/**
	 * 
	 * @return 
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * 
   * @param id
	  *     
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}



	/**
	 * 发布菜单的用户
	 * @return 发布菜单的用户
	 */
	public java.lang.Long getUserId() {
		return userId;
	}

	/**
	 * 发布菜单的用户
   * @param userId
	  *     发布菜单的用户
	 */
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}



	/**
	 * 菜单类型
	 * @return 菜单类型
	 */
	public java.lang.Long getTypeId() {
		return typeId;
	}

	/**
	 * 菜单类型
   * @param typeId
	  *     菜单类型
	 */
	public void setTypeId(java.lang.Long typeId) {
		this.typeId = typeId;
	}



	/**
	 * 菜单标题
	 * @return 菜单标题
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * 菜单标题
   * @param name
	  *     菜单标题
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}



	/**
	 * 菜谱 [("1":"面粉","2":"20k")]
	 * @return 菜谱 [("1":"面粉","2":"20k")]
	 */
	public java.lang.String getRecipel() {
		return recipel;
	}

	/**
	 * 菜谱 [("1":"面粉","2":"20k")]
   * @param recipel
	  *     菜谱 [("1":"面粉","2":"20k")]
	 */
	public void setRecipel(java.lang.String recipel) {
		this.recipel = recipel;
	}



	/**
	 * 菜单标题图片
	 * @return 菜单标题图片
	 */
	public java.lang.String getPic() {
		return pic;
	}

	/**
	 * 菜单标题图片
   * @param pic
	  *     菜单标题图片
	 */
	public void setPic(java.lang.String pic) {
		this.pic = pic;
	}



	/**
	 * 收藏次数
	 * @return 收藏次数
	 */
	public java.lang.Integer getMarkNum() {
		return markNum;
	}

	/**
	 * 收藏次数
   * @param markNum
	  *     收藏次数
	 */
	public void setMarkNum(java.lang.Integer markNum) {
		this.markNum = markNum;
	}



	/**
	 * 关注次数
	 * @return 关注次数
	 */
	public java.lang.Integer getFollowNum() {
		return followNum;
	}

	/**
	 * 关注次数
   * @param followNum
	  *     关注次数
	 */
	public void setFollowNum(java.lang.Integer followNum) {
		this.followNum = followNum;
	}



	/**
	 * 购买次数
	 * @return 购买次数
	 */
	public java.lang.Integer getBuyNum() {
		return buyNum;
	}

	/**
	 * 购买次数
   * @param buyNum
	  *     购买次数
	 */
	public void setBuyNum(java.lang.Integer buyNum) {
		this.buyNum = buyNum;
	}



	/**
	 * 查看次数
	 * @return 查看次数
	 */
	public java.lang.Integer getViewNum() {
		return viewNum;
	}

	/**
	 * 查看次数
   * @param viewNum
	  *     查看次数
	 */
	public void setViewNum(java.lang.Integer viewNum) {
		this.viewNum = viewNum;
	}



	/**
	 * 描述
	 * @return 描述
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * 描述
   * @param description
	  *     描述
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}



	/**
	 * 
	 * @return 
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * 
   * @param createDate
	  *     
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	}
