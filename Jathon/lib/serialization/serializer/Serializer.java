package Jathon.lib.serialization.serializer;

import java.nio.ByteBuffer;

public abstract class Serializer<T>
{

    private final String typeName;

    protected Serializer(String typeName)
    {
        this.typeName = typeName;
    }

    protected String getType()
    {
        return typeName;
    }

    protected abstract boolean serialize(ByteBuffer dest, T src);

    protected abstract boolean deserialize(ByteBuffer src, T dest);

}
