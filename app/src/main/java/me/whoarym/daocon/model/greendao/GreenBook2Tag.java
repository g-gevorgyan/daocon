package me.whoarym.daocon.model.greendao;


import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import me.whoarym.daocon.model.Book;
import me.whoarym.daocon.model.Tag;

@Entity(
        nameInDb = "tbl_book2tag",
        indexes = {@Index(value = "mBookId, mTagId", unique = true)}
)
public class GreenBook2Tag {

    public GreenBook2Tag() {
    }

    public GreenBook2Tag(@NonNull Book book, @NonNull Tag tag) {
        mBookId = book.getId();
        mTagId = tag.getId();
    }

    @Generated(hash = 1793096811)
    public GreenBook2Tag(long mBookId, long mTagId) {
        this.mBookId = mBookId;
        this.mTagId = mTagId;
    }

    @NotNull
    @Property(nameInDb = "book_id")
    private long mBookId;

    @NotNull
    @Property(nameInDb = "tag_id")
    private long mTagId;

    public long getBookId() {
        return mBookId;
    }

    public void setBookId(int id) {
        mBookId = id;
    }

    public long getTagId() {
        return mTagId;
    }

    public void setTagId(int id) {
        mTagId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GreenBook2Tag that = (GreenBook2Tag) o;

        if (mBookId != that.mBookId) return false;
        return mTagId == that.mTagId;
    }

    @Override
    public int hashCode() {
        long result = mBookId;
        result = 31 * result + mTagId;
        return (int)result;
    }

    public long getMBookId() {
        return this.mBookId;
    }

    public void setMBookId(long mBookId) {
        this.mBookId = mBookId;
    }

    public long getMTagId() {
        return this.mTagId;
    }

    public void setMTagId(long mTagId) {
        this.mTagId = mTagId;
    }
}
