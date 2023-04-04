/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "template",
)
data class TemplateModel(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}