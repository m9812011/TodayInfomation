package melvinlin.com.todayinfomation.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.OnClick;
import melvinlin.com.todayinfomation.R;
import melvinlin.com.todayinfomation.base.BaseActivity;
import melvinlin.com.todayinfomation.base.ViewInject;
import melvinlin.com.todayinfomation.main.tools.MainConstantTool;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);
    @BindView(R.id.facMainHome)
    FloatingActionButton facMainHome;
    @BindView(R.id.fl_main_bottom)
    FrameLayout fl_main_bottom;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.rb_main_shanghai)                //上海
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)                //廣州
    RadioButton rbMainHangzhou;
    @BindView(R.id.rb_main_nav_home_beijing)        //北京
    RadioButton rb_main_nav_home_beijing;
    @BindView(R.id.rb_main_nav_car_source_shenzhen) //深圳
    RadioButton rb_main_nav_car_source_shenzhen;

    private boolean isChangeTopOrBottom;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        changeAnimation(rg_main_bottom, rg_main_top);
//    }

    /**
     * 模板方法 設計模式
     */
    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnimation(rgMainBottom, rgMainTop);
        initCheckListener();
    }

    private void initCheckListener() {
        rbMainShanghai.setChecked(true);
        rgMainTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_shanghai:
                        mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                        break;
                    case R.id.rb_main_hangzhou:
                        mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                        break;
                }
            }
        });

        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_nav_home_beijing:
                        mPresenter.replaceFragment(MainConstantTool.BEIJING);
                        break;
                    case R.id.rb_main_nav_car_source_shenzhen:
                        mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                        break;
                }
            }
        });
    }

    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.facMainHome)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.facMainHome:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnimation(rgMainTop, rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnimation(rgMainBottom, rgMainTop);
                    handleBottomPosition();
                }
                break;
        }
    }

    // 北京 深圳
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != 1) {
            mPresenter.replaceFragment(0);
            rbMainShanghai.setChecked(true);
//            rb_main_nav_car_source_shenzhen.pauseAnimation();
        } else {
            mPresenter.replaceFragment(1);
            rbMainHangzhou.setChecked(true);
//            rb_main_hangzhou.playAnimation();
        }
    }

    // 上海 杭州
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != 3) {
            mPresenter.replaceFragment(2);
            rb_main_nav_home_beijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(3);
            rb_main_nav_car_source_shenzhen.setChecked(true);
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


    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, fragment).commit();

    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }
}
