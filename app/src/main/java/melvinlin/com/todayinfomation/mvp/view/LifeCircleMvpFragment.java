package melvinlin.com.todayinfomation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import melvinlin.com.todayinfomation.mvp.IMvpView;
import melvinlin.com.todayinfomation.mvp.MvpController;

/**
 * 代理類
 */
public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {

        if (mvpController == null) {
            this.mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透過靜態代理獲取
        Bundle bundle = this.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onCreate(savedInstanceState, null, bundle);
            mvpController.onActivityCreated(savedInstanceState, null, bundle);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }

        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onActivityCreated(savedInstanceState, null, bundle);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Bundle bundle = this.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }

        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onDestroyView();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null) {
            mvpController.onActivityResult(requestCode, resultCode, data);
        }
    }
}
