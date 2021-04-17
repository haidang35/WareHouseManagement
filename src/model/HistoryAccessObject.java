package model;

import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.History;

import java.sql.Date;
import java.sql.ResultSet;

public class HistoryAccessObject implements DataAccessObject<History>{
    @Override
    public ObservableList<History> getList() {
        ObservableList<History> listHistory = FXCollections.observableArrayList();
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "select * from history";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String status = rs.getString("status");
                String productName = rs.getString("productname");
                String category = rs.getString("category");
                Integer quantity = rs.getInt("quantity");
                String staff = rs.getString("staff");
                String phoneNumber = rs.getString("phonenumber");
                Date date = rs.getDate("date");
                History his = new History(id, status, productName, category, quantity, staff, phoneNumber, date);
                listHistory.add(his);
            }
        }catch (Exception e){
            System.out.println("Error");
        }
        return listHistory;
    }

    @Override
    public boolean addProduct(History history) {
        try{
            Connector c = Connector.getInstance();
            String txt_sql = "insert into history(status, productname, category, quantity, staff, phonenumber, date)" +
                    "values('"+history.getStatus()+"', '"+history.getProductName()+"', '"+history.getCategory()+"', "+history.getQuantity()+"," +
                    "'"+history.getStaff()+"', '"+history.getPhoneNumber()+"', '"+history.getDate()+"')";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean setProduct(History history) {
        return false;
    }

    @Override
    public boolean deleteProduct(History history) {
        return false;
    }
    public boolean deleteOne(History history){
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from history where id = "+history.getId()+"";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean deleteAll(){
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "delete from history";
            c.getStatement().execute(txt_sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public ObservableList<History> getListExport() {
        ObservableList<History> listExport = FXCollections.observableArrayList();
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "select * from history where status = 'Export'";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String status = rs.getString("status");
                String productName = rs.getString("productname");
                String category = rs.getString("category");
                Integer quantity = rs.getInt("quantity");
                String staff = rs.getString("staff");
                String phoneNumber = rs.getString("phonenumber");
                Date date = rs.getDate("date");
                History his = new History(id, status, productName, category, quantity, staff, phoneNumber, date);
                listExport.add(his);
            }
            System.out.println("Get list Export from database success");
        }catch (Exception e){
            System.out.println("Not filter list export");
        }
//        for(History lis: listExport){
//            System.out.println(lis.getStatus() + lis.getProductName());
//        }
        return listExport;
    }
    public ObservableList<History> getListImport() {
        ObservableList<History> listImport = FXCollections.observableArrayList();
        try {
            Connector c = Connector.getInstance();
            String txt_sql = "select * from history where status = 'Import'";
            ResultSet rs = c.getStatement().executeQuery(txt_sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String status = rs.getString("status");
                String productName = rs.getString("productname");
                String category = rs.getString("category");
                Integer quantity = rs.getInt("quantity");
                String staff = rs.getString("staff");
                String phoneNumber = rs.getString("phonenumber");
                Date date = rs.getDate("date");
                History his = new History(id, status, productName, category, quantity, staff, phoneNumber, date);
                listImport.add(his);
            }
        }catch (Exception e){
            System.out.println("Not filter list import");
        }
        return listImport;
    }
}
