package melvinlin.com.todayinfomation.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * 中介者 設定模式
 * 透過基類自動調取方法
 */
public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    //Fragment
    void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    //Fragment
    void onDestroyView();

    //Fragment
    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle outState);

    //Fragment
    void attachView(IMvpView iMvpView);
}
