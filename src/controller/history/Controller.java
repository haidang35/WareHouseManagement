package controller.history;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.HistoryAccessObject;
import model.entity.History;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<History> historyTable;
    public TableColumn<History, Integer> idView;
    public TableColumn<History, String> statusView;
    public TableColumn<History, String> productView;
    public TableColumn<History, String> categoryView;
    public TableColumn<History, Integer> quantityView;
    public TableColumn<History, String> staffView;
    public TableColumn<History, String> phoneNumberView;
    public TableColumn<History, Date> dateView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        statusView.setCellValueFactory(new PropertyValueFactory<>("status"));
        productView.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        staffView.setCellValueFactory(new PropertyValueFactory<>("staff"));
        phoneNumberView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));
        try{
            HistoryAccessObject hao = new HistoryAccessObject();
            historyTable.setItems(hao.getList());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }


    }
    public void back() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setTitle("Home");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void deleteOne() throws Exception{
        if(historyTable.getSelectionModel().getSelectedItems().size() > 0){
            History his = historyTable.getSelectionModel().getSelectedItem();
            HistoryAccessObject hao = new HistoryAccessObject();
            if(hao.deleteOne(his)){
                System.out.println("Delete one success");
            }else{
                System.out.println("Delete one failed");
            }
            Parent root = FXMLLoader.load(getClass().getResource("../history/history.fxml"));
            Main.mainStage.setTitle("History");
            Main.mainStage.setScene(new Scene(root, 750, 500));
            Main.mainStage.show();
        }
    }
    public void deleteAll() throws Exception{
        HistoryAccessObject hao = new HistoryAccessObject();
        if(hao.deleteAll()){
            System.out.println("Delete all success");
        }else{
            System.out.println("Delete all failed");
        }
        Parent root = FXMLLoader.load(getClass().getResource("../history/history.fxml"));
        Main.mainStage.setTitle("History");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void filterExport() throws Exception{
        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        statusView.setCellValueFactory(new PropertyValueFactory<>("status"));
        productView.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        staffView.setCellValueFactory(new PropertyValueFactory<>("staff"));
        phoneNumberView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));
        try{
            HistoryAccessObject hao = new HistoryAccessObject();
            historyTable.setItems(hao.getListExport());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }
        Parent root = FXMLLoader.load(getClass().getResource("../history/history.fxml"));
        Main.mainStage.setTitle("History");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void filterImport() throws Exception{
        idView.setCellValueFactory(new PropertyValueFactory<>("id"));
        statusView.setCellValueFactory(new PropertyValueFactory<>("status"));
        productView.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        staffView.setCellValueFactory(new PropertyValueFactory<>("staff"));
        phoneNumberView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));
        try{
            HistoryAccessObject hao = new HistoryAccessObject();
            historyTable.setItems(hao.getListImport());
            System.out.println("Connected database");
        }catch (Exception e){
            System.out.println("Connect to database failed");
        }
        Parent root = FXMLLoader.load(getClass().getResource("../history/history.fxml"));
        Main.mainStage.setTitle("History");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
}
