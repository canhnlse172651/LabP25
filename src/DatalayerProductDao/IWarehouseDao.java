package DatalayerProductDao;

import java.util.List;

import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;

//import BussinessLayer.Entity.ProductReceipt;

public interface IWarehouseDao {
	void addImportReceipt(Warehouse newReceipt);
	
	void addExportReceipt(Warehouse newReceipt);

	List<Warehouse> getListWarehouses();

	Product getProductInWarehouse(Product p);

}
