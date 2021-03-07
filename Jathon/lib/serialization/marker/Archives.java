package Jathon.lib.serialization.marker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Archives
{

    Archive[] value();

}
