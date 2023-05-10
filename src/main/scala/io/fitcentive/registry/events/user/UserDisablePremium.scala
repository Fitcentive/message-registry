package io.fitcentive.registry.events.user

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserDisablePremium(targetUser: UUID)

object UserDisablePremium extends PubSubOps {
  implicit val codec: Codec[UserDisablePremium] = deriveCodec[UserDisablePremium]

  implicit val converter: PubSubMessageConverter[UserDisablePremium] =
    (message: PubsubMessage) => message.decodeUnsafe[UserDisablePremium]
}
