package melvinlin.com.todayinfomation.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;


/**
 * 自定义view => VideoView
 * videoview的全屏问题：videoview会根据视频文件的大小来改变自身的大小，所以要自定义view。
 */
public class FullScreenVideoView extends VideoView {

    //主要用於這個直接new出來的對象
    public FullScreenVideoView(Context context) {
        super(context);
    }

    //主要用於xml文件中，支持自定義屬性
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //主要用於xml文件中，支持自定義屬性，同時支持style主題
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //原本的有問題，不做
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //widthMeasureSpec 包含兩個主要的內容：1.測量模式  2.測量大小
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        //設定測量尺寸
        setMeasuredDimension(width, height);
    }
}
