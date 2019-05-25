package melvinlin.com.todayinfomation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);

        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (annotation != null) {
                if (mainLayoutId > 0) {
                    setContentView(mainLayoutId);
                    ButterKnife.bind(this);
                } else {
                    throw new RuntimeException("mainLayoutId < 0");
                }
            } else {
                throw new RuntimeException("mainLayoutId = null");
            }
        }
    }
}
