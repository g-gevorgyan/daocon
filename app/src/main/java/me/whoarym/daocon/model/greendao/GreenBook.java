package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

import me.whoarym.daocon.model.Author;
import me.whoarym.daocon.model.Book;
import me.whoarym.daocon.model.Owner;
import me.whoarym.daocon.model.Publisher;
import me.whoarym.daocon.model.Tag;

@Entity(
        nameInDb = "tbl_book",
        indexes = {
                @Index("mName"),
                @Index("mYear"),
                @Index("mAuthorId"),
                @Index("mPublisherId"),
                @Index("mOwnerId")
        }
)
public class GreenBook implements Book {

    @Id
    @Property(nameInDb = "_id")
    private long mId;

    @NotNull
    @Property(nameInDb = "name")
    private String mName;

    @Property(nameInDb = "annotation")
    private String mAnnotation;

    @NotNull
    @Property(nameInDb = "year")
    private int mYear;

    @SuppressWarnings("unused")
    @NotNull
    @Property(nameInDb = "author_id")
    private long mAuthorId;

    @ToOne(joinProperty = "mAuthorId")
    private GreenAuthor mAuthor;

    @SuppressWarnings("unused")
    @NotNull
    @Property(nameInDb = "publisher_id")
    private long mPublisherId;

    @ToOne(joinProperty = "mPublisherId")
    private GreenPublisher mPublisher;

    @SuppressWarnings("unused")
    @Property(nameInDb = "owner_id")
    private long mOwnerId;

    @ToOne(joinProperty = "mOwnerId")
    private GreenOwner mOwner;

