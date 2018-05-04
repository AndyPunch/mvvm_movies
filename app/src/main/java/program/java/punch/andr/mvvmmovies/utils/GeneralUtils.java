package program.java.punch.andr.mvvmmovies.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class GeneralUtils {

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService
                (Activity.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken
                    (), 0);
        }
    }
}
