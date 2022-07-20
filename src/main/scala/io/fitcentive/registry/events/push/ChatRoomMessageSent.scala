package io.fitcentive.registry.events.push

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ChatRoomMessageSent(sendingUser: UUID, targetUser: UUID, roomId: UUID)

object ChatRoomMessageSent extends PubSubOps {
  implicit val codec: Codec[ChatRoomMessageSent] = deriveCodec[ChatRoomMessageSent]

  implicit val converter: PubSubMessageConverter[ChatRoomMessageSent] =
    (message: PubsubMessage) => message.decodeUnsafe[ChatRoomMessageSent]
}
