package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.whoarym.daocon.model.Author;
import me.whoarym.daocon.model.Book;
import me.whoarym.daocon.model.Dao;
import me.whoarym.daocon.model.Owner;
import me.whoarym.daocon.model.Publisher;
import me.whoarym.daocon.model.Tag;
import me.whoarym.daocon.model.json.JsonDataContainer;

/**
 * Created by garnik on 12.12.17.
 */

public class GreenDao implements Dao {

    @NonNull
    private final GreenSimpleDao mSimpleDao;

    public GreenDao(@NonNull GreenSimpleDao simpleDao) {
        mSimpleDao = simpleDao;
    }

    @NonNull
    @Override
    public String getName() {
        return "Green Dao";
    }

    @Override
    public void importData(@NonNull JsonDataContainer dataContainer) {
        Set<GreenBook2Tag> greenBook2Tags = new HashSet<>();
        for (Book book : dataContainer.getBooks()) {
            for (Tag tag : book.getTags()) {
                greenBook2Tags.add(new GreenBook2Tag(book, tag));
            }
            // simple hack to update author and publisher ids
            book.setAuthor(book.getAuthor());
            book.setPublisher(book.getPublisher());
        }

        mSimpleDao.insertAll(
                (List<GreenOwner>) dataContainer.getOwners(),
                (List<GreenAuthor>) dataContainer.getAuthors(),
                (List<GreenPublisher>) dataContainer.getPublishers(),
                (List<GreenTag>) dataContainer.getTags(),
                (List<GreenBook>) dataContainer.getBooks(),
                new ArrayList<>(greenBook2Tags)
        );
    }

    @Override
    public void clearData() {
        mSimpleDao.deleteAll();
    }

    @NonNull
    @Override
    public List<? extends Author> getAuthors() {
        return mSimpleDao.getAuthors();
    }

    @NonNull
    @Override
    public List<? extends Publisher> getPublishers() {
        return mSimpleDao.getPublishers();
    }

    @NonNull
    @Override
    public List<? extends Owner> getOwners() {
        return mSimpleDao.getOwners();
    }

    @NonNull
    @Override
    public List<? extends Tag> getTags() {
        return mSimpleDao.getTags();
    }

    @NonNull
    @Override
    public List<? extends Book> getBooks() {
        return mSimpleDao.getBooks();
    }

    @NonNull
    @Override
    public List<? extends Book> getBooksByAuthor(@NonNull Author author) {
        return mSimpleDao.getBooksByAuthor(author);
    }

    @NonNull
    @Override
    public List<? extends Book> getBooksByPublisher(@NonNull Publisher publisher) {
        return mSimpleDao.getBooksByPublisher(publisher);
    }

    @NonNull
    @Override
    public List<? extends Book> getBooksByOwner(@NonNull Owner owner) {
        return mSimpleDao.getBooksByOwner(owner);
    }

    @Override
    public void saveAuthor(@NonNull Author author) {
        mSimpleDao.insertAuthor((GreenAuthor) author);
    }

    @Override
    public void savePublisher(@NonNull Publisher publisher) {
        mSimpleDao.insertPublisher((GreenPublisher) publisher);
    }

    @Override
    public void saveOwner(@NonNull Owner owner) {
        mSimpleDao.insertOwner((GreenOwner) owner);
    }

    @Override
    public void saveTag(@NonNull Tag tag) {
        mSimpleDao.insertTag((GreenTag) tag);
    }

    @Override
    public void saveBook(@NonNull Book book) {
        mSimpleDao.insertBook((GreenBook) book);
    }
}
