package com.desafio.githubsearchjavapop.ui.details.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.model.PullRequestDetail;
import com.desafio.githubsearchjavapop.utils.FormatText;
import com.desafio.githubsearchjavapop.utils.OnItemClickedListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PullViewHolder extends RecyclerView.ViewHolder{
    private TextView title, pullBody, date, login;
    private CircleImageView userAvatar;
    private OnItemClickedListener mListener;

    public void setOnClickedListener(OnItemClickedListener listener){
        this.mListener = listener;
    }

    public PullViewHolder(@NonNull final View view) {
        super(view);
        title = view.findViewById(R.id.act_rowPull_pr_title_tv);
        pullBody = view.findViewById(R.id.act_rowPull_descriptionPR_tv);
        date = view.findViewById(R.id.act_rowPull_datePR_tv);
        login = view.findViewById(R.id.act_rowPull_userLogin_tv);
        userAvatar = view.findViewById(R.id.act_rowPull_userAvatar_imageView);
    }

    public void onUpdateData(final PullRequestDetail pullRequestDetail){
        title.setText(pullRequestDetail.getTitle());
        pullBody.setText(pullRequestDetail.getBody());
        date.setText(FormatText.formatDate(pullRequestDetail.getCreated_at()));
        login.setText(pullRequestDetail.getUser().getName());

        Picasso.with(itemView.getContext())
                .load(pullRequestDetail.getUser().getAvatarUrl())
                .placeholder(R.drawable.loading)
                .into(userAvatar);
    }
}
