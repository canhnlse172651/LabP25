package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;
import BussinessLayer.Service.warehouseService;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.IWarehouseDao;
import DatalayerProductDao.ProductDao;
import DatalayerProductDao.WarehouseDao;

public class FileManager implements IFileManager {

	private static final IFileManager MY_FILE_MANAGER = new FileManager();

	IProductDao irDao = new ProductDao().getProductDao();

	IWarehouseDao iWarehouseDao = new WarehouseDao().getWarehouseDao();

	public static IFileManager getFileManager() {
		return MY_FILE_MANAGER;
	}

	@Override
	public void saveFileProduct(List<Product> list) {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("product.txt");
			for (Product product : list) {
				String line = product.getFileLine() + "\n";
				byte b[] = line.getBytes();
				fos.write(b);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void saveFileWarehouse(List<Warehouse> list) {
//		FileOutputStream fos = null;
//		
		List<Warehouse> newList = new ArrayList<Warehouse>();
		List<Product> newList2 = new ArrayList<Product>();
		Warehouse warehouse = new Warehouse("123", "213", newList2);
		newList.add(warehouse);
//
//		try {
//			fos = new FileOutputStream("warehouse.txt");
//			for (Warehouse wareProduct : newList) {
//				String line =  wareProduct.toString();
//				byte b[] = line.getBytes();
//				fos.write(b);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (fos != null) {
//				try {
//					fos.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//		// TODO Auto-generated method stub
		try {
			FileWriter fileWriter = new FileWriter("sa.txt");

	        try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {

	            StringBuilder sBuilder = new StringBuilder();
	            for (Warehouse warehouse1 :newList) {
	                sBuilder.append(warehouse1.toString()).append("\n");
	            }
	            sBuilder.deleteCharAt(sBuilder.length() - 1);

	            bWriter.write(sBuilder.toString());
	        }

		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	@Override
	public void loadFile(List<Product> list, boolean option) {
		FileReader reader = null;
		BufferedReader buff = null;
		String a = null;
		if (option) {
			a = "product.txt";
		} else {
			a = "warehouse.txt";
		}

		try {
			reader = new FileReader(a);
			buff = new BufferedReader(reader);
			String line;

			while ((line = buff.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				Product aProduct = new Product();
				aProduct.pase(line);
				irDao.getList().add(aProduct);

			}
			System.out.println("Load data from File sucsess");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
