package com.kong.entity;
public class User  implements java.io.Serializable{
/***/
	private  java.lang.Long id;
 
/**手机号码*/
	private  java.lang.String phone;
 
/**用户名*/
	private  java.lang.String name;
 
/**密码*/
	private  java.lang.String psw;
 
/**年龄*/
	private  java.lang.Integer age;
 
/**性别*/
	private  java.lang.String gender;
 
/**自我介绍*/
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
	 * 手机号码
	 * @return 手机号码
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * 手机号码
   * @param phone
	  *     手机号码
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * 用户名
	 * @return 用户名
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * 用户名
   * @param name
	  *     用户名
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}



	/**
	 * 密码
	 * @return 密码
	 */
	public java.lang.String getPsw() {
		return psw;
	}

	/**
	 * 密码
   * @param psw
	  *     密码
	 */
	public void setPsw(java.lang.String psw) {
		this.psw = psw;
	}



	/**
	 * 年龄
	 * @return 年龄
	 */
	public java.lang.Integer getAge() {
		return age;
	}

	/**
	 * 年龄
   * @param age
	  *     年龄
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * 性别
	 * @return 性别
	 */
	public java.lang.String getGender() {
		return gender;
	}

	/**
	 * 性别
   * @param gender
	  *     性别
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * 自我介绍
	 * @return 自我介绍
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * 自我介绍
   * @param description
	  *     自我介绍
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
