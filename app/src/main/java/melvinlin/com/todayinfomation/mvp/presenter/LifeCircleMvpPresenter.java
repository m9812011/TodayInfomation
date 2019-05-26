package melvinlin.com.todayinfomation.mvp.presenter;

import java.lang.ref.WeakReference;

import melvinlin.com.todayinfomation.mvp.ILifeCircle;
import melvinlin.com.todayinfomation.mvp.IMvpView;
import melvinlin.com.todayinfomation.mvp.MvpController;

/**
 * 基本類
 *
 * @param <T>
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);

    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null) {
            weakReference = new WeakReference(iMvpView);
        } else {
            T view = (T)weakReference.get();
            if (view != iMvpView) {
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    //上層獲取V層引用
    protected T getView(){
        T view = weakReference != null ? (T)weakReference.get(): null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
    }

    //讓子類自己去實現
    protected abstract T getEmptyView();
}
