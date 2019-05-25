package melvinlin.com.todayinfomation;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.facMainHome)
    FloatingActionButton facMainHome;
    @BindView(R.id.fl_main_bottom)
    FrameLayout fl_main_bottom;
    @BindView(R.id.rg_main_top)
    RadioGroup rg_main_top;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rg_main_bottom;
    @BindView(R.id.rb_main_shanghai)                //上海
    RadioButton rb_main_shanghai;
    @BindView(R.id.rb_main_hangzhou)                //廣州
    RadioButton rb_main_hangzhou;
    @BindView(R.id.rb_main_nav_home_beijing)        //北京
    RadioButton rb_main_nav_home_beijing;
    @BindView(R.id.rb_main_nav_car_source_shenzhen) //深圳
    RadioButton rb_main_nav_car_source_shenzhen;

    private boolean isChangeTopOrBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnimation(rg_main_bottom, rg_main_top);
    }

    @OnClick(R.id.facMainHome)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.facMainHome:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnimation(rg_main_top, rg_main_bottom);
                } else {
                    changeAnimation(rg_main_bottom, rg_main_top);
                }
                break;
        }
    }

    private void changeAnimation(RadioGroup gone, RadioGroup show) {
        //消失的動畫
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        //展示的動畫
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.setAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }


}
