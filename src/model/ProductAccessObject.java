package model;

import controller.khohang.Controller;
import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.ExportProduct;
import model.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductAccessObject implements DataAccessObject<Product> {
    @Override
    public ObservableList<Product> getList() {
        ObservableList<Product> listProducts= FXCollections.observableArrayList();
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "select * from management";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);

            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                Integer quantity = rs.getInt("quantity");
                Integer unitPrice = rs.getInt("unitPrice");
                Product prod = new Product(id, name, category, quantity, unitPrice);
                listProducts.add(prod);
            }
        }catch (Exception e){}
        return listProducts;
    }

    @Override
    public boolean addProduct(Product product) {
        try{
            Connector c= Connector.getInstance();
            String txt_sql = "insert into management(name, category, quantity, unitprice)" +
                    "values('"+product.getName()+"', '"+product.getCategory()+"', "+product.getQuantity()+", "+product.getUnitPrice()+")";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
         return true;

    }

    @Override
    public boolean setProduct(Product product) {
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "update management set name = '"+product.getName()+"', category = '"+product.getCategory()+"', quantity = "+product.getQuantity()+", unitPrice = "+product.getUnitPrice()+"" +
                    " where id = "+product.getId()+" ";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "delete from management where id = "+product.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean exportProduct(Product product){
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from management where name = '"+product.getName()+"'";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean updateQuantityProduct(Product product){
        try {
            Connector c = Connector.getInstance();
            String txt_sql = " update management set quantity = "+product.getQuantity()+" " +
                    "where name = '"+product.getName()+"'";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
