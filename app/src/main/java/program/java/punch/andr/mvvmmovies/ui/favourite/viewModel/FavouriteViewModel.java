package program.java.punch.andr.mvvmmovies.ui.favourite.viewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import program.java.punch.andr.mvvmmovies.data.interfaces.DataController;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.ui.base.BaseViewModel;
import program.java.punch.andr.mvvmmovies.ui.favourite.interfaces.FavouriteMvvmView;

public class FavouriteViewModel extends BaseViewModel<FavouriteMvvmView> {
    public final ObservableList<Movie> moviesList = new ObservableArrayList<>();

    public FavouriteViewModel(DataController dataController) {
        super(dataController);

    }


    public void getFavourite() {
        getCompositeDisposable().add(getDataController().getFavouriteMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    moviesList.clear();
                    moviesList.addAll(movies);
                    getMvvmView().onMoviesLoaded(moviesList);
                }));
    }

    public void deleteFavourite(Movie movie) {
        getCompositeDisposable().add(getDataController().deleteFavourite(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    moviesList.remove(movie);
                    getMvvmView().OnFavouriteDeleted(moviesList);

                }));
    }
}
