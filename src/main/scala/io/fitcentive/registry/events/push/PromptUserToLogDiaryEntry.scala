package io.fitcentive.registry.events.push

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class PromptUserToLogDiaryEntry(targetUser: UUID)

object PromptUserToLogDiaryEntry extends PubSubOps {
  implicit val codec: Codec[PromptUserToLogDiaryEntry] = deriveCodec[PromptUserToLogDiaryEntry]

  implicit val converter: PubSubMessageConverter[PromptUserToLogDiaryEntry] =
    (message: PubsubMessage) => message.decodeUnsafe[PromptUserToLogDiaryEntry]
}
