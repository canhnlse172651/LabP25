package BussinessLayer.Service;

import java.util.List;

import BussinessLayer.Entity.Product;
import DatalayerProductDao.IReportDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.ReportDao;

public class ReportService implements IReportService {
	IReportDao iReportDao = new ReportDao();

	public ReportService() {

	}

	@Override
	public void showProductExpired(List<Product> list) {
		// TODO Auto-generated method stub
		List<Product> newList = iReportDao.showProductExpired(list);

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void showProductSelling(List<Product> list) {
		List<Product> newList = iReportDao.showProductSelling(list);

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void ProductStock(List<Product> list) {
//             
		List<Product> newList = iReportDao.showProductSelling(list);

		for (Product product : newList) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void showReceiptProduct(String code) {
		Product product = iReportDao.showReceiptProduct(code);
		if(product == null) {
			System.out.println("This product does not exit on receipt");
		}else {
			System.out.println(product);
		}
	}

}
