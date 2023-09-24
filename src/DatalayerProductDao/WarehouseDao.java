package DatalayerProductDao;

import java.util.ArrayList;
import java.util.List;

import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;

//import BussinessLayer.Entity.ProductReceipt;

public class WarehouseDao implements IWarehouseDao {

	public static List<Warehouse> importList;
	public static List<Warehouse> exportList;

	private static final IWarehouseDao warehouseDao = new WarehouseDao();

	public static IWarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public WarehouseDao() {
		importList = new ArrayList<Warehouse>();
		exportList = new ArrayList<Warehouse>();
	}

	@Override
	public void addExportReceipt(Warehouse newReceipt) {
		// TODO Auto-generated method stub
		exportList.add(newReceipt);

	}

	@Override
	public void addImportReceipt(Warehouse newReceipt) {
		// TODO Auto-generated method stub
		importList.add(newReceipt);

	}

	@Override
	public Product getProductInWarehouse(Product p) {
		List<Warehouse> allReceipt = new ArrayList<Warehouse>(importList);
		allReceipt.addAll(exportList);

		for (Warehouse receipt : allReceipt) {
			List<Product> list = receipt.getProductList();
			for (Product p1 : list) {
				if (p1.equals(p)) {
					return p;
				}
			}
		}
		return null;
	}
	
	

	@Override
	public List<Warehouse> getListWarehouses() {
		List<Warehouse> allReceipt = new ArrayList<Warehouse>(importList);
		allReceipt.addAll(exportList);
		return allReceipt;
	}

}
