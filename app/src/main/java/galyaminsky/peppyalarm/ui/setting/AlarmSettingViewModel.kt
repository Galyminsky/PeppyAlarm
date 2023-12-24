package galyaminsky.peppyalarm.ui.setting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import galyaminsky.peppyalarm.database.AlarmDatabaseDao
import galyaminsky.peppyalarm.database.AlarmEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmSettingViewModel @Inject constructor(private val dao: AlarmDatabaseDao) : ViewModel() {
    fun insertAlarmToDatabase(alarmEntity: AlarmEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.insertAlarm(alarmEntity)
            } catch (e: Exception) {
                Log.i("insertAlarmToDatabase", "insertAlarmToDatabase: $e ")
            }
        }
    }

    fun updateAlarm(alarmEntity: AlarmEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.updateAlarm(alarmEntity)
            } catch (e: Exception) {
                Log.i("updateAlarm", "updateAlarm: $e")
            }
        }
    }

    fun updateAlarmState(id: String, state: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.updateAlarmState(id, state)
            } catch (e: Exception) {
                Log.i("updateAlarmState", "updateAlarmState: $e ")
            }
        }
    }
}