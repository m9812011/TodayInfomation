package melvinlin.com.todayinfomation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME) //運行時 註解
@Target(TYPE)      //類接口 註解
public @interface ViewInject {
    int mainlayout() default -1;
}
