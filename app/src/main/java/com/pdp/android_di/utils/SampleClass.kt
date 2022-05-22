package com.pdp.android_di.utils

import android.util.Log
import javax.inject.Inject

class SampleClass @Inject constructor() {

    fun doSomeThing(){
        Log.d("SampleClass","Do some work...")
    }
}


