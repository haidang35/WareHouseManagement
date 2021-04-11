package controller.addexportproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import model.ExportProductAccessObject;
import model.ProductAccessObject;
import model.entity.ExportProduct;
import model.entity.Product;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField productNameTxt;
    public TextField quantityTxt;
    public TextField staffTxt;
    public TextField phoneNumberTxt;
    public static Integer quantityAfterExport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productNameTxt.setText(controller.khohang.Controller.productSelected.getName());
        quantityTxt.setText(controller.khohang.Controller.productSelected.getQuantity().toString());
    }

    public void confirmEditExport() throws Exception{
        Integer id = controller.khohang.Controller.productSelected.getId();
        String productName = productNameTxt.getText();
        String category = controller.khohang.Controller.productSelected.getCategory();
        Integer quantity = Integer.parseInt(quantityTxt.getText());
        Integer unitPrice  = controller.khohang.Controller.productSelected.getUnitPrice();
        String staffName = staffTxt.getText();
        String phoneNumber = phoneNumberTxt.getText();
        LocalDate ld = LocalDate.now();
        Date dateNow = java.sql.Date.valueOf(ld);
        ExportProduct ep = new ExportProduct(id, productName, category, quantity, unitPrice, staffName, phoneNumber, dateNow);
        if(quantity <= controller.khohang.Controller.productSelected.getQuantity() && quantity>0){
            quantityAfterExport = controller.khohang.Controller.productSelected.getQuantity() - quantity;
            ExportProductAccessObject epao = new ExportProductAccessObject();
            Product prod = new Product(id, productName, category, quantityAfterExport, unitPrice );
            ProductAccessObject pao = new ProductAccessObject();
            if(epao.addProduct(ep) && pao.setProduct(prod)){
                System.out.println("Add export product success");
            }else{
                System.out.println("Add export product failed");
            }
            Parent root = FXMLLoader.load(getClass().getResource("../exportproduct/exportproduct.fxml"));
            Main.mainStage.setTitle("Export product");
            Main.mainStage.setScene(new Scene(root, 750, 500));
            Main.mainStage.show();
        }else {
            System.out.println("Export product failed");
        }
    }
    public void backToBefore() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setTitle("Home");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
}
