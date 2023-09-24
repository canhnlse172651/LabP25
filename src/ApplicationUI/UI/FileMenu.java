package ApplicationUI.UI;

import java.util.List;

import ApplicationUI.uitilities.DataInput;
import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;
import FileManager.FileManager;
import FileManager.IFileManager;

public class FileMenu {
	IProductDao iProductDao = ProductDao.getProductDao();
	
	IFileManager iFileManager = FileManager.getFileManager();
	
	IWarehouseDao iWarehouseDao = new WarehouseDao().getWarehouseDao();

	public void showMenu() {

		int choice = 0;
		try {
			do {
				System.out.println("1. Save File Product");
				System.out.println("2. Save File Warehouse");
				System.out.println("3. Exit ! back main manu.");
				System.out.println("Enter your choice : ");
				choice = DataInput.getIntegerNumber();

				switch (choice) {

				case 1 -> {
					saveFileProduct();
				}

				case 2 -> {
					saveProductWarehouse();
				}

				}
			} while (choice != 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void saveProductWarehouse() {
		// TODO Auto-generated method stub
		List<Warehouse> list  = iWarehouseDao.getListWarehouses();
		iFileManager.saveFileWarehouse(list);

	}

	private void saveFileProduct() {
		List<Product> list = iProductDao.getList();
		// TODO Auto-generated method stub
		iFileManager.saveFileProduct(list);

	}
}
