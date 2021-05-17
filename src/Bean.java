
public class Bean {
	private int id;
	private String name;
	private String password;
	private String sex;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Bean [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + "]";
	}

	public Bean(int id, String name, String password, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
	}

	public Bean() {
		// TODO Auto-generated constructor stub
	}

}
