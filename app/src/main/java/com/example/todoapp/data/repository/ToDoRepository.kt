package com.example.todoapp.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.todoapp.data.models.ToDoData
import com.example.todoapp.data.dao.ToDoDao

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) = toDoDao.insertData(toDoData)
    suspend fun updateData(toDoData: ToDoData) = toDoDao.updateData(toDoData)
    suspend fun deleteItem(toDoData: ToDoData) = toDoDao.deleteItem(toDoData)
    suspend fun deleteAll() = toDoDao.deleteAll()
    fun searchDataBase(searchQuery: String?): LiveData<List<ToDoData>> =
        toDoDao.searchDatabase(searchQuery)
    val sortByHighPriority: LiveData<List<ToDoData>> = toDoDao.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoData>> = toDoDao.sortByLowPriority()

}