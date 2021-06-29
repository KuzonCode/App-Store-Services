package com.libertyphoneproject.services.data.provider

import android.content.Context
import android.content.pm.PackageManager
import android.os.Binder
import com.libertyphoneproject.services.data.utils.Log

class AccessProvider(context: Context) {

    private val allowedPackages: MutableSet<String> = mutableSetOf(
        "com.libertyphoneproject.store",
        "com.libertyphoneproject.store.debug",
        "com.libertyphoneproject.store.nightly",
        "com.libertyphoneproject.adroid"
    )

    private val packageManager: PackageManager = context.packageManager

    fun getInstallerPackageName(): String {
        val uid = Binder.getCallingUid()
        val callingPackages = packageManager.getPackagesForUid(uid)
        return if (callingPackages == null)
            "Unknown"
        else
            callingPackages[0]
    }

    fun isAllowed(): Boolean {
        return isUidAllowed(Binder.getCallingUid())
    }

    private fun isUidAllowed(uid: Int): Boolean {
        val callingPackages = packageManager.getPackagesForUid(uid)
            ?: throw RuntimeException("No packages associated to caller UID!")
        val currentPkg = callingPackages[0]
        return isPackageAllowed(currentPkg)
    }

    private fun isPackageAllowed(packageName: String): Boolean {
        val isAllowed = allowedPackages.contains(packageName)
        if (isAllowed)
            Log.i("Caller Allowed : $packageName")
        else
            Log.e("Caller not allowed : $packageName")
        return isAllowed
    }
}