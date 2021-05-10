package xar.mvvm.xarlib

import android.os.StrictMode
import android.util.Log
import androidx.multidex.MultiDexApplication
import timber.log.Timber

abstract class XarApplication : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }*/

        Timber.plant(Timber.DebugTree())

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
    class ReleaseTree : Timber.DebugTree() {

        override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
            // Don't log VERBOSE and DEBUG
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            Log.println(priority, "Test->$tag", message)

        }
    }
}