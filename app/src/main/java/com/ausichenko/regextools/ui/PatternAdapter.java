package com.ausichenko.regextools.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ausichenko.regextools.R;
import com.ausichenko.regextools.databinding.PatternItemBinding;
import com.ausichenko.regextools.model.Pattern;

import java.util.List;
import java.util.Objects;

public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.PatternViewHolder> {

    List<? extends Pattern> mProductList;

    /*
    @Nullable
    private final ProductClickCallback mProductClickCallback;
    */

    public PatternAdapter(/*@Nullable PatternClickCallback clickCallback*/) {
        //mProductClickCallback = clickCallback;
    }

    public void setProductList(final List<? extends Pattern> productList) {
        if (mProductList == null) {
            mProductList = productList;
            notifyItemRangeInserted(0, productList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mProductList.size();
                }

                @Override
                public int getNewListSize() {
                    return productList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mProductList.get(oldItemPosition).getId() ==
                            productList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Pattern product = productList.get(newItemPosition);
                    Pattern old = productList.get(oldItemPosition);
                    return product.getId() == old.getId()
                            && Objects.equals(product.getPattern(), old.getPattern())
                            && Objects.equals(product.getName(), old.getName());
                }
            });
            mProductList = productList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public PatternViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PatternItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.pattern_item,
                        parent, false);
        //binding.setCallback(mProductClickCallback);
        return new PatternViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PatternViewHolder holder, int position) {
        holder.binding.setProduct(mProductList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mProductList == null ? 0 : mProductList.size();
    }

    static class PatternViewHolder extends RecyclerView.ViewHolder {

        final PatternItemBinding binding;

        public PatternViewHolder(PatternItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
