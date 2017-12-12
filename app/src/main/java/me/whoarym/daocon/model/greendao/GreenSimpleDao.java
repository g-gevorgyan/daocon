package me.whoarym.daocon.model.greendao;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

import me.whoarym.daocon.model.Author;
import me.whoarym.daocon.model.Owner;
import me.whoarym.daocon.model.Publisher;
import me.whoarym.daocon.model.Tag;

public class GreenSimpleDao {

    private GreenAuthorDao    mGreenAuthorDao;
    private GreenBookDao      mGreenBookDao;
    private GreenBook2TagDao  mGreenBook2TagDao;
    private GreenOwnerDao     mGreenOwnerDao;
    private GreenPublisherDao mGreenPublisherDao;
    private GreenTagDao       mGreenTagDao;

    public GreenSimpleDao(GreenAuthorDao greenAuthorDao,
                          GreenBookDao greenBookDao,
                          GreenBook2TagDao greenBook2TagDao,
                          GreenOwnerDao greenOwnerDao,
                          GreenPublisherDao greenPublisherDao,
                          GreenTagDao greenTagDao) {
        mGreenAuthorDao = greenAuthorDao;
        mGreenBookDao = greenBookDao;
        mGreenBook2TagDao = greenBook2TagDao;
        mGreenOwnerDao = greenOwnerDao;
        mGreenPublisherDao = greenPublisherDao;
        mGreenTagDao = greenTagDao;
    }

    ///////////////////////////////////////////////////////////////////////////
    // insert section
    ///////////////////////////////////////////////////////////////////////////
    public void insertOwners(@NonNull List<GreenOwner> owners) {
        mGreenOwnerDao.insertInTx(owners);
    }

    public void insertAuthors(@NonNull List<GreenAuthor> authors) {
        mGreenAuthorDao.insertInTx(authors);
    }

    public void insertPublishers(@NonNull List<GreenPublisher> publishers) {
        mGreenPublisherDao.insertInTx(publishers);
    }

    public void insertTags(@NonNull List<GreenTag> tags) {
        mGreenTagDao.insertInTx(tags);
    }

    public void insertBooks(@NonNull List<GreenBook> books) {
        mGreenBookDao.insertInTx(books);
    }

    public void insertBookTagLinks(@NonNull List<GreenBook2Tag> book2Tag) {
        mGreenBook2TagDao.insertInTx(book2Tag);
    }

    public void insertAll(@NonNull List<GreenOwner> owners,
                          @NonNull List<GreenAuthor> authors,
                          @NonNull List<GreenPublisher> publishers,
                          @NonNull List<GreenTag> tags,
                          @NonNull List<GreenBook> books,
                          @NonNull List<GreenBook2Tag> book2Tag) {
        insertOwners(owners);
        insertAuthors(authors);
        insertPublishers(publishers);
        insertTags(tags);
        insertBooks(books);
        insertBookTagLinks(book2Tag);
    }

    public void insertAuthor(@NonNull GreenAuthor author) {
        mGreenAuthorDao.insertOrReplace(author);
    }

    public void insertOwner(@NonNull GreenOwner owner) {
        mGreenOwnerDao.insertOrReplace(owner);
    }

    public void insertPublisher(@NonNull GreenPublisher publisher) {
        mGreenPublisherDao.insertOrReplace(publisher);
    }

    public void insertTag(@NonNull GreenTag tag) {
        mGreenTagDao.insertOrReplace(tag);
    }

    ///////////////////////////////////////////////////////////////////////////
    // delete section
    ///////////////////////////////////////////////////////////////////////////
    public void clearAuthors() {
        mGreenAuthorDao.deleteAll();
    }

    public void clearBooks() {
        mGreenBookDao.deleteAll();
    }

    public void clearBook2Tag() {
        mGreenBook2TagDao.deleteAll();
    }

    public void clearOwners() {
        mGreenOwnerDao.deleteAll();
    }

    public void clearPublishers() {
        mGreenPublisherDao.deleteAll();
    }

    public void clearTags() {
        mGreenTagDao.deleteAll();
    }

    public void deleteAll() {
        mGreenBookDao.getSession().callInTxNoException(() -> {
            clearBook2Tag();
            clearBooks();
            clearTags();
            clearOwners();
            clearPublishers();
            clearAuthors();
            return null;
        });

    }

    ///////////////////////////////////////////////////////////////////////////
    // get section
    ///////////////////////////////////////////////////////////////////////////
    public List<GreenAuthor> getAuthors() {
        return mGreenAuthorDao.loadAll();
    }

    public List<GreenPublisher> getPublishers() {
        return mGreenPublisherDao.loadAll();
    }

    public List<GreenOwner> getOwners() {
        return mGreenOwnerDao.loadAll();
    }

    public List<GreenTag> getTags() {
        return mGreenTagDao.loadAll();
    }

    public List<GreenBook> getBooks() {
        return mGreenBookDao.loadAll();
    }

    public GreenBook getBookLazy(long id) {
        return mGreenBookDao.load(id);
    }

    public GreenBook getBookDeep(Integer id) {
        return mGreenBookDao.loadDeep(id.longValue());
    }

    @NonNull
    public List<GreenBook> getBooksByAuthor(@NonNull Author author) {
        Query<GreenBook> query = mGreenBookDao.queryBuilder()
                .where(GreenBookDao.Properties.MAuthorId.eq(author.getId()))
                .build();
        return query.list();
    }

    @NonNull
    public List<GreenBook> getBooksByPublisher(@NonNull Publisher publisher) {
        Query<GreenBook> query = mGreenBookDao.queryBuilder()
                .where(GreenBookDao.Properties.MPublisherId.eq(publisher.getId()))
                .build();
        return query.list();
    }

    @NonNull
    public List<GreenBook> getBooksByOwner(@NonNull Owner owner) {
        Query<GreenBook> query = mGreenBookDao.queryBuilder()
                .where(GreenBookDao.Properties.MOwnerId.eq(owner.getId()))
                .build();
        return query.list();
    }

    ///////////////////////////////////////////////////////////////////////////
    // save book implementation
    ///////////////////////////////////////////////////////////////////////////
    public void deleteBookTagLinks(int bookId) {
        DeleteQuery<GreenBook2Tag> deleteQuery = mGreenBook2TagDao.queryBuilder()
                .where(GreenBook2TagDao.Properties.MBookId.eq(bookId))
                .buildDelete();
        deleteQuery.executeDeleteWithoutDetachingEntities();
    }

    public void insertBook(@NonNull GreenBook book) {
        mGreenBookDao.insert(book);
    }

    public void saveBook(@NonNull GreenBook book) {
        mGreenBookDao.getSession().callInTxNoException(() -> {
            deleteBookTagLinks(book.getId());
            insertBook(book);

            List<GreenBook2Tag> bookTagLinks = new ArrayList<>(book.getTags().size());
            for (Tag tag : book.getTags()) {
                bookTagLinks.add(new GreenBook2Tag(book, tag));
            }
            insertBookTagLinks(bookTagLinks);
            return null;
        });

    }
}
