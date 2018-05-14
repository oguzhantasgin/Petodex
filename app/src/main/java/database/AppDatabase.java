package database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import dao.IPetDAO;
import pets.Pet;


@Database(entities = {Pet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract IPetDAO getStudentDAO();

    private static final String databaseName = "Petodex";

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, databaseName)
                    .addMigrations(MIGRATION)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }


    public static void destroyInstance() {
        appDatabase = null;
    }

    private static final Migration MIGRATION = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            // version change codes put here

        }
    };

}