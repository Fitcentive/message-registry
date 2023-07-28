package io.fitcentive.registry.events.steps

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserStepDataUpdated(userId: UUID, date: String, stepsTaken: Int)

object UserStepDataUpdated extends PubSubOps {
  implicit val codec: Codec[UserStepDataUpdated] = deriveCodec[UserStepDataUpdated]

  implicit val converter: PubSubMessageConverter[UserStepDataUpdated] =
    (message: PubsubMessage) => message.decodeUnsafe[UserStepDataUpdated]
}
