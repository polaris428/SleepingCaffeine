package com.polaris04.sleepingcaffeine.presentation.utilluty

import android.content.Context
import android.widget.Toast
import com.polaris04.sleepingcaffeine.domain.UseCase

class ToastMare :UseCase{
     fun ToastShort(context: Context, msg: String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

}


