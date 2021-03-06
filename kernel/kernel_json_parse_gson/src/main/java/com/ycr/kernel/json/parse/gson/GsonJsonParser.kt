package com.ycr.kernel.json.parse.gson

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.ycr.kernel.json.parse.IJsonArray
import com.ycr.kernel.json.parse.IJsonElement
import com.ycr.kernel.json.parse.IJsonObject
import com.ycr.kernel.json.parse.IJsonParser
import java.lang.reflect.Type

/**
 * Created by yuchengren on 2018/12/17.
 */
object GsonJsonParser : IJsonParser {

    lateinit var gson: Gson
    lateinit var gsonParser: JsonParser

    fun doInit(gson: Gson = Gson(), gsonParser: JsonParser = JsonParser()): GsonJsonParser {
        this.gson = gson
        this.gsonParser = gsonParser
        return this
    }

    override fun toJson(any: Any?): String? {
        try {
            return gson.toJson(any)
        } catch (e: Exception) {
            printExceptionLog(e, "Any toJson")
        }
        return null
    }

    override fun <T> fromJson(json: String?, type: Type?): T? {
        try {
            return gson.fromJson<T>(json, type)
        } catch (e: Exception) {
            printExceptionLog(e, "String fromJson")
        }
        return null
    }

    override fun <T> fromJson(json: IJsonElement?, type: Type?): T? {
        try {
            if (json is GsonJsonElement) {
                return gson.fromJson<T>(json.jsonElement, type)
            }
        } catch (e: Exception) {
            printExceptionLog(e, "IJsonElement fromJson")
        }
        return null
    }

    override fun parseJsonToElement(json: String?): IJsonElement? {
        try{
            return GsonJsonElement(gsonParser.parse(json))
        }catch (e: Exception){
            printExceptionLog(e,"parseJsonToElement")
        }
        return null
    }

    private fun printExceptionLog(e: Exception, period: String) {
        GsonJsonLog.e(e, " GsonJsonParser occur exception at $period ")
    }
}