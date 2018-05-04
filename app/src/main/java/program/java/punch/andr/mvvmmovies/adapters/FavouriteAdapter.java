package program.java.punch.andr.mvvmmovies.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import program.java.punch.andr.mvvmmovies.databinding.ItemFavouriteBinding;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.ui.favourite.viewModel.FavouriteViewModel;
import program.java.punch.andr.mvvmmovies.ui.favourite.viewModel.ItemFavouriteViewModel;


public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteHolder> {

    private List<Movie> favouriteList = new ArrayList<>();
    FavouriteViewModel mFavouriteViewModel;

    public FavouriteAdapter(FavouriteViewModel mFavouriteViewModel) {
        this.mFavouriteViewModel = mFavouriteViewModel;
    }

    @NonNull
    @Override
    public FavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavouriteBinding itemFavouriteBinding = ItemFavouriteBinding.inflate(LayoutInflater
                        .from(parent.getContext()),
                parent, false);
        return new FavouriteHolder(itemFavouriteBinding);
    }


    @Override
    public void onBindViewHolder(FavouriteHolder holder, int position) {
        holder.bindFavourite(favouriteList.get(position));
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }


    public class FavouriteHolder extends RecyclerView.ViewHolder implements
            ItemFavouriteViewModel.ItemFavouriteViewModelListener


    {
        ItemFavouriteBinding mItemFavouriteBinding;

        public FavouriteHolder(ItemFavouriteBinding itemFavouriteBinding) {
            super(itemFavouriteBinding.itemFavourite);
            this.mItemFavouriteBinding = itemFavouriteBinding;
        }


        void bindFavourite(Movie movie) {
            ItemFavouriteViewModel itemFavouriteViewModel = new ItemFavouriteViewModel(movie,
                    this);
            mItemFavouriteBinding.setFavouriteItemViewModel(itemFavouriteViewModel);
            mItemFavouriteBinding.executePendingBindings();
        }


        @Override
        public void onDeleteFavouriteClick(Movie movie) {
            mFavouriteViewModel.deleteFavourite(movie);
        }
    }

    public void addMoviesToAdapter(List<Movie> l) {
        this.favouriteList = l;
        notifyDataSetChanged();
    }

    public void clearMovies() {
        favouriteList.clear();
        notifyDataSetChanged();
    }
}
