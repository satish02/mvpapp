package com.satish.mvpapp.presenter;

import com.satish.mvpapp.model.Category;
import com.satish.mvpapp.model.Product;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class MainActivityContract {

    public interface View {
        void showCategory(ArrayList<Category> categoryArrayList);
        void showProductList(String filterName, ArrayList<Product> productArrayList);
        void showMessage(String message);
        void showError(String errorMessage);
    }

    public interface Actions {
        void getCategories();
        void filterMostOrdered(int filterIndex);
    }

}
