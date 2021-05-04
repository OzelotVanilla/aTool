package lib.Jathon;

import static lib.Jathon.builtin.*;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;
import java.math.BigInteger;

/**
 * <p>
 * {@code lib.Jathon.Fecha} ({@code Fecha}) は，Javaの従来の時間と関連する類(Class)と型(Type)を統合し，より使いやすいと機能が多い型です。
 * </p>
 *
 * <p>
 * {@code Fecha}型の物(Object)を作るには，構造関数{@code Fecha(Date)}や{@code Fecha(long timestamp)}を使うで十分。<br>
 * だだし，{@code type}が指定されない場合は{@code type=point}として見る(既定値)。
 * </p>
 *
 * <p>
 * The class <code>Fecha</code> can be seen as an enhanced version of original <code>java.util.Date</code>.
 * </p>
 *
 * @author Ozelot Vanilla
 * @author Sean Yu
 * @since 1.16
 */
public class Fecha implements Externalizable, Cloneable, Comparable<Fecha>
{
    /**
     * <p>
     * First update of {@code Fecha}.
     * </p>
     */
    public final String $version = "0.2.6.0";

    /**
     * <p>
     * {@code type}は{@code Fecha}の型です。
     * </p>
     * <p>
     * Save the type of Fecha object. It can be a special point of time, or a period of time. If you assign it as
     * {@code now}, it will only mark it is present time, and not saving time in {@code value}.
     * </p>
     */
    enum type
    {
        point, period, now
    }

    enum prop
    {
        year, month, day, hour, minute, second, timezone
    }

    private type value_type;

    private ZoneId zone_info;

    /**
     * Save the value of time. It can mean point of time, or a period of time according to {@code type}.
     */
    private BigInteger value;

    public final String $default_format = "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`";

    /**
     * <p>
     * {@code format}は{@code Fecha}の表現形式を制御します。<br>
     * "格式化情報提供子" (格式提供子) と言います。 <br>
     * 既定値は{@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss` `UTC`"}です。
     * </p>
     *
     * @see #setFormat(String)
     */
    private String format;


    public Fecha()
    {
        // TODO Empty constructor to be filled
    }

    public Fecha(Date date)
    {
        // TODO Empty constructor to be filled
        this(type.point, date.getTime());
    }

    public Fecha(long timestamp)
    {
        // TODO Empty constructor to be filled
        this(type.point, timestamp);
    }

    public Fecha(type t, long value)
    {
        this(t, ZoneId.systemDefault(), new BigInteger(str(value)), "`default`");
    }

    public Fecha(ZoneId zi, long value)
    {
        this(type.point, zi, new BigInteger(str(value)), "`default`");
    }

    public Fecha(type t, ZoneId zi, BigInteger value, String format)
    {
        this.value_type = t;
        this.zone_info = (value_type == type.point || value_type == type.now) ? zi : null;
        this.value = t == type.now ? null : value;
        this.format = format;
    }


    @Override
    public int compareTo(Fecha o)
    {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        // TODO Auto-generated method stub

    }

    /**
     * <p>
     * {@code setFormat}は，{@code Fecha}の表現形式を制御する格式提供子{@link Fecha#format}を設定する関数です。<br>
     * "格式化(かくしきか)設定関数"とも言います。
     * </p>
     * <p>
     * 使い方は，表現したいのものを，下記のリストを参照し，backquote (`)で囲む，{@code format}の中に置きてください。
     * </p>
     * <p>
     * 例えば，"月(2位)-日(2位)-年(4位)"のような格式化された文字列をほしいなら，"`MM`-`DD`-`YYYY`"
     * </p>
     * <p>
     * 使える引数
     * <table>
     * <th>
     * <td>Placeholder</td>
     * <td>説明</td></th>
     * <tr>
     * </tr>
     * </table>
     * </p>
     * <p>
     * {@code format}の既定値は{@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`"}です。
     * </p>
     * Save the format of formatted output. By default, it is {@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`"}
     *
     * @param fmt 置き換えたい新しい
     */
    public void setFormat(String fmt)
    {
        this.format = fmt;
    }
}