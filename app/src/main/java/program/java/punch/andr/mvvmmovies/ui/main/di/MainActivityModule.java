package program.java.punch.andr.mvvmmovies.ui.main.di;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import program.java.punch.andr.mvvmmovies.ViewModelProviderFactory;
import program.java.punch.andr.mvvmmovies.data.DataController;
import program.java.punch.andr.mvvmmovies.ui.main.viewModel.MainViewModel;
import program.java.punch.andr.mvvmmovies.utils.ResourceProvider;
import retrofit2.Retrofit;


@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataController dataController,
                                        ResourceProvider
                                               resourceProvider) {
        return new MainViewModel(dataController, resourceProvider);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }


}
