package com.example.gyminstructorcompose.ui.exerciselibrary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseLibraryViewModel @Inject constructor(
    private val repository: ExerciseLibraryRepository
) : ViewModel() {

    private val allExerciseInfo = mutableStateOf(emptyList<ExerciseInfo>())

    private val favoriteExercise = mutableStateOf(emptyList<ExerciseInfo>())

    private var exerciseInfoExtended: ExerciseInfoExtended? = null

    fun getAllExerciseInfo(): MutableState<List<ExerciseInfo>> {

        if (allExerciseInfo.value.isNotEmpty()) return allExerciseInfo

        viewModelScope.launch {
            allExerciseInfo.value = repository.getAllShort()
        }
        return allExerciseInfo
    }

    fun getExtended(id: Int): ExerciseInfoExtended {
        viewModelScope.launch {
            exerciseInfoExtended = repository.getExtended(id)
        }
        return exerciseInfoExtended!!
    }

    fun getFavoriteExercise(): MutableState<List<ExerciseInfo>> {
        viewModelScope.launch {
            favoriteExercise.value = repository.getFavoriteExercise()
        }
        return favoriteExercise
    }

    fun updateFavorite(exerciseInfo: ExerciseInfo) {
        viewModelScope.launch {
            repository.updateFavorite(exerciseInfo)
        }
    }

}