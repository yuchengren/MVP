package com.ycr.kernel.http

import java.lang.reflect.Type
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by yuchengren on 2018/12/14.
 */
abstract class HttpScheduler: IHttpScheduler {
    private val callGroup = ConcurrentHashMap<String,MutableMap<String,ICall>>()

    override fun execute(call: ICall, groupName: String?, taskName: String?): IResponse {
        if(groupName == null || taskName == null){
            return call.execute()
        }
        var group = callGroup[groupName]
        if(group == null){
            group = mutableMapOf()
            callGroup[groupName] = group
        }
        group[taskName] = call
        val response = call.execute()
        group.remove(taskName)
        return response
    }

    override fun <T> parse(resultParser: IResultParser, type: Type?, response: IResponse): IResult<T> {
        val result = resultParser.parse<T>(type,response)
        return result
    }

    fun cancelGroup(groupName: String?){
        val group = callGroup[groupName]
        group?.run {
            forEach {
                it.value.cancel()
            }
        }
    }
}