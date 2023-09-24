package BussinessLayer.Service;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ApplicationUI.UI.WarehouseMenu;
import ApplicationUI.uitilities.DataInput;
import ApplicationUI.uitilities.Validation;
import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;

//import BussinessLayer.Entity.ProductReceipt;

public class warehouseService implements IWarehouseService {
	static Scanner scanner = new Scanner(System.in);
	IWarehouseDao warehouseDao = WarehouseDao.getWarehouseDao();

	@Override
	public void addReceipt(Warehouse warehouse) {
		// TODO Auto-generated method stub
		String typeCode = warehouse.getCode().charAt(0)+"";
		
		if(typeCode.equalsIgnoreCase("E")) {
			warehouseDao.addExportReceipt(warehouse);
		}else {
			warehouseDao.addImportReceipt(warehouse);
		}

	}

}
