package com.polaris04.sleepingcaffeine.data.repository.account
import android.content.Context
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class GoogleSignRepository(var context: Context) : GoogleSignRepositoryInterface {
    override suspend fun signInCheck(): Boolean {
        val account = context.let { GoogleSignIn.getLastSignedInAccount(it) }
        if(account!=null){
            Log.d(account.familyName,account.givenName.toString())
        }

        return account != null

    }

     override suspend fun signIn( task: Task<GoogleSignInAccount>): Boolean {
         return try {
             val account = task.getResult(ApiException::class.java)
             val email = account?.email.toString()
             val familyName = account?.familyName.toString()

             Log.d(email, familyName+account.displayName)
             Log.d("성공", "성공")
             true

         } catch (e: ApiException) {
             Log.w("failed", "signInResult:failed code=" + e.statusCode)
             false
         }
    }




}
