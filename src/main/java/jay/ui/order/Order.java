package jay.ui.order;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private int id;
	private String prodName;
	private String prodPicUrl;
	private int prodQty;
	private double prodPrice;
	private String ordType;
	private int custId;
	private int addId;

	public int getId() {
		return id;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPicUrl() {
		return prodPicUrl;
	}

	public void setProdPicUrl(String prodPicUrl) {
		this.prodPicUrl = prodPicUrl;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", prodName=" + prodName + ", prodPicUrl=" + prodPicUrl + ", prodQty=" + prodQty
				+ ", prodPrice=" + prodPrice + ", ordType=" + ordType + ", custId=" + custId + ", addId=" + addId + "]";
	}

}
