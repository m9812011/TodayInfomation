package melvinlin.com.todayinfomation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import melvinlin.com.todayinfomation.mvp.view.LifeCircleMvpActivity;
import melvinlin.com.todayinfomation.mvp.view.LifeCircleMvpFragment;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);

        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (annotation != null) {
                if (mainLayoutId > 0) {
                    mView = initFragmentView(inflater, mainLayoutId);
                    bindView(mView);
                    afterBindView();
                } else {
                    throw new RuntimeException("mainLayoutId < 0");
                }
            } else {
                throw new RuntimeException("mainLayoutId = null");
            }
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int mainLayoutId) {
        return inflater.inflate(mainLayoutId, null);
    }

    public abstract void afterBindView();

    // View 的依賴注入綁定
    private void bindView(View view) {
        ButterKnife.bind(this, view);
    }
}
