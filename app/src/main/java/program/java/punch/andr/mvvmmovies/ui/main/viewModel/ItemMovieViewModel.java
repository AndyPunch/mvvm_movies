package program.java.punch.andr.mvvmmovies.ui.main.viewModel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import program.java.punch.andr.mvvmmovies.R;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.utils.GlideApp;

public class ItemMovieViewModel {

    private Movie movie;
    public final ObservableField<String> title;
    public final ObservableField<String> poster;
    public final ItemMovieViewModelListener mListener;


    public ItemMovieViewModel(Movie movie, ItemMovieViewModelListener mListener) {

        this.movie = movie;
        title = new ObservableField<>(movie.getTitle());
        poster = new ObservableField<>(movie.getPoster());
        this.mListener = mListener;
    }


    @BindingAdapter("imageUrl")
    public static void setImgUrl(ImageView imageView, String url) {
        GlideApp.with(imageView.getContext()).load(url)
                .placeholder(R.drawable.noimage).into(imageView);
    }


    public void onFavouriteIconClick(View view) {
        mListener.onAddFavouriteClick(movie);
    }


    public interface ItemMovieViewModelListener {

        void onAddFavouriteClick(Movie movie);
    }
}
