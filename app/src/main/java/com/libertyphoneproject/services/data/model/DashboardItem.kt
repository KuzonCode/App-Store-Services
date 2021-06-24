package com.libertyphoneproject.services.data.model

data class DashboardItem(
    val id: Int,
    var title: String,
    var subtitle: String,
    var icon: Int = 0
) {

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is DashboardItem -> other.id == id && other.subtitle == subtitle
            else -> false
        }
    }
}