package shaz.mvpsimplesample.task;

import android.support.annotation.NonNull;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public interface AppTask<T> {
    void onTaskPreExecute();

    T execute();

    void onTaskCompleted(@NonNull final T result);
}
