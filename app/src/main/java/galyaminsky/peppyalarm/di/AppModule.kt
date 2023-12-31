package galyaminsky.peppyalarm.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import galyaminsky.peppyalarm.database.AlarmDatabase
import galyaminsky.peppyalarm.database.AlarmDatabaseDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRoomDatabaseBuilder(application: Application): AlarmDatabase {
        return Room.databaseBuilder(
            application,
            AlarmDatabase::class.java, "alarm_db"
        ).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideDaoInstance(alarmDatabase: AlarmDatabase): AlarmDatabaseDao {
        return alarmDatabase.alarmDatabaseDao
    }
}