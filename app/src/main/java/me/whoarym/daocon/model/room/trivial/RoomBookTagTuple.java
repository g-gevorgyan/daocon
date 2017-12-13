package me.whoarym.daocon.model.room.trivial;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

import me.whoarym.daocon.model.room.RoomBook2Tag;
import me.whoarym.daocon.model.room.RoomTag;

class RoomBookTagTuple {
    @Embedded
    RoomBook2Tag mBook2Tag;

    @Relation(entity = RoomTag.class, entityColumn = "_id", parentColumn = "tag_id")
    List<RoomTag> mTags;

    @NonNull
    static SparseArray<List<RoomTag>> remap(@NonNull List<RoomBookTagTuple> tuples) {
        SparseArray<List<RoomTag>> result = new SparseArray<>(tuples.size());

        for (RoomBookTagTuple tagTuple : tuples) {
            int bookId = tagTuple.mBook2Tag.getBookId();
            if (result.get(bookId) == null) {
                result.put(bookId, new ArrayList<>());
            }
            result.get(bookId).addAll(tagTuple.mTags);
        }
        return result;
    }
}
