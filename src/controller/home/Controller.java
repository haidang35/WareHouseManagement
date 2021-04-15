package controller.home;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void onWareHouse() throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
        Main.mainStage.setTitle("Kho hàng");
        Main.mainStage.setScene(new Scene(root,750, 500));
        Main.mainStage.show();

    }
    public void onImportProduct() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void onExportProduct() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../exportproduct/exportproduct.fxml"));
        Main.mainStage.setTitle("Export Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void onHistory() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../history/history.fxml"));
        Main.mainStage.setTitle("History");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }

}
