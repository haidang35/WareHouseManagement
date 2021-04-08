package model;

import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.ImportProduct;
import model.entity.Product;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

public class ImportProductAccessObject implements DataAccessObject<ImportProduct> {
    @Override
    public ObservableList<ImportProduct> getList() {
        ObservableList<ImportProduct> listImportProduct = FXCollections.observableArrayList();
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "select * from addnewproduct";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);

            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("ProductName");
                String category = rs.getString("Category");
                Integer quantity = rs.getInt("Quantity");
                Integer unitPrice = rs.getInt("UnitPrice");
                String staff = rs.getString("staff");
                String phoneNumber = rs.getString("PhoneNumber");
                Date date = rs.getDate("date");
                ImportProduct ip = new ImportProduct(id, name, category, quantity, unitPrice, staff, phoneNumber, date);
                listImportProduct.add(ip);
            }
        }catch (Exception e){}
        return listImportProduct;
    }

    @Override
    public boolean addProduct(ImportProduct importProduct) {
        try{
            Connector cn = Connector.getInstance();
            String txt_sql = "insert into addnewproduct(ProductName, Category, Quantity, UnitPrice, staff, PhoneNumber, date) " +
                    "values('"+importProduct.getProductName()+"','"+importProduct.getCategory()+"',"+importProduct.getQuantity()+", "+importProduct.getUnitPrice()+", '"+importProduct.getStaff()+"','"+importProduct.getPhoneNumber()+"','"+importProduct.getDate()+"')";
            cn.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean setProduct(ImportProduct importProduct) {
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "update addnewproduct set ProductName = '"+importProduct.getProductName()+"', Category = '"+importProduct.getCategory()+"', " +
                    " Quantity = "+importProduct.getQuantity()+", UnitPrice = "+importProduct.getUnitPrice()+", staff = '"+importProduct.getStaff()+"', " +
                    " PhoneNumber = '"+importProduct.getPhoneNumber()+"', Date = '"+importProduct.getDate()+"' " +
                    "where id = "+importProduct.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProduct(ImportProduct importProduct) {
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from addnewproduct where id = "+importProduct.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
       return true;
    }
}
