package com.satish.mvpapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.satish.mvpapp.model.Category;
import com.satish.mvpapp.ui.R;

import java.util.ArrayList;

/*
 * Created by Satish on 8/27/2018
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context context;
    private ArrayList<Category> categoryArrayList;

    public CategoryAdapter(Context context, ArrayList<Category> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_category, viewGroup, false);
        final CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemView);
        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Show list of selected category ("
                        + categoryViewHolder.getAdapterPosition() + ")", Toast.LENGTH_SHORT).show();
            }
        });
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.bindData(categoryArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDateAdded;
        TextView tvVariantCount;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            //tvDateAdded = itemView.findViewById(R.id.tvDateCreated);
            //tvVariantCount = itemView.findViewById(R.id.tvVariantCount);
        }

        public void bindData(Category category) {
            tvName.setText(category.getCategoryName());
        }
    }
}
