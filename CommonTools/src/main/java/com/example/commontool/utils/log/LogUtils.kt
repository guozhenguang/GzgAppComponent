package com.example.commontool.utils.log

import android.util.Log
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
object LogUtils {

    private const val LogUtilsTag = "GzgComponent__"
    //是否打印log
    var isPrintLog = false

    fun d(tag: String, msg: String) {
        if (isPrintLog) Log.d(LogUtilsTag + tag, msg)
    }

    fun e(tag: String, msg: String) {
        if (isPrintLog) Log.e(LogUtilsTag + tag, msg)
    }

    fun v(tag: String, msg: String) {
        if (isPrintLog) Log.v(LogUtilsTag + tag, msg)
    }

    fun w(tag: String, msg: String) {
        if (isPrintLog) Log.w(LogUtilsTag + tag, msg)
    }

    fun getStackTrace(throwable: Throwable): String{
        var stackTrace = ""
        try {
            val sw = StringWriter().use { stringWriter ->
                PrintWriter(stringWriter).use { printWriter ->
                    throwable.printStackTrace(printWriter)
                }
            }
            stackTrace = sw.toString()
            }catch (e: IOException){
            e("LogUtils","get stack trace fail!")
        }
        return stackTrace
    }
}