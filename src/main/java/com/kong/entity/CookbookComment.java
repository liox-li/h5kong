package com.kong.entity;
public class CookbookComment  implements java.io.Serializable{
/***/
	private  java.lang.Long id;
 
/**用户id*/
	private  java.lang.Long userId;
 
/**评论*/
	private  java.lang.String comment;
 
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
	 * 用户id
	 * @return 用户id
	 */
	public java.lang.Long getUserId() {
		return userId;
	}

	/**
	 * 用户id
   * @param userId
	  *     用户id
	 */
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}



	/**
	 * 评论
	 * @return 评论
	 */
	public java.lang.String getComment() {
		return comment;
	}

	/**
	 * 评论
   * @param comment
	  *     评论
	 */
	public void setComment(java.lang.String comment) {
		this.comment = comment;
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
