package me.whoarym.daocon;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.database.Database;

import me.whoarym.daocon.model.greendao.DaoMaster;
import me.whoarym.daocon.model.greendao.DaoSession;
import me.whoarym.daocon.model.room.RoomDaoDatabase;
import me.whoarym.daocon.model.sqlite.SqLiteHelper;

public class DaoconApp extends Application {

    @NonNull
    private SqLiteHelper mSqLiteHelper;

    @NonNull
    private RoomDaoDatabase mRoomDb;

    @NonNull
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        mSqLiteHelper = new SqLiteHelper(this);
        mRoomDb = Room.databaseBuilder(this, RoomDaoDatabase.class, "room.db").build();

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "greendao.db", null);
        Database db = devOpenHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    @NonNull
    public SQLiteDatabase getSqLiteDb() {
        return mSqLiteHelper.getWritableDatabase();
    }

    @NonNull
    public RoomDaoDatabase getRoomDb() {
        return mRoomDb;
    }


    @NonNull
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
