package com.satish.mvpapp.presenter;

import com.satish.mvpapp.model.Category;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class MainActivityContract {

    public interface View {
        void showCategory(ArrayList<Category> categoryArrayList);
        void showMostViewed(ArrayList<Category> categoryArrayList);
        void showMostOrdered(ArrayList<Category> categoryArrayList);
        void showMostShared(ArrayList<Category> categoryArrayList);
    }

    public interface Actions {
        void getCategories();
        void filterMostViewed();
        void filterMostOrdered();
        void filterMostShared();
    }

}
