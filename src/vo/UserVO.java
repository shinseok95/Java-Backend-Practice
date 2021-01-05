package vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String pwd;
	private String name;
	private String birthday;
	private int isLogin;
	
	public UserVO() {
		super();
	}
	
	/** Only Sign In 
	 * 
	 * @param id
	 * @param pwd
	 */
	public UserVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	/** Only Sign Up
	 * 
	 * @param id
	 * @param pwd
	 * @param name
	 * @param birthday
	 * @param isLogin
	 */
	public UserVO(String id, String pwd, String name, String birthday,int isLogin) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.isLogin = isLogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}
	
	public int getIsLogin() {
		return isLogin;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}


}
