package controller.editimportproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import model.ImportProductAccessObject;
import model.entity.ImportProduct;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         productNameTxt.setText(controller.importproduct.Controller.importProductSelected.getProductName());
         categoryTxt.setText(controller.importproduct.Controller.importProductSelected.getCategory());
         quantityTxt.setText(controller.importproduct.Controller.importProductSelected.getQuantity().toString());
         unitPriceTxt.setText(controller.importproduct.Controller.importProductSelected.getUnitPrice().toString());
         staffTxt.setText(controller.importproduct.Controller.importProductSelected.getStaff());
         phoneNumberTxt.setText(controller.importproduct.Controller.importProductSelected.getPhoneNumber());
         dateTxt.setText(controller.importproduct.Controller.importProductSelected.getDate().toString());
    }

    public void confirmEditImportProduct() throws Exception {
        Integer id = controller.importproduct.Controller.importProductSelected.getId();
        String nameProduct = productNameTxt.getText();
        String category = categoryTxt.getText();
        Integer quantity = Integer.parseInt(quantityTxt.getText());
        Integer unitPrice = Integer.parseInt(unitPriceTxt.getText());
        String staff = staffTxt.getText();
        String phoneNumber = phoneNumberTxt.getText();
        Date dateNow = java.sql.Date.valueOf(dateTxt.getText());

        ImportProduct iprod = new ImportProduct(id, nameProduct, category, quantity, unitPrice, staff, phoneNumber, dateNow);
        ImportProductAccessObject ipao = new ImportProductAccessObject();
        if(ipao.setProduct(iprod)){
            System.out.println("Edit import product success");
        }else{
            System.out.println("Edit import product failed");
        }
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void backToBefore() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
}
