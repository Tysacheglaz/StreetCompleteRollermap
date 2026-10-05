package de.westnordost.streetcomplete.quests.smoothnessinlineskates

import androidx.compose.runtime.Composable
import de.westnordost.streetcomplete.data.meta.CountryInfo
import de.westnordost.streetcomplete.data.osm.geometry.ElementGeometry
import de.westnordost.streetcomplete.data.osm.mapdata.Element
import de.westnordost.streetcomplete.data.osm.osmquests.OsmFilterQuestType
import de.westnordost.streetcomplete.data.osm.osmquests.QuestAction
import de.westnordost.streetcomplete.data.user.achievements.EditTypeAchievement.PEDESTRIAN
import de.westnordost.streetcomplete.osm.Tags
import de.westnordost.streetcomplete.osm.updateWithCheckDate
import de.westnordost.streetcomplete.resources.*
import de.westnordost.streetcomplete.ui.common.item_select.ImageWithLabel
import de.westnordost.streetcomplete.ui.common.quest.ItemSelectQuestForm
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class AddSmoothnessinlineskates : OsmFilterQuestType<Smoothnessinlineskates>() {

    override val elementFilter = """
        ways with
          ( highway = footway or highway = path )
          and (
            !smoothness:inlineskates
            or smoothness:inlineskates older today -1 years
          )
          and (access !~ private|no or (foot and foot !~ private|no))
    """

    override val changesetComment = "Specify smoothness for inlineskates"
    override val wikiLink = "Key:smoothness:inlineskates"
    override val icon = Res.drawable.quest_inlineskates
    override val title = Res.string.quest_smoothnessinlineskates_title
    override val achievements = listOf(PEDESTRIAN)

    @Composable
    override fun Form(on: (QuestAction<Smoothnessinlineskates>) -> Unit, element: Element, geometry: ElementGeometry, countryInfo: CountryInfo) {
        ItemSelectQuestForm(
            on = on,
            items = Smoothnessinlineskates.entries,
            itemContent = { ImageWithLabel(painterResource(it.icon), stringResource(it.title)) },
            itemsPerRow = 1,
        )
    }

    override fun applyAnswerTo(answer: Smoothnessinlineskates, tags: Tags, geometry: ElementGeometry, timestampEdited: Long) {
        tags.updateWithCheckDate("smoothness:inlineskates", answer.osmValue)
    }
}
