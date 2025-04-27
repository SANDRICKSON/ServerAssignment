package com.workingserver

data class ApiResponse(
    val data: List<ObjectData>
)

data class ObjectData(
    val id: String,
    val name: String,
    val data: Map<String, Any>?
)
