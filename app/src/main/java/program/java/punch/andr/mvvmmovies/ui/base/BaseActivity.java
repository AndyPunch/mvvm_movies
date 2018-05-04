package program.java.punch.andr.mvvmmovies.ui.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;
import program.java.punch.andr.mvvmmovies.utils.GeneralUtils;
import program.java.punch.andr.mvvmmovies.utils.NetworkUtils;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
        extends AppCompatActivity {


    private T mViewDataBinding;
    private V mViewModel;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
    }


    public T getViewDataBinding() {
        return mViewDataBinding;
    }


    public abstract
    @LayoutRes
    int getLayoutId();


    public abstract V getViewModel();


    public abstract int getBindingVariable();


    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }


    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void hideSoftKeyboard(Activity activity) {
        GeneralUtils.hideSoftKeyboard(activity);
    }


}
