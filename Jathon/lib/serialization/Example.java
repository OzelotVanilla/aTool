package Jathon.lib.serialization;

import Jathon.lib.serialization.marker.Archive;
import Jathon.lib.serialization.marker.Serializable;
import Jathon.lib.serialization.marker.Tag;

import java.util.Map;
import java.util.TreeMap;

@Tag({"ud:blockID", "ud:data"})
@Tag({"ud:reflector"})
@Tag({"ud:domain", "ud:mid", "ud:name"})

@Archive(departedTagName = "mc:block")
@Archive(departedTagName = "ud:tile")
@Serializable(typeName = "ud:block")
public class Example
{

    private int dataInt;
    @Tag.Getter(tags = {"ud:blockID"})
    public int getDataInt()
    {
        return dataInt;
    }
    @Tag.Setter(tags = {"ud:blockID"})
    public void setDataInt(int dataInt)
    {
        this.dataInt = dataInt;
    }

    @Tag.Setter(tags = {"ud:data"})
    @Tag.Getter(tags = {"ud:data"})
    private int dataLong;

    @Tag.Setter(tags = {"ud:reflector"}, specificType = {"java.util:TreeMap"})
    @Tag.Getter(tags = {"ud:reflector"})
    private Map<String, String> dataMap;

    @Tag.Getter(tags = {"ud:domain", "ud:name"})
    private String[] getLocation()
    {
        return new String[]{"block", "air"};
    }

    @Tag.Getter(tags = {"ud:mid"})
    private String getMidName()
    {
        return "classic";
    }

    @Tag.Getter(tags = {"ud:domain", "ud:mid", "ud:name"})
    private void setNames(String domain, String mid, String name)
    {

    }
}
