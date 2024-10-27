package jay.admin.content.about;

import java.io.Serializable;

@SuppressWarnings("serial")
public class About implements Serializable {
	private String name, pic_url, qtext, desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
