package ApplicationUI.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ApplicationUI.uitilities.DataInput;
import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;
import BussinessLayer.Service.IWarehouseService;
import BussinessLayer.Service.warehouseService;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;

public class WarehouseMenu {

	static Scanner sc = new Scanner(System.in);
	IProductDao iProductDao = ProductDao.getProductDao();
    IWarehouseService iWarehouseService = new warehouseService();

	public void showMenu() {

		int choice = 0;

		do {

			System.out.println("1. Create an receipt ");
			System.out.println("2. exit");
		
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1 -> {
				createImportReceipt();
			}
			}
		} while (choice != 2);

	}

	

	private void createImportReceipt() {
	
				boolean tmp = false;
				String typeReceipt = null;
				typeReceipt = DataInput.getString("Create Import-Receipt or Export Receipt I/X :");
				if(typeReceipt.equalsIgnoreCase("I")) {
					tmp = true;
				}else {
					tmp = false;
				}
				
				Warehouse warehouse = inputReceipt(tmp);
				iWarehouseService.addReceipt(warehouse);


	}

	public Warehouse inputReceipt(boolean option) {
		String code = "";

		if (option) {
			code += "I";
		} else {
			code += "E";
		}
		int end_Code = WarehouseDao.importList.size() + 1;
		if (end_Code > 999999) {
			System.out.println("warehouse information is full");
		}
		int number_zero = 7 - (end_Code + "").length();
		String med = "";
		for (int i = 1; i < number_zero; i++) {
			med += "0";
		}
		code += (med + end_Code);

		// getTimesystem;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYY");

		LocalDateTime now = LocalDateTime.now();

		String importDate = dtf.format(now);

		// tạo một list product
		List<Product> list = new ArrayList<Product>();

		while (true) {
			String productCode = DataInput.getString("Enter code of product to add on receipt ");
			Product product = iProductDao.getProduct(productCode);

			if (product == null) {
				System.out.println("product does not exit");
			} else if (list.contains(product)) {
				System.out.println("product does exit");
			} else {
				list.add(product);
				System.out.println("Do you want to add more ? Y/N");
				String check = sc.nextLine();
				if (check.equalsIgnoreCase("Y")) {
					continue;
				}
				break;
			}
		}
		Warehouse importWarehouse = new Warehouse(code, med, list);
//		 warehouseDao.createImportReceipt(importWarehouse);
		return importWarehouse;

	}

}
