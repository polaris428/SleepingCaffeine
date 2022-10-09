package com.polaris04.sleepingcaffeine.domain.account

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class GoogleSignInUseCase(
    private var googleSignRepositoryInterface: GoogleSignRepositoryInterface,
) :
    UseCase {
    suspend operator fun invoke( task: Task<GoogleSignInAccount>): Boolean {
        return googleSignRepositoryInterface.signIn(task)


    }
}