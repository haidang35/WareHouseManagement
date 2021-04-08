package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface DataAccessObject<S> {
    ObservableList<S> getList();
    boolean addProduct(S s);
    boolean setProduct(S s);
    boolean deleteProduct(S s);
}
