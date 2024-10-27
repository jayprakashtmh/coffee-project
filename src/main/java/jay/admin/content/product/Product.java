package jay.admin.content.product;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
	private int id;
	private String name;
	private String pic_url;
	private int qty;
	private double price;
	private int rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getAvl() {
		return avl;
	}

	public void setAvl(int avl) {
		this.avl = avl;
	}

}
