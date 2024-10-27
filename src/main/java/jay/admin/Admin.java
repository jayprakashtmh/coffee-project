package jay.admin;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable {
	private String uName;
	private String pword;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

}
