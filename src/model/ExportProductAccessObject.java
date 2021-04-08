package model;

import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.ExportProduct;

import java.sql.Date;
import java.sql.ResultSet;

public class ExportProductAccessObject implements DataAccessObject<ExportProduct>{
    @Override
    public ObservableList<ExportProduct> getList() {
        ObservableList<ExportProduct> listExportProduct = FXCollections.observableArrayList();
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "select * from exportproduct";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);
            while(rs.next()){
                Integer id = rs.getInt("id");
                String productName = rs.getString("productname");
                String category = rs.getString("category");
                Integer quantity = rs.getInt("quantity");
                Integer unitPrice = rs.getInt("unitprice");
                String staff = rs.getString("staff");
                String phoneNumber = rs.getString("phonenumber");
                Date dateNow = rs.getDate("date");
                ExportProduct exprod = new ExportProduct(id, productName, category, quantity, unitPrice, staff, phoneNumber, dateNow);
                listExportProduct.add(exprod);
            }

        }catch (Exception e){}
        return listExportProduct;
    }

    @Override
    public boolean addProduct(ExportProduct exportProduct) {
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "insert into exportproduct( productname, category, quantity, unitprice, staff, phonenumber, date)" +
                    "values('"+exportProduct.getProductName()+"', '"+exportProduct.getCategory()+"', "+exportProduct.getQuantity()+", "+exportProduct.getUnitPrice()+", " +
                    " '"+exportProduct.getStaff()+"', '"+exportProduct.getPhoneNumber()+"', '"+exportProduct.getDate()+"')";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean setProduct(ExportProduct exportProduct) {
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "update exportproduct set productname = '"+exportProduct.getProductName()+"', category = '"+exportProduct.getCategory()+"', " +
                    "quantity = "+exportProduct.getQuantity()+", unitprice = "+exportProduct.getUnitPrice()+", staff = '"+exportProduct.getStaff()+"', phonenumber = '"+exportProduct.getPhoneNumber()+"', date = '"+exportProduct.getDate()+"'  ";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProduct(ExportProduct exportProduct) {
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from exportproduct where id = "+exportProduct.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean exportProduct(ExportProduct exportProduct){
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from exportproduct where id = "+exportProduct.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
