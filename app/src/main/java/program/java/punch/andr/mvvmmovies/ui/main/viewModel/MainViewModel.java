package program.java.punch.andr.mvvmmovies.ui.main.viewModel;

import android.databinding.ObservableField;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import program.java.punch.andr.mvvmmovies.R;
import program.java.punch.andr.mvvmmovies.data.interfaces.DataController;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.services.RetrofitService;
import program.java.punch.andr.mvvmmovies.ui.base.BaseViewModel;
import program.java.punch.andr.mvvmmovies.ui.main.interfaces.MainMvvmView;
import program.java.punch.andr.mvvmmovies.utils.ResourceProvider;

public class MainViewModel extends BaseViewModel<MainMvvmView> {
    public List<Movie> moviesList;
    private RetrofitService retrofitService;
    private ResourceProvider mResourceProvider;
    public final ObservableField<String> status;


    public MainViewModel(RetrofitService service, DataController dataController,
                         ResourceProvider resourceProvider) {
        super(dataController);
        retrofitService = service;
        mResourceProvider = resourceProvider;
        status = new ObservableField<>(mResourceProvider.getString(R.string.empty));

    }

    public void fetchMovies(String title) {
        setIsLoading(true);
        getCompositeDisposable().add(retrofitService.getMovies(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviesResponse -> {
                    moviesList = moviesResponse.getMovies();
                    if(moviesList == null) {
                        moviesList = new ArrayList<>();
                        status.set(mResourceProvider.getString(R.string.no_results));
                    }else {
                        status.set(mResourceProvider.getString(R.string.empty_str));
                    }
                    getMvvmView().updateAdapter(moviesList);
                    setIsLoading(false);

                }, throwable -> {
                    moviesList = new ArrayList<>();
                    MainViewModel.this.getMvvmView().updateAdapter(moviesList);
                    status.set(mResourceProvider.getString(R.string.no_results));
                    setIsLoading(false);

                }));

    }

    public void onSearchButtonClick() {
        getMvvmView().startSearch();
    }


    public boolean isMovieTitleValid(String movieTitle) {
        return !TextUtils.isEmpty(movieTitle);
    }


    public void insertFavouriteMovie(Movie movie) {
        getCompositeDisposable().add(getDataController().insertFavouriteMovie(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> false).
                        subscribe(aBoolean -> {
                            getMvvmView().onMovieInserted(aBoolean);
                        }));

    }

}
