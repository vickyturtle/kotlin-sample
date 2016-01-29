package me.kashyap.theverge

import android.util.Log

/**
 * Created by vikas@fueled.com on 10/1/15.
 * copyright © Fueled
 */
class Logger {

    internal val tag: String
    var isEnable = true

    constructor(tag: String) {
        this.tag = tag
    }

    fun debug(msg: String) {
        if (isEnable) {
            Log.d(tag, msg)
        }
    }

    fun debug(msg: String, vararg args: Any) {
        debug(msg.format(args))
    }

    fun warn(msg: String) {
        if (isEnable) {
            Log.w(tag, msg)
        }
    }

    fun warn(throwable: Throwable) {
        warn(Log.getStackTraceString(throwable))
    }

    fun warn(msg: String, vararg args: Any) {
        warn(msg.format(args))
    }

    fun info(msg: String) {
        if (isEnable) {
            Log.i(tag, msg)
        }
    }

    fun info(msg: String, vararg args: Any) {
        info(msg.format(args))
    }

    fun error(msg: String) {
        if (isEnable) {
            Log.e(tag, msg)
        }
    }

    fun error(throwable: Throwable) {
        error(Log.getStackTraceString(throwable))
    }

    fun error(msg: String, vararg args: Any) {
        error(msg.format(args))
    }

    fun verbose(msg: String) {
        if (isEnable) {
            Log.v(tag, msg)
        }
    }

    fun verbose(msg: String, vararg args: Any) {
        verbose(msg.format(args))
    }

    companion object {

        fun<T> getLogger(cls: Class<T>): Logger {
            return Logger(cls.name)
        }

        fun getLogger(tag: String): Logger {
            return Logger(tag)
        }
    }

}
