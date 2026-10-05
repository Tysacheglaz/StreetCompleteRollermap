package de.westnordost.streetcomplete.quests.smoothnessinlineskates

import de.westnordost.streetcomplete.quests.smoothnessinlineskates.Smoothnessinlineskates.*
import de.westnordost.streetcomplete.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

val Smoothnessinlineskates.title: StringResource get() = when (this) {
    EXCELLENT    -> Res.string.quest_smoothnessinlineskates_excellent
    GOOD         -> Res.string.quest_smoothnessinlineskates_good
    INTERMEDIATE -> Res.string.quest_smoothnessinlineskates_intermediate
    BAD          -> Res.string.quest_smoothnessinlineskates_bad
    VERYBAD      -> Res.string.quest_smoothnessinlineskates_verybad
}

val Smoothnessinlineskates.icon: DrawableResource get() = when (this) {
    EXCELLENT    -> Res.drawable.smoothness_inlineskates_excellent
    GOOD         -> Res.drawable.smoothness_inlineskates_good
    INTERMEDIATE -> Res.drawable.smoothness_inlineskates_intermediate
    BAD          -> Res.drawable.smoothness_inlineskates_bad
    VERYBAD      -> Res.drawable.smoothness_inlineskates_verybad
}
