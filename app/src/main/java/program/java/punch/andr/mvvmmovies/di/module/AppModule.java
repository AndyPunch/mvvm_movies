package program.java.punch.andr.mvvmmovies.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import program.java.punch.andr.mvvmmovies.data.AppDataController;
import program.java.punch.andr.mvvmmovies.data.db.AppDatabase;
import program.java.punch.andr.mvvmmovies.data.db.dbHelper.AppDbHelper;
import program.java.punch.andr.mvvmmovies.data.db.dbHelper.interfaces.DbHelper;
import program.java.punch.andr.mvvmmovies.data.interfaces.DataController;
import program.java.punch.andr.mvvmmovies.di.scope.DatabaseInfo;
import program.java.punch.andr.mvvmmovies.utils.AppConstants;
import program.java.punch.andr.mvvmmovies.utils.ResourceProvider;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {
    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DataController provideDataController(AppDataController appDataController) {
        return appDataController;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    @Provides
    @Singleton
    ResourceProvider provideResourceProvider(Context mContext) {
        return new ResourceProvider(mContext);
    }


}
