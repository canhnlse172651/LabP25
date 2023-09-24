package DatalayerProductDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ApplicationUI.uitilities.Validation;
import BussinessLayer.Entity.Product;

public class ReportDao implements IReportDao {
	private IProductDao iProductDao = ProductDao.getProductDao();
	private IWarehouseDao iWarehouseDao = WarehouseDao.getWarehouseDao();

	public ReportDao() {

	}

	@Override
	public List<Product> showProductExpired(List<Product> list) {
		// TODO Auto-generated method stub
		// getTimesystem;
		List<Product> newList = new ArrayList<>();
		for (Product product : list) {
			if (Validation.checkDay(product.getManufacturingDate(), product.getExpirationDate()) == 1) {
				newList.add(product);
			}
		}

		return newList;
	}

	@Override
	public List<Product> showProductSelling(List<Product> list) { // tại sao hàm này lại trả về những product có ngày
																	// sản xuất lớn hơn ngày hết hạn
																	// kết quả y chang hàm showProductExpired ở trên ??
		List<Product> newList = new ArrayList<>();

		for (Product product : list) {
			if (Validation.checkDay(product.getManufacturingDate(), product.getExpirationDate()) == 0
					&& product.getQuanity() > 0) {
				newList.add(product);
			}
		}

		return newList;
	}

	@Override
	public List<Product> productStock(List<Product> list) {

		List<Product> newList = new ArrayList<Product>();

		for (Product product : list) {
			if (product.getQuanity() < 3) {
				newList.add(product);
			}
		}

		Collections.sort(newList, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getQuanity() - o2.getQuanity();
			}

		});

		return newList;

	}

	@Override
	public Product showReceiptProduct(String code) {
		Product product = iProductDao.getProduct(code); // hàm này chỉ trả về 1 product trong receipt khi nhập code phải
														// k ?
														// k rõ yêu cầu đề ??

		return iWarehouseDao.getProductInWarehouse(product);
	}

}
