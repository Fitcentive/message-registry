package io.fitcentive.registry.events.user

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserEnablePremium(targetUser: UUID)

object UserEnablePremium extends PubSubOps {
  implicit val codec: Codec[UserEnablePremium] = deriveCodec[UserEnablePremium]

  implicit val converter: PubSubMessageConverter[UserEnablePremium] =
    (message: PubsubMessage) => message.decodeUnsafe[UserEnablePremium]
}
