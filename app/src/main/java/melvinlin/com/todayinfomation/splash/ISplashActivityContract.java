package melvinlin.com.todayinfomation.splash;

import melvinlin.com.todayinfomation.mvp.ILifeCircle;
import melvinlin.com.todayinfomation.mvp.IMvpView;
import melvinlin.com.todayinfomation.mvp.MvpController;

public interface ISplashActivityContract {

    interface IView extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
