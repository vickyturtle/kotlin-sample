package me.kashyap.theverge.sync

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

import me.kashyap.theverge.Logger


/**
 * Created by vikas@fueled.com on 10/15/15.
 * copyright © Fueled
 */
class StubProvider : ContentProvider() {

    private val logger = Logger.getLogger(javaClass)
    /*
     * Always return true, indicating that the
     * provider loaded correctly.
     */
    override fun onCreate(): Boolean {
        logger.debug("on create")
        return true
    }

    /*
     * Return no type for MIME type
     */
    override fun getType(uri: Uri): String? {
        logger.debug("getType :" + uri)
        return null
    }

    /*
     * query() always returns no results
     *
     */
    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        logger.debug("query :" + uri)
        return null
    }

    /*
     * insert() always returns null (no URI)
     */
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    /*
     * delete() always returns "no rows affected" (0)
     */
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    /*
     * update() always returns "no rows affected" (0)
     */
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

}
