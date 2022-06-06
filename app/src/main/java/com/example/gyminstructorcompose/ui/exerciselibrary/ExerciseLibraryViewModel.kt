package com.example.gyminstructorcompose.ui.exerciselibrary

import android.util.Log
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

    private val allExerciseInfo = mutableStateOf(
        listOf<ExerciseInfo>()
    )
    private var exerciseInfoExtended: ExerciseInfoExtended? = null

    fun getAllExerciseInfo(): List<ExerciseInfo> {
        viewModelScope.launch {
            allExerciseInfo.value = repository.getAllShort()
            Log.i("EXERCISE_VM", allExerciseInfo.value.size.toString())
        }
        Log.i("EXERCISE_VM1", allExerciseInfo.value.size.toString())
        return allExerciseInfo.value
    }

    fun getExtended(id: Int): ExerciseInfoExtended {
        viewModelScope.launch {
            exerciseInfoExtended = repository.getExtended(id)
        }
        return exerciseInfoExtended!!
    }

}