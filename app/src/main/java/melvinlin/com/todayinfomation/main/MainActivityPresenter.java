package melvinlin.com.todayinfomation.main;

import android.support.v4.app.Fragment;

import melvinlin.com.todayinfomation.R;
import melvinlin.com.todayinfomation.base.BaseActivity;
import melvinlin.com.todayinfomation.main.beijing.BeijingFragment;
import melvinlin.com.todayinfomation.main.hangzhow.HangZhowFragment;
import melvinlin.com.todayinfomation.main.shanghai.ShangHaiFragment;
import melvinlin.com.todayinfomation.main.shenzhen.ShenZhenFragment;
import melvinlin.com.todayinfomation.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {

    private int mCurrentFragmentIndex; // 當前Fragment索引
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }

    @Override
    public void replaceFragment(int currentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (currentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment fragment = mFragments[currentFragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
            setCurChecked(currentFragmentIndex);
        } else {
            newCurrentFragment(currentFragmentIndex);
            setCurChecked(currentFragmentIndex);
        }
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    private void setCurChecked(int currentIndex) {
        this.mCurrentFragmentIndex = currentIndex;
        switch (currentIndex) {
            case 0:
                mCurrentCheckedId = R.id.rb_main_shanghai;
                mTopPosition = 0;
                break;
            case 1:
                mCurrentCheckedId = R.id.rb_main_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                mCurrentCheckedId = R.id.rb_main_nav_home_beijing;
                mBottomPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = R.id.rb_main_nav_car_source_shenzhen;
                mBottomPosition = 3;
                break;
        }

    }

    private void newCurrentFragment(int currentFragmentIndex) {
        Fragment fragment = null;
        switch (currentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhowFragment();
                break;
            case 2:
                fragment = new BeijingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }

        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);

    }

    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()) {
            getView().showFragment(fragment);
        } else {
            getView().addFragment(fragment);
        }
    }

    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }

}



