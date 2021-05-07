package Jathon.lib.serialization.marker;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Tag.Tags.class)
public @interface Tag
{

    String[] value();

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Setter
    {

        String[] tags();

        String[] specificType() default {};

    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Getter
    {

        String[] tags();

    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Tags
    {

        Tag[] value();

    }

}
