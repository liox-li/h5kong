package com.kong.entity;
public class CookbookPic  implements java.io.Serializable{
/***/
	private  java.lang.Long id;
 
/**菜单标题图片*/
	private  java.lang.String picUrl;
 
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
	 * 菜单标题图片
	 * @return 菜单标题图片
	 */
	public java.lang.String getPicUrl() {
		return picUrl;
	}

	/**
	 * 菜单标题图片
   * @param picUrl
	  *     菜单标题图片
	 */
	public void setPicUrl(java.lang.String picUrl) {
		this.picUrl = picUrl;
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