    @ToMany
    @JoinEntity(
            entity = GreenBook2Tag.class,
            sourceProperty = "mBookId",
            targetProperty = "mTagId"
    )
    private List<GreenTag> mTags;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 844514642)
    private transient GreenBookDao myDao;


    @Generated(hash = 1439515538)
    public GreenBook(long mId, @NotNull String mName, String mAnnotation, int mYear,
            long mAuthorId, long mPublisherId, long mOwnerId) {
        this.mId = mId;
        this.mName = mName;
        this.mAnnotation = mAnnotation;
        this.mYear = mYear;
        this.mAuthorId = mAuthorId;
        this.mPublisherId = mPublisherId;
        this.mOwnerId = mOwnerId;
    }

    @Generated(hash = 1722958249)
    public GreenBook() {
    }

    @Generated(hash = 838817518)
    private transient Long mAuthor__resolvedKey;

    @Generated(hash = 548449343)
    private transient Long mPublisher__resolvedKey;

    @Generated(hash = 55125268)
    private transient Long mOwner__resolvedKey;


    @Override
    public int getId() {
        return (int)mId;
    }

    @Override
    public void setId(int id) {
        mId = id;
    }

    @NonNull
    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(@NonNull String name) {
        mName = name;
    }

    @Nullable
    @Override
    public String getAnnotation() {
        return mAnnotation;
    }

    @Override
    public void setAnnotation(@Nullable String annotation) {
        mAnnotation = annotation;
    }

    @Override
    public int getYear() {
        return mYear;
    }

    @Override
    public void setYear(int year) {
        mYear = year;
    }

    public long getAuthorId() {
        return mAuthorId;
    }

    public void setAuthorId(int id) {
        mAuthorId = id;
    }

    @NonNull
    @Override
    public Author getAuthor() {
        return mAuthor;
    }

    @Override
    public void setAuthor(@NonNull Author author) {
        mAuthor = (GreenAuthor) author;
        mAuthorId = (long)mAuthor.getId();
    }

    public long getPublisherId() {
        return mPublisherId;
    }

    public void setPublisherId(int id) {
        mPublisherId = id;
    }

    @NonNull
    @Override
    public Publisher getPublisher() {
        return mPublisher;
    }

    @Override
    public void setPublisher(@NonNull Publisher publisher) {
        mPublisher = (GreenPublisher) publisher;
        mPublisherId = mPublisher.getId();
    }

    @NonNull
    @Override
    public List<? extends Tag> getTags() {
        return mTags;
    }

    @Override
    public void setTags(@NonNull List<? extends Tag> tags) {
        mTags = (List<GreenTag>) tags;
    }

    @Nullable
    public long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(@Nullable Integer id) {
        mOwnerId = id;
    }

    @Nullable
    @Override
    public Owner getOwner() {
        return mOwner;
    }

    @Override
    public void setOwner(@Nullable Owner owner) {
        mOwner = (GreenOwner) owner;
        mOwnerId = owner == null ? null : owner.getId();
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

    public String getMAnnotation() {
        return this.mAnnotation;
    }

    public void setMAnnotation(String mAnnotation) {
        this.mAnnotation = mAnnotation;
    }

    public int getMYear() {
        return this.mYear;
    }

    public void setMYear(int mYear) {
        this.mYear = mYear;
    }

    public long getMAuthorId() {
        return this.mAuthorId;
    }

    public void setMAuthorId(long mAuthorId) {
        this.mAuthorId = mAuthorId;
    }

    public long getMPublisherId() {
        return this.mPublisherId;
    }

    public void setMPublisherId(long mPublisherId) {
        this.mPublisherId = mPublisherId;
    }

    public long getMOwnerId() {
        return this.mOwnerId;
    }

    public void setMOwnerId(long mOwnerId) {
        this.mOwnerId = mOwnerId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1252579903)
    public GreenAuthor getMAuthor() {
        long __key = this.mAuthorId;
        if (mAuthor__resolvedKey == null || !mAuthor__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GreenAuthorDao targetDao = daoSession.getGreenAuthorDao();
            GreenAuthor mAuthorNew = targetDao.load(__key);
            synchronized (this) {
                mAuthor = mAuthorNew;
                mAuthor__resolvedKey = __key;
            }
        }
        return mAuthor;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2105125584)
    public void setMAuthor(@NotNull GreenAuthor mAuthor) {
        if (mAuthor == null) {
            throw new DaoException(
                    "To-one property 'mAuthorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.mAuthor = mAuthor;
            mAuthorId = mAuthor.getMId();
            mAuthor__resolvedKey = mAuthorId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 373533838)
    public GreenPublisher getMPublisher() {
        long __key = this.mPublisherId;
        if (mPublisher__resolvedKey == null
                || !mPublisher__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GreenPublisherDao targetDao = daoSession.getGreenPublisherDao();
            GreenPublisher mPublisherNew = targetDao.load(__key);
            synchronized (this) {
                mPublisher = mPublisherNew;
                mPublisher__resolvedKey = __key;
            }
        }
        return mPublisher;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 164998909)
    public void setMPublisher(@NotNull GreenPublisher mPublisher) {
        if (mPublisher == null) {
            throw new DaoException(
                    "To-one property 'mPublisherId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.mPublisher = mPublisher;
            mPublisherId = mPublisher.getMId();
            mPublisher__resolvedKey = mPublisherId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1232189347)
    public GreenOwner getMOwner() {
        long __key = this.mOwnerId;
        if (mOwner__resolvedKey == null || !mOwner__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GreenOwnerDao targetDao = daoSession.getGreenOwnerDao();
            GreenOwner mOwnerNew = targetDao.load(__key);
            synchronized (this) {
                mOwner = mOwnerNew;
                mOwner__resolvedKey = __key;
            }
        }
        return mOwner;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 621016733)
    public void setMOwner(@NotNull GreenOwner mOwner) {
        if (mOwner == null) {
            throw new DaoException(
                    "To-one property 'mOwnerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.mOwner = mOwner;
            mOwnerId = mOwner.getMId();
            mOwner__resolvedKey = mOwnerId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1609196562)
    public List<GreenTag> getMTags() {
        if (mTags == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GreenTagDao targetDao = daoSession.getGreenTagDao();
            List<GreenTag> mTagsNew = targetDao._queryGreenBook_MTags(mId);
            synchronized (this) {
                if (mTags == null) {
                    mTags = mTagsNew;
                }
            }
        }
        return mTags;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1390731565)
    public synchronized void resetMTags() {
        mTags = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1246079715)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGreenBookDao() : null;
    }
}
