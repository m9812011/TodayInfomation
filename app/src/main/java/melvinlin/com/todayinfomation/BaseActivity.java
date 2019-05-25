package melvinlin.com.todayinfomation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);

//        if (annotation != null) {
//            int mainLayoutId = annotation.mainlayout();
//            if (annotation != null) {
//                if (mainLayoutId > 0) {
//                    setContentView(mainLayoutId);
//                } else {
//                    throw new RuntimeException("mainlayoutId < 0");
//                }
//            } else {
//                throw new RuntimeException("mainlayoutId = null");
//            }
//        }
        int mainLayoutId = R.layout.activity_main;
        if (mainLayoutId > 0) {
            setContentView(mainLayoutId);
        } else {
            throw new RuntimeException("mainLayoutId < 0");
        }
    }
}
