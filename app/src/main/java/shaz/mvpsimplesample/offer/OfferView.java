package shaz.mvpsimplesample.offer;

import java.util.List;

import shaz.mvpsimplesample.base.BaseView;
import shaz.mvpsimplesample.model.Product;

/**
 * Created by ${Shahbaz} on 21-02-2018
 */

public interface OfferView extends BaseView {
    void showProducts(List<Product> products);
    void unlikeProduct();
    void likeProduct();
    void updateCart(int productCount);
}
