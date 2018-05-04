package program.java.punch.andr.mvvmmovies.ui.favourite.di;


import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import program.java.punch.andr.mvvmmovies.ViewModelProviderFactory;
import program.java.punch.andr.mvvmmovies.data.interfaces.DataController;
import program.java.punch.andr.mvvmmovies.ui.favourite.viewModel.FavouriteViewModel;


@Module
public class FavouriteActivityModule {

    @Provides
    FavouriteViewModel provideFavouriteViewModel(DataController dataController) {
        return new FavouriteViewModel(dataController);
    }


    @Provides
    ViewModelProvider.Factory favouriteViewModelProvider(FavouriteViewModel favouriteViewModel) {
        return new ViewModelProviderFactory<>(favouriteViewModel);
    }

}
