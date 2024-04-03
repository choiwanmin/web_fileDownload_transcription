package mem;

public class Mem {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int type;

	Mem() {
	}

	public Mem(String id, String pwd, String name, String email, int type) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Mem [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", type=" + type + "]";
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
