package com.polaris04.sleepingcaffeine.data.repository.account

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
interface GoogleSignRepositoryInterface {
    suspend fun signInCheck(): Boolean

   suspend fun signIn( task: Task<GoogleSignInAccount>):Boolean
}