package shaz.mvpsimplesample.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public class AppTaskExecutor implements TaskExecutor {
    private final WeakReference<Activity> mActivityWeakReference;

    public AppTaskExecutor(@NonNull final Activity activity) {
        this.mActivityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public <T> void async(@NonNull AppTask<T> task) {
        new ExecutorAsyncTask<>(task);
    }

    private class ExecutorAsyncTask<R> extends AsyncTask<Void, Void, R> {

        private AppTask<R> mTask;

        public ExecutorAsyncTask(AppTask task) {
            this.mTask = task;
        }

        @Override
        protected void onPreExecute() {
            mTask.onTaskPreExecute();
        }

        @Override
        protected R doInBackground(Void... voids) {
            return mTask.execute();
        }

        @Override
        protected void onPostExecute(R r) {
            if (activityNotFinished())
                mTask.onTaskCompleted(r);
        }

        private boolean activityNotFinished() {
            final Activity activity = mActivityWeakReference.get();
            return activity != null && !activity.isFinishing();
        }
    }
}
