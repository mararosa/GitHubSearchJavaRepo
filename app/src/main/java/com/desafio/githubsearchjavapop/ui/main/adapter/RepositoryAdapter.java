package com.desafio.githubsearchjavapop.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.OnItemClickedListener;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {
    private List<RepositoryDetail> mRepositoryDetails = null;
    private Context context;
    private OnItemClickedListener mListener;

    public void setOnClickedListener(OnItemClickedListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_javarepo, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        if(mRepositoryDetails != null) {
            holder.setOnClickedListener(mListener);
            holder.onUpdateData(mRepositoryDetails.get(position));
        }
        else{
            //TODO
        }
    }

    @Override
    public int getItemCount()
    {
        return mRepositoryDetails != null ? mRepositoryDetails.size() : 0;
    }


    public void replaceData(List<RepositoryDetail> repositoryDetails) {
        this.mRepositoryDetails = repositoryDetails;

        notifyDataSetChanged();
    }
}

