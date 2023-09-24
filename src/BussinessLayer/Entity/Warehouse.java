package BussinessLayer.Entity;

import java.util.List;

public class Warehouse {
	private String code;
	private String time;
	private List<Product> productList;
	
	public Warehouse(String code, String time, List<Product> productList) {
		super();
		this.code = code;
		this.time = time;
		this.productList = productList;
	}
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	public String toString() {
		
		String result = code+","+time+",";
		
		for(Product p : productList) {
			String pCode = p.getCode();
			result +=(","+pCode);
		}
		
		return result;
	}

}
