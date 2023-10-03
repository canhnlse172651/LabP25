/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import business.entity.Product;
import business.entity.Receipt;

import java.util.List;

/**
 *
 * @author lyhai
 */
public interface IManagerFile {
    List<String> readDataFromFile() throws Exception;

    void writeDataToFile(List<Product> list) throws Exception;
    void writeReceiptToFile(List<Receipt> list) throws Exception;
}
