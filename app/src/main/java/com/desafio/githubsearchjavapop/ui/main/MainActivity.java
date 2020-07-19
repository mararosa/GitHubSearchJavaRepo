package com.desafio.githubsearchjavapop.ui.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.data.remote.api.ApiClient;
import com.desafio.githubsearchjavapop.data.remote.api.GithubRepoRestApi;
import com.desafio.githubsearchjavapop.ui.details.DetailsActivity;
import com.desafio.githubsearchjavapop.ui.main.adapter.RepositoryAdapter;
import com.desafio.githubsearchjavapop.data.GithubRepositoryImpl;
import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.OnItemClickedListener;

import java.util.List;

/**
 * Created by Mara on 07/12/2020
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;
    private RepositoryAdapter mRepositoryAdapter;
    private ProgressDialog progressDialog;
    private Toolbar mainToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubRepoRestApi githubRepoRestApi = ApiClient.getClients().create(GithubRepoRestApi.class);
        presenter = new MainPresenter(this, new GithubRepositoryImpl(githubRepoRestApi));

        initView();
        presenter.onInit();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        mRepositoryAdapter = new RepositoryAdapter();
        recyclerView.setAdapter(mRepositoryAdapter);
        mRepositoryAdapter.setOnClickedListener(new OnItemClickedListener() {
            @Override
            public void onItemClicked(RepositoryDetail repositoryDetail) {
                presenter.onItemClicked(repositoryDetail);
            }
        });
        initToolbar();
    }

    private void initToolbar() {
        mainToolbar = findViewById(R.id.toolbar_base);
        mainToolbar.setTitle("Java Repositories");
        mainToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mainToolbar);
    }

    @Override
    public void showGithubRepositories(List<RepositoryDetail> repositoryDetails) {
        mRepositoryAdapter.replaceData(repositoryDetails);
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching Github repositories...");
            progressDialog.setCancelable(false);
        }
        if (!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Not Find", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openRepositoryDetailScreen(RepositoryDetail repositoryDetail) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("name", repositoryDetail.getRepoName());
            intent.putExtra("description", repositoryDetail.getDescription());
            intent.putExtra("login", repositoryDetail.getOwner().getLogin());
            intent.putExtra("avatar_url", repositoryDetail.getOwner().getAvatarUrl());
            intent.putExtra("forks_count", repositoryDetail.getForksCount());
            intent.putExtra("stargazers_count", repositoryDetail.getStargazersCount());
            intent.putExtra("html_url", repositoryDetail.getOwner().getHtmlUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
    }
}
