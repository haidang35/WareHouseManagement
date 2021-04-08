package controller.khohang;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ProductAccessObject;
import model.entity.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Product> productsTable;
    public TableColumn<Product, Integer> idView;
    public TableColumn<Product, String> nameView;
    public TableColumn<Product, String> categoryView;
    public TableColumn<Product, Integer> quantityView;
    public TableColumn<Product, Integer> unitPriceView;
    public static Product productSelected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameView.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitPriceView.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        try {
            ProductAccessObject pao= new ProductAccessObject();
            productsTable.setItems(pao.getList());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }

    }
    public void backToHome() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setTitle("Home");
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
    public void onAddProduct() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import product");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void editProduct() throws Exception{
        if(productsTable.getSelectionModel().getSelectedItems().size() > 0){
            productSelected = productsTable.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("../editproduct/editproduct.fxml"));
            Main.mainStage.setTitle("Edit product");
            Main.mainStage.setScene(new Scene(root, 600, 400));
            Main.mainStage.show();
        }
    }
    public void deleteProduct() throws Exception{
        if(productsTable.getSelectionModel().getSelectedItems().size() > 0){
            productSelected = productsTable.getSelectionModel().getSelectedItem();
            ProductAccessObject pao = new ProductAccessObject();
            if(pao.deleteProduct(productSelected)){
                System.out.println("Delete product success");
            }else{
                System.out.println("Delete product failed");
            }
            Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
            Main.mainStage.setTitle("Kho hàng");
            Main.mainStage.setScene(new Scene(root,600, 400));
            Main.mainStage.show();
        }
    }
    public void exportProduct() throws Exception{
        if(productsTable.getSelectionModel().getSelectedItems().size() > 0){
            productSelected = productsTable.getSelectionModel().getSelectedItem();
            Parent root= FXMLLoader.load(getClass().getResource("../addexportproduct/editexportproduct.fxml"));
            Main.mainStage.setTitle("Export product");
            Main.mainStage.setScene(new Scene(root,600, 450));
            Main.mainStage.show();
        }
    }
}
