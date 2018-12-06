package program.java.punch.andr.mvvmmovies.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import program.java.punch.andr.mvvmmovies.BR;
import program.java.punch.andr.mvvmmovies.R;
import program.java.punch.andr.mvvmmovies.adapters.MoviesAdapter;
import program.java.punch.andr.mvvmmovies.databinding.ActivityMainBinding;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.ui.base.BaseActivity;
import program.java.punch.andr.mvvmmovies.ui.favourite.FavouriteActivity;
import program.java.punch.andr.mvvmmovies.ui.main.interfaces.MainMvvmView;
import program.java.punch.andr.mvvmmovies.ui.main.viewModel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements
        MainMvvmView {

    @Inject
    MainViewModel mMainViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private ActivityMainBinding mActivityMainBinding;
    MoviesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setMvvmView(this);
        setSupportActionBar(mActivityMainBinding.toolbar);
        setTitle(R.string.app_name);
        setAdapter(mActivityMainBinding.recyclerview);
    }

    private void setAdapter(RecyclerView recyclerview) {
        adapter = new MoviesAdapter(mMainViewModel);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        setListFomViewModel();
    }


    void setListFomViewModel() {
        if (mMainViewModel.moviesList != null && !mMainViewModel.moviesList.isEmpty()) {
            if (adapter != null) {
                adapter.addMoviesToAdapter(mMainViewModel.moviesList);
            }

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setListFomViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.mainViewModel;
    }


    @Override
    public void startSearch() {
        hideSoftKeyboard(this);
        String title = mActivityMainBinding.searchEdittext.getText().toString().trim();
        if (isNetworkConnected()) {
            if (mMainViewModel.isMovieTitleValid(title)) {
                mMainViewModel.fetchMovies(title);
            } else {
                Toast.makeText(this, R.string.title_is_empty, Toast.LENGTH_LONG).show();

            }
        } else {
            Toast.makeText(this, R.string.network_not_aviable, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void updateAdapter(List<Movie> moviesList) {
        adapter.addMoviesToAdapter(moviesList);
    }

    @Override
    public void onMovieInserted(Boolean aBoolean) {
        if (aBoolean) {
            Toast.makeText(getApplication(), R.string.movie_is_added, Toast.LENGTH_LONG)
                    .show();
        } else {
            Toast.makeText(getApplication(), R.string.already_added, Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favourite, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_favourie) {

            Intent favouriteIntent = new Intent(this, FavouriteActivity.class);
            startActivity(favouriteIntent);

        }

        return super.onOptionsItemSelected(item);
    }

}
