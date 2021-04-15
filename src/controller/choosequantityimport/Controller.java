package controller.choosequantityimport;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import model.ImportProductAccessObject;
import model.ProductAccessObject;
import model.entity.ImportProduct;
import model.entity.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField quantityProductTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        quantityProductTxt.setText(controller.importproduct.Controller.importProductSelected.getQuantity().toString());
    }

    public void backToBefore() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public boolean checkUniqueProduct(Product product) throws Exception{
        Integer quantityProduct = Integer.parseInt(quantityProductTxt.getText());
        ProductAccessObject pao = new ProductAccessObject();
        if(pao.updateQuantityProduct(product)){
            ImportProductAccessObject ipao = new ImportProductAccessObject();
            if(quantityProduct < controller.importproduct.Controller.importProductSelected.getQuantity()){
                Integer id = controller.importproduct.Controller.importProductSelected.getId();
                Integer quantityAfterChooseImport = controller.importproduct.Controller.importProductSelected.getQuantity() - quantityProduct;
                ImportProduct iprod = new ImportProduct(id,controller.importproduct.Controller.importProductSelected.getProductName(), controller.importproduct.Controller.importProductSelected.getCategory(),
                        quantityAfterChooseImport, controller.importproduct.Controller.importProductSelected.getUnitPrice(), controller.importproduct.Controller.importProductSelected.getStaff(),
                        controller.importproduct.Controller.importProductSelected.getPhoneNumber(), controller.importproduct.Controller.importProductSelected.getDate());
                ipao.updateQuantityProduct(iprod);
            }
            else if(quantityProduct == controller.importproduct.Controller.importProductSelected.getQuantity()){
                ipao.deleteProduct(controller.importproduct.Controller.importProductSelected);
            }
            System.out.println("Add existed product to stock success");
            Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
            Main.mainStage.setTitle("Kho hàng");
            Main.mainStage.setScene(new Scene(root,600, 400));
            Main.mainStage.show();
            return true;
        }else{
            return false;
        }

    }
    public void confirmImportProduct() throws Exception{
        Integer quantityProduct = Integer.parseInt(quantityProductTxt.getText());
        if(quantityProduct <= controller.importproduct.Controller.importProductSelected.getQuantity() && quantityProduct > 0){
            Product productSelected = new Product(null, controller.importproduct.Controller.importProductSelected.getProductName(), controller.importproduct.Controller.importProductSelected.getCategory(), quantityProduct, controller.importproduct.Controller.importProductSelected.getUnitPrice());
////            Integer quantitySelectedExisted = quantityProduct +
//            Product productSelectedExisted = new Product(null,controller.importproduct.Controller.importProductSelected.getProductName(), controller.importproduct.Controller.importProductSelected.getCategory(), quantityProduct, controller.importproduct.Controller.importProductSelected.getUnitPrice() );
            ProductAccessObject pao = new ProductAccessObject();
//            if(checkUniqueProduct(productSelected)){
//                System.out.println("Import quantity existed product success");
//            }else
                if(pao.addProduct(productSelected)){
                ImportProductAccessObject ipao = new ImportProductAccessObject();
                if(quantityProduct < controller.importproduct.Controller.importProductSelected.getQuantity()){
                    Integer id = controller.importproduct.Controller.importProductSelected.getId();
                    Integer quantityAfterChooseImport = controller.importproduct.Controller.importProductSelected.getQuantity() - quantityProduct;
                    ImportProduct iprod = new ImportProduct(id,controller.importproduct.Controller.importProductSelected.getProductName(), controller.importproduct.Controller.importProductSelected.getCategory(),
                            quantityAfterChooseImport, controller.importproduct.Controller.importProductSelected.getUnitPrice(), controller.importproduct.Controller.importProductSelected.getStaff(),
                            controller.importproduct.Controller.importProductSelected.getPhoneNumber(), controller.importproduct.Controller.importProductSelected.getDate());
                    ipao.updateQuantityProduct(iprod);
                }
                else if(quantityProduct == controller.importproduct.Controller.importProductSelected.getQuantity()){
                    ipao.deleteProduct(controller.importproduct.Controller.importProductSelected);
                }

                System.out.println("Add product to stock success");
                Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
                Main.mainStage.setTitle("Kho hàng");
                Main.mainStage.setScene(new Scene(root,750, 500));
                Main.mainStage.show();
            }else{
                System.out.println("Add product to stock failed");
            }
        }



    }

}
