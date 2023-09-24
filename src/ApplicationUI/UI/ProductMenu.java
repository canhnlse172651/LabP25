package ApplicationUI.UI;

import java.util.Scanner;

import ApplicationUI.uitilities.DataInput;
import ApplicationUI.uitilities.Validation;
import BussinessLayer.Entity.Product;
import DatalayerProductDao.IProductDao;
import DatalayerProductDao.ProductDao;
import FileManager.FiliManager;
import FileManager.IFileManager;
import BussinessLayer.Service.*;

public class ProductMenu {

	private IProductService service = new ProductService();

	public void showMenu() {
		int choice = 0;
		try {
			do {
				System.out.println("1. Add product.");
				System.out.println("2. Update product information.");
				System.out.println("3. Delete product.");
				System.out.println("4. Show all product.");
				System.out.println("5. Load Data from file ");
				System.out.println("6. Exit ! back main manu.");
				System.out.println("Enter your choice : ");
				choice = DataInput.getIntegerNumber();

				switch (choice) {

				case 1 -> {
					inputProduct();
				}

				case 2 -> {
					update();
				}

				case 3 -> {
					delete();
				}
				case 4 -> {
					displayAllProduct();

				}

				case 5 -> {
					loadDataFromFile();
				}
				}
			} while (choice != 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void loadDataFromFile() {
		// TODO Auto-generated method stub
		service.loadDataFromFile(true);

	}

	public void inputProduct() {

		String code = DataInput.getString("Enter your code: ");
		String name = DataInput.getString("Enter your name: ");
		System.out.println("Enter manufacturingDate :");
		String manufacturingDate = Validation.validDay();
		System.out.println("Enter expirationDate : ");
		String expirationDate = Validation.validDay();
		int quanity = -1;
		try {
			quanity = DataInput.getIntegerNumber("Enter your quanity: ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Product a = new Product(code, name, manufacturingDate, expirationDate, quanity);
		service.addProduct(a);
	}

	public void displayAllProduct() {
		service.printList();
	}

	public void delete() {
		String a = DataInput.getString("Enter product code for delete");
		service.deleteProduct(a);
	}

	public void update() {
		String a = DataInput.getString("Enter product code for update ");

		Product oldProduct = service.getProduct(a);
		if (oldProduct == null) {
			System.out.println("Product does not exit");
		} else {

			String name = DataInput.getString("Enter your name: ");
			if (name.isBlank()) {
				name = oldProduct.getName();
			}

			System.out.println("Enter new ManufacturingDate : ");
			String manufacturingDate = Validation.validDay();
			if (manufacturingDate.isBlank()) {
				manufacturingDate = oldProduct.getManufacturingDate();
			}
			System.out.println("Enter new expirationDate : ");
			String expirationDate = Validation.validDay();
			if (expirationDate.isBlank()) {
				expirationDate = oldProduct.getExpirationDate();
			}
			int quanity = -1;
			String checkString = DataInput.getString("Enter new product quanity : ");
			try {

				if (checkString.isBlank()) {
					quanity = oldProduct.getQuanity();
				} else {
					quanity = Integer.parseInt(checkString);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Product newProduct = new Product(oldProduct.getCode(), name, manufacturingDate, expirationDate, quanity);
			service.update(newProduct);
		}

	}

}
