package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import me.whoarym.daocon.model.Publisher;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "tbl_publisher", indexes = {@Index("mName")})
public class GreenPublisher implements Publisher {

    @Id
    @Property(nameInDb = "_id")
    private long mId;

    @NotNull
    @Property(nameInDb = "name")
    private String mName;

    @Generated(hash = 1639482953)
    public GreenPublisher(long mId, @NotNull String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    @Generated(hash = 978149812)
    public GreenPublisher() {
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
