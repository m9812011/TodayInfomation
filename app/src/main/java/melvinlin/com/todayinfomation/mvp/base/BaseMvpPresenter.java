package melvinlin.com.todayinfomation.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import melvinlin.com.todayinfomation.mvp.IMvpView;
import melvinlin.com.todayinfomation.mvp.presenter.LifeCircleMvpPresenter;

/**
 * p層的中間類
 * 1.實現一些抽象方法，不用具體的類去做
 * 2.getEmptyView()不做，讓子類去做
 * @param <T>
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    //TODO:
    public BaseMvpPresenter(T view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
