package DatalayerProductDao;

import java.util.List;

import BussinessLayer.Entity.Product;

public interface IReportDao {
	List<Product> showProductExpired(List<Product> list);

	List<Product> showProductSelling(List<Product> list);

	List<Product> productStock(List<Product> list);
	
	Product  showReceiptProduct(String code);
	
	

}
