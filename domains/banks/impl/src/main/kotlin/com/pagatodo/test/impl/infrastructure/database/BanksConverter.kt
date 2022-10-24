package com.pagatodo.test.impl.infrastructure.database

import androidx.room.TypeConverter
import org.json.JSONArray
import org.json.JSONObject

class BanksConverter {

    @TypeConverter
    fun fromBanks(renderType: List<String>): String {
        val data = JSONObject()
        val list = JSONArray()
        renderType.forEach { list.put(it) }

        return data.put("renders", list).toString()
    }

    @TypeConverter
    fun toBanks(renders: String): List<String> {
        val data = JSONObject(renders).getJSONArray("renders")

        val renderList = mutableListOf<String>()
        (0 until data.length()).forEach { item ->
            renderList.add(data.getString(item).uppercase())
        }

        return renderList
    }
}
