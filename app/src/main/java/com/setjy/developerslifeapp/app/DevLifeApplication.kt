package com.setjy.developerslifeapp.app

import android.app.Application
import com.setjy.developerslifeapp.GlobalDI

class DevLifeApplication : Application() {
    val globalDI: GlobalDI by lazy { GlobalDI() }
}