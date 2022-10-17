package com.example.commontool.utils.arounter

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
interface ARoutePath {

    /**
     * 主App
     */
    interface App {
        companion object {
            const val APP_ACTIVITY = "/app/MainActivity"
        }
    }

    /**
     * photo module
     */
    interface Photo {
        companion object {
            const val PHOTO_ACTIVITY = "/photo/PhotoActivity"
        }
    }


}