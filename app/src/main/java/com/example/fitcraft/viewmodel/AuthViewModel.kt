package com.example.fitcraft.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel :  ViewModel(){
    private var user : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState : MutableLiveData<AuthState> = MutableLiveData()
    val authState : LiveData<AuthState> = _authState
    init {
        checkAuthStatus()
    }
    var isCompletedProfile by mutableStateOf(false)
        private set
    fun completeProfile(){
        isCompletedProfile = true
    }
    fun unCompleteProfile(){
        isCompletedProfile = false
    }
    fun login(email : String,password : String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value= AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        user.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                _authState.value = AuthState.Authenticated
            }
            else {
                _authState.value= AuthState.Error(task.exception?.message ?: "Something went wrong")
            }
        }
    }
    fun signup(email : String,password : String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value= AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        user.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                _authState.value = AuthState.Authenticated
            }
            else {
                _authState.value= AuthState.Error(task.exception?.message ?: "Something went wrong")
            }
        }
    }
    fun checkAuthStatus(){
        if(user.currentUser!=null){
            _authState.value = AuthState.Authenticated
        }
        else{
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun signOut(){
        user.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

sealed class AuthState(){
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message : String) : AuthState()
}