package controller.importproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.HistoryAccessObject;
import model.ImportProductAccessObject;
import model.ProductAccessObject;
import model.entity.History;
import model.entity.ImportProduct;
import model.entity.Product;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public TableView<ImportProduct> importProductTable;
    public TableColumn<ImportProduct, Integer> idView;
    public TableColumn<ImportProduct, String> productNameView;
    public TableColumn<ImportProduct, String> categoryView;
    public TableColumn<ImportProduct, Integer> quantityView;
    public TableColumn<ImportProduct, Integer> unitPriceView;
    public TableColumn<ImportProduct, String> staffView;
    public TableColumn<ImportProduct, String> phoneNumberView;
    public TableColumn<ImportProduct, String> dateView;
    public static ImportProduct importProductSelected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameView.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitPriceView.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        staffView.setCellValueFactory(new PropertyValueFactory<>("staff"));
        phoneNumberView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));

        try {
            ImportProductAccessObject ipao = new ImportProductAccessObject();
            importProductTable.setItems(ipao.getList());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }
    }
    public void addToStock() throws Exception{
        if(importProductTable.getSelectionModel().getSelectedItems().size() > 0){
            importProductSelected = importProductTable.getSelectionModel().getSelectedItem();
            Parent root= FXMLLoader.load(getClass().getResource("../choosequantityimport/choosequantity.fxml"));
            Main.mainStage.setTitle("Kho hàng");
            Main.mainStage.setScene(new Scene(root,600, 400));
            Main.mainStage.show();

        }
    }
    public void importProduct() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../addproduct/addnewproduct.fxml"));
        Main.mainStage.setTitle("Add new product");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void backToHome() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setTitle("Home");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void editImportProduct() throws Exception{
        if(importProductTable.getSelectionModel().getSelectedItems().size() > 0){
            importProductSelected = importProductTable.getSelectionModel().getSelectedItem();
            Parent root= FXMLLoader.load(getClass().getResource("../editimportproduct/editImportProduct.fxml"));
            Main.mainStage.setTitle("Edit import product");
            Main.mainStage.setScene(new Scene(root,750, 500));
            Main.mainStage.show();
        }
    }
    public void deleteImportProduct() throws Exception{
        if(importProductTable.getSelectionModel().getSelectedItems().size() > 0){
            importProductSelected = importProductTable.getSelectionModel().getSelectedItem();
            ImportProductAccessObject ipao = new ImportProductAccessObject();
            if(ipao.deleteProduct(importProductSelected)){
                System.out.println("Delete import product success");
            }else{
                System.out.println("Delete import product failed");
            }
            Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
            Main.mainStage.setTitle("Import Products");
            Main.mainStage.setScene(new Scene(root, 750, 500));
            Main.mainStage.show();
        }

    }

}
