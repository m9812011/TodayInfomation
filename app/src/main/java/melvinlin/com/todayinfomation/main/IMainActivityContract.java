package melvinlin.com.todayinfomation.main;

import android.support.v4.app.Fragment;

import melvinlin.com.todayinfomation.mvp.ILifeCircle;
import melvinlin.com.todayinfomation.mvp.IMvpView;
import melvinlin.com.todayinfomation.mvp.MvpController;

public interface IMainActivityContract {

    interface IView extends IMvpView {

        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentCheckedId();

        void replaceFragment(int mCurrentFragmentIndex);

        int getCurrentCheckedIndex();

        int getTopPosition();

        int getBottomPosition();
    }


    IView emptyView = new IView() {

        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
