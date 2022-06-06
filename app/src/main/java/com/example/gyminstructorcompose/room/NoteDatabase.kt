package com.example.gyminstructorcompose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gyminstructorcompose.model.Note
import com.example.gyminstructorcompose.room.dao.NoteDao


@Database(
    entities = [
        Note::class
    ],
    exportSchema = true,
    version = 2
)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun getNoteDao() : NoteDao
}

val NOTES_MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE NoteTemp(id INTEGER PRIMARY KEY AUTOINCREMENT not null, title TEXT not null, body TEXT not null)")
        database.execSQL("DROP TABLE Note")
        database.execSQL("ALTER TABLE NoteTemp RENAME TO Note")
    }
}