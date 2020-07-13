package com.desafio.githubsearchjavapop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.githubLink.setText(items.get(position).getHtmlUrl());
        holder.repoName.setText(items.get(position).getRepoName());
        holder.description.setText(items.get(position).getDescription());
        holder.forks.setText(items.get(position).getForksCount());
        holder.stars.setText(items.get(position).getStargazersCount());
        holder.userLogin.setText(items.get(position).getLogin());

        Picasso.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.loading)
                .into(holder.userAvatar);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView githubLink, repoName, description, forks, stars, userLogin,
        private ImageView userAvatar;

        public ViewHolder(@NonNull View view) {
            super(view);
            githubLink = view.findViewById(R.id.act_row_githubLink_tv);
            repoName = view.findViewById(R.id.act_row_repository_name_tv);
            description = view.findViewById(R.id.act_row_description_tv);
            forks = view.findViewById(R.id.act_row_forkTotal_tv);
            stars = view.findViewById(R.id.act_row_starsTotal_tv);
            userLogin = view.findViewById(R.id.act_row_userLogin_tv);
            userAvatar = view.findViewById(R.id.act_row_userAvatar_imageView);
        }

        }
