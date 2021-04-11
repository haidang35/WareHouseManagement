package controller.exportproduct;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ExportProductAccessObject;
import model.ProductAccessObject;
import model.entity.ExportProduct;
import model.entity.Product;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<ExportProduct> exportProductTable;
    public TableColumn<ExportProduct, Integer> idView;
    public TableColumn<ExportProduct, String> productNameView;
    public TableColumn<ExportProduct, String> categoryView;
    public TableColumn<ExportProduct, Integer> quantityView;
    public TableColumn<ExportProduct, Integer> unitPriceView;
    public TableColumn<ExportProduct, String> staffView;
    public TableColumn<ExportProduct, String > phoneNumberView;
    public TableColumn<ExportProduct, Date> dateView;
    public static ExportProduct exportProductSelected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameView.setCellValueFactory(new PropertyValueFactory <>("productName"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitPriceView.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        staffView.setCellValueFactory(new PropertyValueFactory<>("staff"));
        phoneNumberView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));
        try {
            ExportProductAccessObject epao = new ExportProductAccessObject();
            exportProductTable.setItems(epao.getList());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }

    }
    public void backToBefore() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setTitle("Home");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void addExportProduct() throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
        Main.mainStage.setTitle("Kho hàng");
        Main.mainStage.setScene(new Scene(root,750, 500));
        Main.mainStage.show();
    }
    public void exportProduct() throws Exception{
        if(exportProductTable.getSelectionModel().getSelectedItems().size() > 0){
            exportProductSelected = exportProductTable.getSelectionModel().getSelectedItem();
            ExportProductAccessObject epao = new ExportProductAccessObject();
            Product prod = new Product(null, exportProductSelected.getProductName(), exportProductSelected.getCategory(), exportProductSelected.getQuantity(), exportProductSelected.getUnitPrice());
            ProductAccessObject pao = new ProductAccessObject();
            if(epao.exportProduct(exportProductSelected)){
                if(exportProductSelected.getQuantity() == controller.khohang.Controller.productSelected.getQuantity() ){
                    pao.exportProduct(prod);
                    System.out.println("Export product success");
                    Parent root = FXMLLoader.load(getClass().getResource("exportproduct.fxml"));
                    Main.mainStage.setTitle("Export product");
                    Main.mainStage.setScene(new Scene(root, 750, 500));
                    Main.mainStage.show();
                }
                System.out.println("Export product success");
                Parent root = FXMLLoader.load(getClass().getResource("exportproduct.fxml"));
                Main.mainStage.setTitle("Export product");
                Main.mainStage.setScene(new Scene(root, 750, 500));
                Main.mainStage.show();
            }
            else{
                System.out.println("Export product failed");
            }
        }
    }
    public void deleteExportProduct() throws Exception{
        if(exportProductTable.getSelectionModel().getSelectedItems().size() > 0){
            exportProductSelected = exportProductTable.getSelectionModel().getSelectedItem();
            ExportProductAccessObject epao = new ExportProductAccessObject();
            Integer quantityProductExport = controller.addexportproduct.Controller.quantityAfterExport + exportProductSelected.getQuantity() + controller.editexportproduct.Controller.quantityAfterEdit;
            Product prod = new Product(null, exportProductSelected.getProductName(), exportProductSelected.getCategory(), quantityProductExport, exportProductSelected.getUnitPrice());
            ProductAccessObject pao = new ProductAccessObject();
            if(epao.deleteProduct(exportProductSelected) && pao.updateQuantityProduct(prod)){
                System.out.println("Delete export product success");
                Parent root = FXMLLoader.load(getClass().getResource("../exportproduct/exportproduct.fxml"));
                Main.mainStage.setTitle("Export Products");
                Main.mainStage.setScene(new Scene(root, 750, 500));
                Main.mainStage.show();
            }else{
                System.out.println("Delete export product failed");
            }
        }
    }
    public void editExportProduct() throws Exception{
        if(exportProductTable.getSelectionModel().getSelectedItems().size() > 0){
            exportProductSelected = exportProductTable.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("../editexportproduct/editexportproduct.fxml"));
            Main.mainStage.setTitle("Export Products");
            Main.mainStage.setScene(new Scene(root, 750, 500));
            Main.mainStage.show();
        }

    }
}
