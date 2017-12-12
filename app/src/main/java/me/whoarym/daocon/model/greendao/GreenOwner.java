package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import me.whoarym.daocon.model.Owner;

@Entity(nameInDb = "tbl_owner")
public class GreenOwner implements Owner {

    @Id
    @Property(nameInDb = "_id")
    private long mId;

    @NotNull
    @Property(nameInDb = "first_name")
    private String mFirstName;

    @NotNull
    @Property(nameInDb = "last_name")
    private String mLastName;

    @Generated(hash = 369339378)
    public GreenOwner(long mId, @NotNull String mFirstName,
            @NotNull String mLastName) {
        this.mId = mId;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    @Generated(hash = 560357959)
    public GreenOwner() {
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
    public String getFirstName() {
        return mFirstName;
    }

    @Override
    public void setFirstName(@NonNull String firstName) {
        mFirstName = firstName;
    }

    @Override
    public String getLastName() {
        return mLastName;
    }

    @Override
    public void setLastName(@NonNull String lastName) {
        mLastName = lastName;
    }

    public long getMId() {
        return this.mId;
    }

    public void setMId(long mId) {
        this.mId = mId;
    }

    public String getMFirstName() {
        return this.mFirstName;
    }

    public void setMFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getMLastName() {
        return this.mLastName;
    }

    public void setMLastName(String mLastName) {
        this.mLastName = mLastName;
    }

}
