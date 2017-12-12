package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import me.whoarym.daocon.model.Author;
import me.whoarym.daocon.model.Book;
import me.whoarym.daocon.model.ModelFactory;
import me.whoarym.daocon.model.Owner;
import me.whoarym.daocon.model.Publisher;
import me.whoarym.daocon.model.Tag;
import me.whoarym.daocon.model.room.RoomAuthor;
import me.whoarym.daocon.model.room.RoomBook;
import me.whoarym.daocon.model.room.RoomOwner;
import me.whoarym.daocon.model.room.RoomPublisher;
import me.whoarym.daocon.model.room.RoomTag;

public class GreenModelFactory implements ModelFactory {
    @NonNull
    @Override
    public Author createAuthor() {
        return new GreenAuthor();
    }

    @NonNull
    @Override
    public Publisher createPublisher() {
        return new GreenPublisher();
    }

    @NonNull
    @Override
    public Owner createOwner() {
        return new GreenOwner();
    }

    @NonNull
    @Override
    public Tag createTag() {
        return new GreenTag();
    }

    @NonNull
    @Override
    public Book createBook() {
        return new GreenBook();
    }
}
