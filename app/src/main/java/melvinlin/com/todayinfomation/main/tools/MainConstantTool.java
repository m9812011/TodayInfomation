package melvinlin.com.todayinfomation.main.tools;


import android.support.annotation.IntDef;

import static melvinlin.com.todayinfomation.main.tools.MainConstantTool.BEIJING;
import static melvinlin.com.todayinfomation.main.tools.MainConstantTool.HANGZHOU;
import static melvinlin.com.todayinfomation.main.tools.MainConstantTool.SHANGHAI;
import static melvinlin.com.todayinfomation.main.tools.MainConstantTool.SHENZHEN;

@IntDef({SHANGHAI, HANGZHOU, BEIJING, SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
