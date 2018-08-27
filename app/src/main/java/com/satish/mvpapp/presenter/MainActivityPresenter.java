package com.satish.mvpapp.presenter;

import com.satish.mvpapp.model.Category;
import com.satish.mvpapp.model.CategoryResponse;
import com.satish.mvpapp.model.Product;
import com.satish.mvpapp.model.ProductRanking;
import com.satish.mvpapp.model.Ranking;
import com.satish.mvpapp.request.ApiInterface;
import com.satish.mvpapp.request.RetrofitRequestManager;
import com.satish.mvpapp.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by Satish on 8/27/2018
 */
public class MainActivityPresenter implements MainActivityContract.Actions{

    private MainActivityContract.View view;
    private CategoryResponse categoryResponse;


    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void getCategories() {
        ApiInterface service = RetrofitRequestManager.getClient().create(ApiInterface.class);

        Call<CategoryResponse> call = service.getCategory();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.code() == 200) {
                    categoryResponse = response.body();

                    if(categoryResponse.getCategoryArrayList() != null && categoryResponse.getCategoryArrayList() != null
                            && categoryResponse.getCategoryArrayList().size() > 0) {
                        view.showCategory(categoryResponse.getCategoryArrayList());
                    }
                    else
                        view.showMessage("No category found!");
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }


    @Override
    public void filterMostOrdered(int filerIndex) {
        ArrayList<Product> productArrayList = filterProductList(filerIndex);
        if(productArrayList != null && productArrayList.size() > 0) {
            Ranking ranking = categoryResponse.getRankingArrayList().get(filerIndex);
            view.showProductList(ranking.getRanking(), productArrayList);
        }
        else
            view.showMessage("No data found!");
    }

    private ArrayList<Product> filterProductList(int filterIndex){
        ArrayList<Product> productArrayList = new ArrayList<>();

        ArrayList<ProductRanking> productRankingArrayList = getProductList(filterIndex);
        for (ProductRanking productRanking : productRankingArrayList) {
            int productId = productRanking.getId();
            for (Category category : categoryResponse.getCategoryArrayList()) {

                for (Product product : category.getProductArrayList()) {
                    if (product.getId() == productId) {
                        productArrayList.add(product);
                        break;
                    }
                }
            }
        }
        return productArrayList;
    }


    private ArrayList<ProductRanking> getProductList(int filterIndex){
        ArrayList<Ranking> rankingArrayList = categoryResponse.getRankingArrayList();
        Ranking ranking = rankingArrayList.get(filterIndex);
        ArrayList<ProductRanking> productRankings;
        switch (filterIndex) {
            case Constants.RANKING_MOST_VIEWED:
                productRankings = ranking.getProductRankingArrayList();

                Collections.sort(productRankings, new Comparator<ProductRanking>() {
                    @Override
                    public int compare(ProductRanking ranking1, ProductRanking ranking2) {
                        return (ranking1.getOrderCount() - ranking2.getOrderCount());
                    }
                });
                return productRankings;
            case Constants.RANKING_MOST_ORDERED:
                productRankings = ranking.getProductRankingArrayList();

                Collections.sort(productRankings, new Comparator<ProductRanking>() {
                    @Override
                    public int compare(ProductRanking ranking1, ProductRanking ranking2) {
                        return (ranking1.getOrderCount() - ranking2.getOrderCount());
                    }
                });
                return productRankings;

            case Constants.RANKING_MOST_SHARED:
                productRankings = ranking.getProductRankingArrayList();

                Collections.sort(productRankings, new Comparator<ProductRanking>() {
                    @Override
                    public int compare(ProductRanking ranking1, ProductRanking ranking2) {
                        return (ranking1.getOrderCount() - ranking2.getOrderCount());
                    }
                });
                return productRankings;
        }
        return null;
    }
}
