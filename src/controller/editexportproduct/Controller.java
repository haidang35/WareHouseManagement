package controller.editexportproduct;

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
import sun.security.util.math.ImmutableIntegerModuloP;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField productNameTxt;
    public TextField categoryTxt;
    public TextField quantityTxt;
    public TextField unitPriceTxt;
    public TextField staffTxt;
    public TextField phoneNumberTxt;
    public TextField dateTxt;
    public static Integer quantityAfterEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productNameTxt.setText(controller.exportproduct.Controller.exportProductSelected.getProductName());
        categoryTxt.setText(controller.exportproduct.Controller.exportProductSelected.getCategory());
        quantityTxt.setText(controller.exportproduct.Controller.exportProductSelected.getQuantity().toString());
        unitPriceTxt.setText(controller.exportproduct.Controller.exportProductSelected.getUnitPrice().toString());
        staffTxt.setText(controller.exportproduct.Controller.exportProductSelected.getStaff());
        phoneNumberTxt.setText(controller.exportproduct.Controller.exportProductSelected.getPhoneNumber());
        dateTxt.setText(controller.exportproduct.Controller.exportProductSelected.getDate().toString());
    }

    public void backToBefore() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../exportproduct/exportproduct.fxml"));
        Main.mainStage.setTitle("Export Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void confirmEditExportProduct() throws Exception{
        Integer id = controller.exportproduct.Controller.exportProductSelected.getId();
        String nameProduct = productNameTxt.getText();
        String category = categoryTxt.getText();
        Integer quantity = Integer.parseInt(quantityTxt.getText());
        Integer unitPrice = Integer.parseInt(unitPriceTxt.getText());
        String nameStaff = staffTxt.getText();
        String phoneNumber = phoneNumberTxt.getText();
        Date dateNow = java.sql.Date.valueOf(dateTxt.getText());
        if( quantity <= controller.exportproduct.Controller.exportProductSelected.getQuantity() && quantity >=0 ){
            quantityAfterEdit = controller.exportproduct.Controller.exportProductSelected.getQuantity() - quantity ;
            Integer quantityProductAfterEdit = quantityAfterEdit + controller.addexportproduct.Controller.quantityAfterExport;
            Product prod = new Product(null, controller.exportproduct.Controller.exportProductSelected.getProductName(), controller.exportproduct.Controller.exportProductSelected.getCategory(), quantityProductAfterEdit, controller.exportproduct.Controller.exportProductSelected.getUnitPrice());
            ProductAccessObject pao = new ProductAccessObject();
            pao.updateQuantityProduct(prod);
            ExportProduct ep = new ExportProduct(id, nameProduct, category, quantity, unitPrice, nameStaff, phoneNumber, dateNow);
            ExportProductAccessObject epao = new ExportProductAccessObject();
            if(epao.setProduct(ep)){
                System.out.println("Edit export product success");
            }else{
                System.out.println("Edit export product failed");
            }
            Parent root = FXMLLoader.load(getClass().getResource("../exportproduct/exportproduct.fxml"));
            Main.mainStage.setTitle("Export Products");
            Main.mainStage.setScene(new Scene(root, 750, 500));
            Main.mainStage.show();
        }else {
            System.out.println("Edit export product failed");
        }

    }
}
