package shaz.mvpsimplesample.offer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.List;

import shaz.mvpsimplesample.R;
import shaz.mvpsimplesample.base.BaseActivity;
import shaz.mvpsimplesample.model.Product;
import shaz.mvpsimplesample.task.AppTaskExecutor;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public class OfferActivity extends BaseActivity<OfferPresenter> implements OfferView {

    private CardStackView mCardStackView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        mCardStackView = findViewById(R.id.card_stack_view);
    }

    @NonNull
    @Override
    protected OfferPresenter createPresenter(@NonNull Context context) {
        return new OfferPresenter(this, new AppTaskExecutor(this));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProducts(List<Product> products) {

    }

    @Override
    public void unlikeProduct() {

    }

    @Override
    public void likeProduct() {

    }

    @Override
    public void updateCart(int productCount) {

    }
}
