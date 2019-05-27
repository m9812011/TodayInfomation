package melvinlin.com.todayinfomation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import melvinlin.com.todayinfomation.mvp.view.LifeCircleMvpActivity;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);

        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (annotation != null) {
                if (mainLayoutId > 0) {
                    setContentView(mainLayoutId);
                    bindView();
                    afterBindView();
                } else {
                    throw new RuntimeException("mainLayoutId < 0");
                }
            } else {
                throw new RuntimeException("mainLayoutId = null");
            }
        }
    }

    public abstract void afterBindView();

    // View 的依賴注入綁定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
