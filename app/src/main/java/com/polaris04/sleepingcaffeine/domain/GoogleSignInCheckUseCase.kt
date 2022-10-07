package com.polaris04.sleepingcaffeine.domain

import com.polaris04.sleepingcaffeine.data.repository.GoogleSignRepositoryInterface

class GoogleSignInCheckUseCase(private var googleSignRepositoryInterface: GoogleSignRepositoryInterface):UseCase {
    suspend operator fun invoke(): Boolean{
        return googleSignRepositoryInterface.signInCheck()
    }
}