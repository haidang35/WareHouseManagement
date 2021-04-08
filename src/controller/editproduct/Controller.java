package controller.editproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import model.ProductAccessObject;
import model.entity.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField productNameTxt;
    public TextField categoryTxt;
    public TextField quantityTxt;
    public TextField unitPriceTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productNameTxt.setText(controller.khohang.Controller.productSelected.getName());
        categoryTxt.setText(controller.khohang.Controller.productSelected.getCategory());
        quantityTxt.setText(controller.khohang.Controller.productSelected.getQuantity().toString());
        unitPriceTxt.setText(controller.khohang.Controller.productSelected.getUnitPrice().toString());
    }

    public void confirmEditProduct() throws Exception{
        Integer id = controller.khohang.Controller.productSelected.getId();
        String nameProduct = productNameTxt.getText();
        String category = categoryTxt.getText();
        Integer quantity = Integer.parseInt(quantityTxt.getText());
        Integer unitPrice = Integer.parseInt(unitPriceTxt.getText());
        Product prodEdit = new Product(id, nameProduct, category, quantity, unitPrice);
        ProductAccessObject pao = new ProductAccessObject();
        if(pao.setProduct(prodEdit)){
            Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
            Main.mainStage.setTitle("Kho hàng");
            Main.mainStage.setScene(new Scene(root,600, 400));
            Main.mainStage.show();
            System.out.println("Edit product success");
        }else{
            System.out.println("Edit product failed");
        }
    }

    public void backToStock() throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
        Main.mainStage.setTitle("Kho hàng");
        Main.mainStage.setScene(new Scene(root,600, 400));
        Main.mainStage.show();
    }

}
