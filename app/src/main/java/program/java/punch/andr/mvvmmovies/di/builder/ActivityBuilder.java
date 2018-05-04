package program.java.punch.andr.mvvmmovies.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import program.java.punch.andr.mvvmmovies.ui.favourite.FavouriteActivity;
import program.java.punch.andr.mvvmmovies.ui.favourite.di.FavouriteActivityModule;
import program.java.punch.andr.mvvmmovies.ui.main.MainActivity;
import program.java.punch.andr.mvvmmovies.ui.main.di.MainActivityModule;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class})
    abstract MainActivity bindMainActivity();


    @ContributesAndroidInjector(modules = {
            FavouriteActivityModule.class})
    abstract FavouriteActivity bindFavouriteActivity();


}
