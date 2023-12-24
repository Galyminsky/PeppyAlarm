package galyaminsky.peppyalarm.alarmmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import galyaminsky.peppyalarm.database.AlarmEntity
import galyaminsky.peppyalarm.ui.alarm.AlarmDialogActivity

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            val entity = intent?.getParcelableExtra<AlarmEntity>("alarm1") ?: return
            Log.i("rrrrrrrrrr", "onReceive:${entity.id} ")
            val intentToAlarmDialog = Intent(context, AlarmDialogActivity::class.java)
            intentToAlarmDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intentToAlarmDialog.putExtra("alarm2", entity)
            intentToAlarmDialog.putExtra("music", true)
            context?.startActivity(intentToAlarmDialog)
        } catch (e: Exception) {
            Log.i("aaaaaaaaaaaa", "onReceive: catch $e")
        }
    }
}