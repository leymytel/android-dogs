package com.example.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.dogs.model.DogBreed
import com.example.dogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application): BaseViewModel(application) {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(dogId: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(dogId)
            dogLiveData.value = dog
        }
    }
}