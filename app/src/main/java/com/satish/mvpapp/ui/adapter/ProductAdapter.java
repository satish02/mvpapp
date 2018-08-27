package com.satish.mvpapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satish.mvpapp.model.Product;
import com.satish.mvpapp.ui.R;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productArrayList;

    public ProductAdapter(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_product, viewGroup, false);

        ProductAdapter.ProductViewHolder productViewHolder = new ProductAdapter.ProductViewHolder(itemView);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.bindData(productArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        if (productArrayList == null)
            return 0;
        return productArrayList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDateAdded;
        TextView tvTax;
        TextView tvVariants;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDateAdded = itemView.findViewById(R.id.tvDateAdded);
            tvTax = itemView.findViewById(R.id.tvTax);
            tvVariants = itemView.findViewById(R.id.tvVariants);
        }

        public void bindData(Product product) {
            tvName.setText(product.getProductName());
            tvDateAdded.setText(product.getDateAdded());
            String tax = product.getTax().getTax() + "(" + product.getTax().getName() + ")";
            tvTax.setText(tax);
            if (product.getVariantArrayList() != null && product.getVariantArrayList().size() > 0)
                tvVariants.setText(String.valueOf( "Variant:" + product.getVariantArrayList().size()));
            else
                tvVariants.setText("0");
        }
    }
}
