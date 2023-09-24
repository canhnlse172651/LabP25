package DatalayerProductDao;

import java.util.ArrayList;
import java.util.List;

import BussinessLayer.Entity.Product;

public class ProductDao implements IProductDao { // tại sao k cần cunstructor rỗng ?

	public final List<Product> productList = new ArrayList<Product>();
	
	private static final IProductDao productDao = new ProductDao();

	public static IProductDao getProductDao() {
		return productDao;
	}

	@Override
	public void newAdd(Product product) throws Exception {
		for (Product pd : productList) {
			if (pd.getCode().equalsIgnoreCase(product.getCode())) {
				throw new IllegalArgumentException("Product code is duplicated");
			}
		}

		productList.add(product);

	}

	@Override
	public List<Product> getList() {
		return productList;
	}

	@Override
	public boolean deleteProduct(String code) {
		// TODO Auto-generated method stub
		int tmp = 0;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getCode().equals(code)) {
				return productList.remove(i) != null;

			}

		}
		return false;

	}

	public Product getProduct(String code) {
		for (Product product : productList) {
			if (product.getCode().equals(code)) {
				return product;
			}

		}
		return null;
	}

	@Override
	public boolean update(Product product) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getCode().equals(product.getCode())) {
				return productList.set(i, product) != null;
			}
		}
		return false;
	}

}
