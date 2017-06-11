package com.ausichenko.regextools.fragments;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ausichenko.regextools.R;
import com.ausichenko.regextools.databinding.FragmentPatternsBinding;
import com.ausichenko.regextools.ui.PatternAdapter;
import com.ausichenko.regextools.viewmodel.PatternListViewModel;

public class PatternsFragment extends LifecycleFragment {

    private PatternAdapter mProductAdapter;

    private FragmentPatternsBinding mBinding;

    public PatternsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_patterns, container, false);

        mProductAdapter = new PatternAdapter(/*mPatternClickCallback*/);
        mBinding.productsList.setAdapter(mProductAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final PatternListViewModel viewModel =
                ViewModelProviders.of(this).get(PatternListViewModel.class);

        subscribeUi(viewModel);
    }

    private void subscribeUi(PatternListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getPatterns().observe(this, myProducts -> {
            if (myProducts != null) {
                mBinding.setIsLoading(false);
                mProductAdapter.setProductList(myProducts);
            } else {
                mBinding.setIsLoading(true);
            }
        });
    }
}
