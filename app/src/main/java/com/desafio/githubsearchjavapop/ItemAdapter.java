package com.desafio.githubsearchjavapop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.controller.DetailsActivity;
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
        private TextView githubLink, repoName, description, forks, stars, userLogin;
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

            //on item click
            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = items.get(position);
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("name", items.get(position).getRepoName());
                        intent.putExtra("description", items.get(position).getDescription());
                        intent.putExtra("login", items.get(position).getLogin());
                        intent.putExtra("avatar_url", items.get(position).getAvatarUrl());
                        intent.putExtra("forks_count", items.get(position).getForksCount());
                        intent.putExtra("stargazers_count", items.get(position).getStargazersCount());
                        intent.putExtra("html_url", items.get(position).getHtmlUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getLogin(), Toast.LENGTH_SHORT).show();
                    }
                }
            }));
        }
    }
}

