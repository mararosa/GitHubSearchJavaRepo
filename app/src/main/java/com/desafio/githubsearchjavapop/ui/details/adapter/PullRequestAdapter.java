package com.desafio.githubsearchjavapop.ui.details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.model.PullDetail;
import com.desafio.githubsearchjavapop.utils.OnItemClickedListener;

import java.util.List;

public class PullRequestAdapter extends RecyclerView.Adapter<PullViewHolder> {
    private List<PullDetail> mPullDetailLists = null;
    private Context context;
    private OnItemClickedListener mListener;

    @NonNull
    @Override
    public PullViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pull_resquest, parent, false);
        return new PullViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PullViewHolder holder, int position) {
        if(mPullDetailLists != null) {
            holder.setOnClickedListener(mListener);
            holder.onUpdateData(mPullDetailLists.get(position));
        }
        else{
            //TODO
        }
    }

    @Override
    public int getItemCount()
    {
        return mPullDetailLists!=null?mPullDetailLists.size():0;
    }

    public void replaceData(List<PullDetail> pullDetails) {
        this.mPullDetailLists = pullDetails;

        notifyDataSetChanged();
    }
}
