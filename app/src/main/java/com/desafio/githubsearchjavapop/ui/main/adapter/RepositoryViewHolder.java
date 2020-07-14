package com.desafio.githubsearchjavapop.ui.main.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.OnItemClickedListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {
    private TextView githubLink, repoName, description, forks, stars, userLogin;
    private CircleImageView userAvatar;
    private OnItemClickedListener mListener;

    public void setOnClickedListener(OnItemClickedListener listener){
        this.mListener = listener;
    }

    public RepositoryViewHolder(@NonNull final View view) {
        super(view);
        githubLink = view.findViewById(R.id.act_row_githubLink_tv);
        repoName = view.findViewById(R.id.act_rowPull_pr_title_tv);
        description = view.findViewById(R.id.act_rowPull_descriptionPR_tv);
        forks = view.findViewById(R.id.act_row_forkTotal_tv);
        stars = view.findViewById(R.id.act_row_starsTotal_tv);
        userLogin = view.findViewById(R.id.act_rowPull_userLogin_tv);
        userAvatar = view.findViewById(R.id.act_rowPull_userAvatar_imageView);
    }

    public void onUpdateData(final RepositoryDetail repositoryDetail){
        repoName.setText(repositoryDetail.getRepoName());
        description.setText(repositoryDetail.getDescription());
        forks.setText(repositoryDetail.getForksCount());
        stars.setText(repositoryDetail.getStargazersCount());
        userLogin.setText(repositoryDetail.getOwner().getLogin());
        githubLink.setText(repositoryDetail.getOwner().getHtmlUrl());

        Picasso.with(itemView.getContext())
                .load(repositoryDetail.getOwner().getAvatarUrl())
                .placeholder(R.drawable.loading)
                .into(userAvatar);

        itemView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClicked(repositoryDetail);
                }
            }
        }));
    }
}

