package galyaminsky.peppyalarm.alarmmanager

import galyaminsky.peppyalarm.database.AlarmEntity

interface AlarmScheduler {
    fun schedule(alarmEntity: AlarmEntity)
    fun cancel(alarmEntity: AlarmEntity)
    fun snooze(alarmEntity: AlarmEntity)
}