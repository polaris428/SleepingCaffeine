package com.polaris04.sleepingcaffeine.presentation.utilluty

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task

class GetGoogleSignInClient {

    fun  getGoogleSignInClientSignInIntent(context: Context): Intent {
      return  GoogleSignIn.getClient(context, gso).signInIntent;

    }
    fun GoogleSignInClientSignInLogOut(context: Context): Task<Void> {
        return GoogleSignIn.getClient(context, gso).signOut().addOnCompleteListener {  }

    }
    private var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
}