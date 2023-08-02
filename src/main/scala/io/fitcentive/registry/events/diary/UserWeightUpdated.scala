package io.fitcentive.registry.events.diary

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserWeightUpdated(userId: UUID, date: String, newWeightInLbs: Double)

object UserWeightUpdated extends PubSubOps {
  implicit val codec: Codec[UserWeightUpdated] = deriveCodec[UserWeightUpdated]

  implicit val converter: PubSubMessageConverter[UserWeightUpdated] =
    (message: PubsubMessage) => message.decodeUnsafe[UserWeightUpdated]
}
