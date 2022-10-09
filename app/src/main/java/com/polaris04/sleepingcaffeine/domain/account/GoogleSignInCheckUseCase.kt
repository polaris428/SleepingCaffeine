package com.polaris04.sleepingcaffeine.domain.account

import com.polaris04.sleepingcaffeine.data.repository.account.GoogleSignRepositoryInterface
import com.polaris04.sleepingcaffeine.domain.UseCase

class GoogleSignInCheckUseCase(private var googleSignRepositoryInterface: GoogleSignRepositoryInterface):
    UseCase {
    suspend operator fun invoke(): Boolean{
        return googleSignRepositoryInterface.signInCheck()
    }
}