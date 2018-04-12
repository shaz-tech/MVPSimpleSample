package shaz.mvpsimplesample.offer;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public abstract class BasePresenter {

    @CallSuper
    void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @CallSuper
    void onStart() {

    }

    @CallSuper
    void onResume() {

    }

    @CallSuper
    void onPause() {

    }

    @CallSuper
    void onDestroy() {

    }

    @CallSuper
    void onSaveInstanceState(Bundle outState) {

    }

    @CallSuper
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
