package io.fitcentive.registry.events.achievements

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserAttainedNewAchievementMilestone(
  userId: UUID,
  milestoneName: String,
  milestoneCategory: String,
  attainedAtInMillis: Long
)

object UserAttainedNewAchievementMilestone extends PubSubOps {
  implicit val codec: Codec[UserAttainedNewAchievementMilestone] = deriveCodec[UserAttainedNewAchievementMilestone]

  implicit val converter: PubSubMessageConverter[UserAttainedNewAchievementMilestone] =
    (message: PubsubMessage) => message.decodeUnsafe[UserAttainedNewAchievementMilestone]
}
