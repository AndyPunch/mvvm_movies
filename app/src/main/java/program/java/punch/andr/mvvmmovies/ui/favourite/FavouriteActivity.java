package program.java.punch.andr.mvvmmovies.ui.favourite;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import program.java.punch.andr.mvvmmovies.BR;
import program.java.punch.andr.mvvmmovies.R;
import program.java.punch.andr.mvvmmovies.adapters.FavouriteAdapter;
import program.java.punch.andr.mvvmmovies.databinding.ActivityFavouriteBinding;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.ui.base.BaseActivity;
import program.java.punch.andr.mvvmmovies.ui.favourite.interfaces.FavouriteMvvmView;
import program.java.punch.andr.mvvmmovies.ui.favourite.viewModel.FavouriteViewModel;

public class FavouriteActivity extends BaseActivity<ActivityFavouriteBinding, FavouriteViewModel>
        implements FavouriteMvvmView {

    @Inject
    FavouriteViewModel mFavouriteViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;


    private FavouriteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFavouriteBinding mActivityFavouriteBinding = getViewDataBinding();
        mFavouriteViewModel.setMvvmView(this);
        setSupportActionBar(mActivityFavouriteBinding.toolbar);
        setTitle(getString(R.string.favourite_movies));
        setAdapter(mActivityFavouriteBinding.recyclerviewFavourite);
    }



    private void setAdapter(RecyclerView recyclerview) {
        adapter = new FavouriteAdapter(mFavouriteViewModel);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        if (mFavouriteViewModel.moviesList != null && mFavouriteViewModel.moviesList.size() > 0) {
            adapter.addMoviesToAdapter(mFavouriteViewModel.moviesList);
        } else {
            mFavouriteViewModel.getFavourite();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_favourite;
    }

    @Override
    public FavouriteViewModel getViewModel() {
        mFavouriteViewModel = ViewModelProviders.of(this, mViewModelFactory).get
                (FavouriteViewModel.class);
        return mFavouriteViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.favouriteViewModel;
    }


    @Override
    public void onMoviesLoaded(List<Movie> moviesList) {
        adapter.addMoviesToAdapter(moviesList);
    }

    @Override
    public void OnFavouriteDeleted(List<Movie> moviesList) {
        adapter.addMoviesToAdapter(moviesList);
        Toast.makeText(this, R.string.favourite_deleted, Toast.LENGTH_LONG).show();
    }
}
