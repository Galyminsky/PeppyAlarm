package galyaminsky.peppyalarm.alarmmanager

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import galyaminsky.peppyalarm.database.AlarmDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {
    @Inject
    lateinit var dao: AlarmDatabaseDao

    @Inject
    lateinit var application: Application
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            CoroutineScope(Dispatchers.IO).launch {
                val scheduler = AndroidAlarmScheduler(application)
                val alarms = dao.getAlarms()
                for (alarm in alarms) {
                    scheduler.schedule(alarm)
                }
            }
        }
    }
}