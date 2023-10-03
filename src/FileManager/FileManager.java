/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.Product;
import business.entity.Receipt;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class FileManager implements IManagerFile {

    private File inputFile;

    public FileManager(String fileName) throws IOException {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            if (!inputFile.createNewFile()) {
                throw new RuntimeException("Can not create product.txt file");
            }
        }
    }

    @Override
    public void writeDataToFile(List<Product> list) throws Exception {
        PrintWriter pw = new PrintWriter(inputFile);
        for (Product e : list) {
            pw.println(e);
        }
        pw.close();
    }

    @Override
    public List<String> readDataFromFile() throws Exception {
        return  Files.readAllLines(inputFile.toPath(), StandardCharsets.UTF_8);
    }
    @Override
    public void writeReceiptToFile(List<Receipt> list) throws Exception{
        try (PrintWriter pw = new PrintWriter(inputFile)) {
            for (Receipt r : list) {
                pw.println(r);
            }
            pw.close();
        }
    }
}
