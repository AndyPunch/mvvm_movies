package program.java.punch.andr.mvvmmovies.di.component;

import android.app.Application;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import program.java.punch.andr.mvvmmovies.MvvmApp;
import program.java.punch.andr.mvvmmovies.di.builder.ActivityBuilder;
import program.java.punch.andr.mvvmmovies.di.module.AppModule;


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
