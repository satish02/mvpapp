package com.satish.mvpapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.satish.mvpapp.model.Category;
import com.satish.mvpapp.model.Product;
import com.satish.mvpapp.presenter.MainActivityContract;
import com.satish.mvpapp.presenter.MainActivityPresenter;
import com.satish.mvpapp.ui.adapter.CategoryAdapter;
import com.satish.mvpapp.ui.adapter.ProductAdapter;
import com.satish.mvpapp.utils.Constants;
import com.satish.mvpapp.utils.NetworkHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Actions presenter;

    private ProgressBar progressBar;
    private RecyclerView rvCategoery;
    private RecyclerView rvProduct;
    private TextView tvFilterType;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new MainActivityPresenter(this);
        getCategories();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewed:
                presenter.filterMostOrdered(Constants.RANKING_MOST_VIEWED);
                return (true);
            case R.id.ordered:
                presenter.filterMostOrdered(Constants.RANKING_MOST_ORDERED);
                return (true);
            case R.id.shared:
                presenter.filterMostOrdered(Constants.RANKING_MOST_SHARED);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }


    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        rvCategoery = findViewById(R.id.rvCategory);
        rvProduct = findViewById(R.id.rvProduct);
        tvFilterType = findViewById(R.id.tvFilterType);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true);
        //manager.setReverseLayout(true);
        rvCategoery.setLayoutManager(manager);
        rvCategoery.setHasFixedSize(true);

        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        rvProduct.setHasFixedSize(true);

    }


    private void getCategories() {
        if (NetworkHandler.checkNetworkStatus(MainActivity.this)) {
            progressBar.setVisibility(View.VISIBLE);
            presenter.getCategories();
        } else
            showMessage("Please connect to the internet!");
    }

    @Override
    public void showCategory(ArrayList<Category> categoryArrayList) {
        categoryAdapter = new CategoryAdapter(getApplicationContext(), categoryArrayList);
        rvCategoery.setAdapter(categoryAdapter);
        presenter.filterMostOrdered(Constants.RANKING_MOST_VIEWED);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProductList(String filterName, ArrayList<Product> productArrayList) {
        tvFilterType.setText(filterName);

        if (productAdapter == null) {
            productAdapter = new ProductAdapter(productArrayList);
            rvProduct.setAdapter(productAdapter);
        } else {
            productAdapter.setProductArrayList(productArrayList);
        }
    }

    @Override
    public void showMessage(String message) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
