package io.fitcentive.registry.events.push

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class PromptUserToLogWeight(targetUser: UUID)

object PromptUserToLogWeight extends PubSubOps {
  implicit val codec: Codec[PromptUserToLogWeight] = deriveCodec[PromptUserToLogWeight]

  implicit val converter: PubSubMessageConverter[PromptUserToLogWeight] =
    (message: PubsubMessage) => message.decodeUnsafe[PromptUserToLogWeight]
}
