package com.zounikeji.alarm;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

public class alarm {

	/**
     * 扫描系统内部通知铃声
     */
    static void scannerMediaFile(Context cont) {
        ContentResolver cr = cont.getContentResolver();
        Cursor cursor = cr.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                new String[] { MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.TITLE }, "is_notification != ?",
                new String[] { "0" }, "_id asc");

        if (cursor == null) {
            return;
        }

        while (cursor.moveToNext()) {
            data.add(cursor.getString(1));
        }
    }
	
}
