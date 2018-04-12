package shaz.mvpsimplesample.offer;

import android.support.annotation.NonNull;

import java.util.List;

import shaz.mvpsimplesample.model.Product;
import shaz.mvpsimplesample.task.AppTask;
import shaz.mvpsimplesample.task.TaskExecutor;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public class OfferPresenter extends BasePresenter {
    private OfferView mView;
    private TaskExecutor mTaskExecutor;

    public OfferPresenter(@NonNull final OfferView view, @NonNull final TaskExecutor taskExecutor) {
        this.mView = view;
        this.mTaskExecutor = taskExecutor;
    }

    @Override
    void onResume() {
        super.onResume();
        fetchProducts();
    }

    protected void fetchProducts() {
        mTaskExecutor.async(new GetRemoteProducts());
    }

    void unlikeProduct() {
        mView.unlikeProduct();
    }

    void likeProduct() {
        mView.likeProduct();
    }

    private class GetRemoteProducts implements AppTask<List<Product>> {

        @Override
        public void onTaskPreExecute() {
            mView.showProgress();
        }

        @Override
        public List<Product> execute() {
            return null;
        }

        @Override
        public void onTaskCompleted(@NonNull List<Product> result) {
            mView.hideProgress();
        }
    }
}
