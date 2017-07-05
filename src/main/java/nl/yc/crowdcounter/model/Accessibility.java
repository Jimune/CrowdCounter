package nl.yc.crowdcounter.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jim on 6/26/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Accessibility {

    boolean requireLogin() default true;
    String[] requiredPermissions() default {};

}
