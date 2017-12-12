package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import me.whoarym.daocon.model.Tag;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "tbl_tag", indexes = {@Index(value = "mName", unique = true)})
public class GreenTag implements Tag {

    @Id
    @Property(nameInDb = "_id")
    private long mId;

    @NotNull
    @Property(nameInDb = "name")
    private String mName;

    @Generated(hash = 2063648827)
    public GreenTag(long mId, @NotNull String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    @Generated(hash = 29375570)
    public GreenTag() {
    }

    @Override
    public int getId() {
        return (int)mId;
    }

    @Override
    public void setId(int id) {
        mId = id;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(@NonNull String name) {
        mName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GreenTag greenTag = (GreenTag) o;

        if (mId != greenTag.mId) return false;
        return mName.equals(greenTag.mName);
    }

    @Override
    public int hashCode() {
        int result = (int)mId;
        result = 31 * result + mName.hashCode();
        return result;
    }

    public long getMId() {
        return this.mId;
    }

    public void setMId(long mId) {
        this.mId = mId;
    }

    public String getMName() {
        return this.mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }
}
