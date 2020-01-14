package com.example.androidnewsexample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ViewHolderAdapter> {
    private MainIPresenter.Presenter presenter;
    private List<String> list;

    public ExampleAdapter(MainIPresenter.Presenter presenter, List<String> list) {
        this.presenter = presenter;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false), presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        if (list.size() != 0) holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
