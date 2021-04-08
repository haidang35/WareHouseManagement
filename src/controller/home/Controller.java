package controller.home;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void onWareHouse() throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("../khohang/khohang.fxml"));
        Main.mainStage.setTitle("Kho hàng");
        Main.mainStage.setScene(new Scene(root,600, 400));
        Main.mainStage.show();

    }
    public void onImportProduct() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../importproduct/importproduct.fxml"));
        Main.mainStage.setTitle("Import Products");
        Main.mainStage.setScene(new Scene(root, 750, 500));
        Main.mainStage.show();
    }
    public void onExportProduct(){

    }

}
