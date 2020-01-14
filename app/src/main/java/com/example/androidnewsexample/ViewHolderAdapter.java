package com.example.androidnewsexample;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnewsexample.databinding.RvItemBinding;

public class ViewHolderAdapter extends RecyclerView.ViewHolder {
    private MainIPresenter.Presenter presenter;
    private RvItemBinding binding;

    public ViewHolderAdapter(@NonNull View itemView, MainIPresenter.Presenter presenter) {
        super(itemView);
        this.presenter = presenter;
        binding = DataBindingUtil.bind(itemView);
        if (binding != null && presenter != null) binding.setEvent(presenter);
    }

    public void bind (String item, int position) {
        if (item != null) {
            //binding. .setText(item);
            binding.itemNameView.setText(item);
        }
    }

}
