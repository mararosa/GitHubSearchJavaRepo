package com.desafio.githubsearchjavapop.ui.details;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.desafio.githubsearchjavapop.R;
import com.desafio.githubsearchjavapop.data.remote.api.ApiClient;
import com.desafio.githubsearchjavapop.data.remote.api.PullRequestRestApi;
import com.desafio.githubsearchjavapop.data.GithubPullImpl;
import com.desafio.githubsearchjavapop.model.PullRequestDetail;
import com.desafio.githubsearchjavapop.ui.details.adapter.PullRequestAdapter;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {
    private DetailsContract.Presenter presenter;
    private RecyclerView recyclerView;
    private PullRequestAdapter mPullRequestAdapter;
    private ProgressDialog progressDialog;
    private Toolbar detailsToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        PullRequestRestApi pullRequestRestApi = ApiClient.getClients().create(PullRequestRestApi.class);
        presenter = new DetailsPresenter(this, new GithubPullImpl(pullRequestRestApi));
        String repoName = getIntent().getExtras().getString("name");
        String userLogin = getIntent().getExtras().getString("login");
        initView();
        presenter.onInit(userLogin, repoName);
    }

    private void initView() {
        recyclerView = findViewById(R.id.pull_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        mPullRequestAdapter = new PullRequestAdapter();
        recyclerView.setAdapter(mPullRequestAdapter);
        initToolbar();
    }

    private void initToolbar() {
        detailsToolbar = findViewById(R.id.toolbar_base);
        detailsToolbar.setTitle("Pull Requests");
        detailsToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(detailsToolbar);
    }

    @Override
    public void showGithubRepositories(List<PullRequestDetail> pullRequestDetails) {
        mPullRequestAdapter.replaceData(pullRequestDetails);
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching Github pull request...");
            progressDialog.setCancelable(false);
        }
        if (!progressDialog.isShowing()) {
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
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }


}