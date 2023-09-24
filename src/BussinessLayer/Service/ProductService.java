package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.Product;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;
import FileManager.FileManager;
import FileManager.IFileManager;

public class ProductService implements IProductService {

	private IProductDao productDao = ProductDao.getProductDao();
	
	private IWarehouseDao iWarehouseDao = WarehouseDao.getWarehouseDao();
	
	private IFileManager iFileManager = new FileManager();
	
	

	public ProductService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product) {

		try {
			productDao.newAdd(product);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printList() {

		List<Product> listData = productDao.getList();
		for (Product product : listData) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void deleteProduct(String code) {
		// TODO Auto-generated method stub
//		if (productDao.deleteProduct(code)) {
//			System.out.println("delete sucsessfull ");
//		} else {
//			System.out.println("delete failed ");
//		}
		Product product = productDao.getProduct(code);
		if(iWarehouseDao.getProductInWarehouse(product)==null) {
			productDao.deleteProduct(code);
			System.out.println("Delete sucsess");
		}else {
			System.out.println("This product can not delete because it was exit on receipt ");
		}

	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
		return false;

	}

	@Override
	public Product getProduct(String code) {
		// TODO Auto-generated method stub
		return productDao.getProduct(code);
	}

	@Override
	public void loadDataFromFile(boolean option) {
		iFileManager.loadFile(productDao.getList(), option);

	}

}
