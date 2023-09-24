package FileManager;

import java.util.List;

import BussinessLayer.Entity.Product;
import BussinessLayer.Entity.Warehouse;

public interface IFileManager {
        void saveFileProduct(List<Product> list);
        void saveFileWarehouse(List<Warehouse> list);
        void loadFile(List<Product> list,boolean option);
}
