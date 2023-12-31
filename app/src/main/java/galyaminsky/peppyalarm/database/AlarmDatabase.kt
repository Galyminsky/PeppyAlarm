package galyaminsky.peppyalarm.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlarmEntity::class], version = 1, exportSchema = false)
abstract class AlarmDatabase : RoomDatabase() {
    abstract val alarmDatabaseDao: AlarmDatabaseDao
}