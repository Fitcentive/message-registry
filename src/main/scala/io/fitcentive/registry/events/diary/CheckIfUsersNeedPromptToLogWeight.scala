package io.fitcentive.registry.events.diary

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class CheckIfUsersNeedPromptToLogWeight(userIds: Seq[UUID])

object CheckIfUsersNeedPromptToLogWeight extends PubSubOps {
  implicit val codec: Codec[CheckIfUsersNeedPromptToLogWeight] = deriveCodec[CheckIfUsersNeedPromptToLogWeight]

  implicit val converter: PubSubMessageConverter[CheckIfUsersNeedPromptToLogWeight] =
    (message: PubsubMessage) => message.decodeUnsafe[CheckIfUsersNeedPromptToLogWeight]
}
