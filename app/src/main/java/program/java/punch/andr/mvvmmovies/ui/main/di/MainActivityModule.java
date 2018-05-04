package program.java.punch.andr.mvvmmovies.ui.main.di;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import program.java.punch.andr.mvvmmovies.ViewModelProviderFactory;
import program.java.punch.andr.mvvmmovies.data.interfaces.DataController;
import program.java.punch.andr.mvvmmovies.services.RetrofitService;
import program.java.punch.andr.mvvmmovies.ui.main.viewModel.MainViewModel;
import program.java.punch.andr.mvvmmovies.utils.ResourceProvider;
import retrofit2.Retrofit;


@Module
public class MainActivityModule {


    @Provides
    RetrofitService provideApiService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    @Provides
    MainViewModel provideMainViewModel(DataController dataController,
                                       RetrofitService retrofitService, ResourceProvider
                                               resourceProvider) {
        return new MainViewModel(retrofitService, dataController, resourceProvider);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }


}
