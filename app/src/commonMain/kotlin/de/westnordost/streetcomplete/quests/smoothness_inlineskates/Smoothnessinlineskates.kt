package de.westnordost.streetcomplete.quests.smoothnessinlineskates

import kotlinx.serialization.Serializable

@Serializable
enum class Smoothnessinlineskates(val osmValue: String) {
    EXCELLENT("excellent"),
    GOOD("good"),
    INTERMEDIATE("intermediate"),
    BAD("bad"),
    VERYBAD("very-bad"),
}
