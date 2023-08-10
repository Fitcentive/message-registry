package io.fitcentive.registry.events.diary

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class CheckIfUsersNeedPromptToLogDiaryEntries(userIds: Seq[UUID])

object CheckIfUsersNeedPromptToLogDiaryEntries extends PubSubOps {
  implicit val codec: Codec[CheckIfUsersNeedPromptToLogDiaryEntries] =
    deriveCodec[CheckIfUsersNeedPromptToLogDiaryEntries]

  implicit val converter: PubSubMessageConverter[CheckIfUsersNeedPromptToLogDiaryEntries] =
    (message: PubsubMessage) => message.decodeUnsafe[CheckIfUsersNeedPromptToLogDiaryEntries]
}
