package com.kong.entity;
public class CookbookMark  implements java.io.Serializable{
/**菜单*/
	private  java.lang.Long cookbookId;
 
/**用户*/
	private  java.lang.Long userId;
 
/**收藏时间*/
	private  java.util.Date createDate;
 



	/**
	 * 菜单
	 * @return 菜单
	 */
	public java.lang.Long getCookbookId() {
		return cookbookId;
	}

	/**
	 * 菜单
   * @param cookbookId
	  *     菜单
	 */
	public void setCookbookId(java.lang.Long cookbookId) {
		this.cookbookId = cookbookId;
	}



	/**
	 * 用户
	 * @return 用户
	 */
	public java.lang.Long getUserId() {
		return userId;
	}

	/**
	 * 用户
   * @param userId
	  *     用户
	 */
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}



	/**
	 * 收藏时间
	 * @return 收藏时间
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * 收藏时间
   * @param createDate
	  *     收藏时间
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	}
