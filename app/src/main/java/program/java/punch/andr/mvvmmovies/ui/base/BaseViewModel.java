package program.java.punch.andr.mvvmmovies.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;
import program.java.punch.andr.mvvmmovies.data.DataController;

public abstract class BaseViewModel<I> extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private DataController mDataController;
    private I mvvmView;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public BaseViewModel(DataController dataController) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.mDataController = dataController;
    }


    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public I getMvvmView() {
        return mvvmView;
    }

    public void setMvvmView(I mInterface) {
        mvvmView = mInterface;
    }

    public DataController getDataController() {
        return mDataController;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

}
