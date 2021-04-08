package controller.addproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.ImportProductAccessObject;
import model.ProductAccessObject;
import model.entity.ImportProduct;
import model.entity.Product;

import java.time.LocalDate;
import java.util.Date;

public class Controller {
    public TextField nameProductTxt;
    public TextField categoryTxt;
    public TextField quantityTxt;
    public TextField unitPriceTxt;
    public TextField staffTxt;
    public TextField phoneNumberTxt;


   public void confirmAddProduct() throws Exception{
       String nameProduct = nameProductTxt.getText();
       String category = categoryTxt.getText();
       Integer quantity = Integer.parseInt(quantityTxt.getText());
       Integer unitPrice = Integer.parseInt(unitPriceTxt.getText());
       String staffName = staffTxt.getText();
       String phoneNumber = phoneNumberTxt.getText();
       LocalDate ld = LocalDate.now();
       Date dateLocal = java.sql.Date.valueOf(ld);

       ImportProduct ip = new ImportProduct(null, nameProduct, category, quantity, unitPrice, staffName, phoneNumber, dateLocal);
       System.out.println("Time: " + dateLocal);
       try {
           ImportProductAccessObject ipao = new ImportProductAccessObject();
           if(ipao.addProduct(ip)){
               System.out.println("Add new product success");
           }else{
               System.out.println("Add new product failed !!!!");
           }
       }catch (Exception e){
           System.out.println("Add new product failed");
       }
       Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
       Main.mainStage.setTitle("Import Products");
       Main.mainStage.setScene(new Scene(root, 750, 500));
       Main.mainStage.show();

   }
   public void backToStock() throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
       Main.mainStage.setTitle("Import Products");
       Main.mainStage.setScene(new Scene(root, 750, 500));
       Main.mainStage.show();
   }


}
