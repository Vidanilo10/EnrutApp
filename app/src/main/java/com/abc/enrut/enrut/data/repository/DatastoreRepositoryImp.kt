package com.abc.enrut.enrut.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import com.abc.enrut.enrut.core.Constants
import kotlinx.coroutines.flow.first

import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name=Constants.dataStoreName)


class DatastoreRepositoryImp @Inject constructor(
    private val context: Context
) : DatastoreRepository {

    override suspend fun getToken(key: String): String? {
        return  try {
            val preferenceKey = stringPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKey]
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun saveToken(key: String, value: String) {
        val prefereneKay = stringPreferencesKey(key)

        context.dataStore.edit {
            it[prefereneKay] = value
        }
    }

}