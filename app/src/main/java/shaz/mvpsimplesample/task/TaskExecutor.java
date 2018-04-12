package shaz.mvpsimplesample.task;

import android.support.annotation.NonNull;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public interface TaskExecutor {
    <T> void async(@NonNull final AppTask<T> task);
}
