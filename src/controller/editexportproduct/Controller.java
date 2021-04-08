package controller.editexportproduct;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField productNameTxt;
    public TextField quantityTxt;
    public TextField staffTxt;
    public TextField phoneNumberTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productNameTxt.setText(controller.khohang.Controller.productSelected.getName());
        quantityTxt.setText(controller.khohang.Controller.productSelected.getQuantity().toString());
    }

    public void confirmEditExport(){
        String productName = productNameTxt.getText();
        Integer quantity = Integer.parseInt(quantityTxt.getText());
        String staffName = staffTxt.getText();
        String phoneNumber = phoneNumberTxt.getText();

        if(quantity <= controller.khohang.Controller.productSelected.getId()){

        }

    }
}
