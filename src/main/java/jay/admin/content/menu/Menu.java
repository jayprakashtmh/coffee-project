package jay.admin.content.menu;

import jakarta.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class Menu extends HttpServlet {
	private int id;
	private String name;
	private String pic_url;
	private int qty;
	private double price;
	private int avl;

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

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvl() {
		return avl;
	}

	public void setAvl(int avl) {
		this.avl = avl;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", pic_url=" + pic_url + ", qty=" + qty + ", price=" + price
				+ ", avl=" + avl + "]";
	}

}
