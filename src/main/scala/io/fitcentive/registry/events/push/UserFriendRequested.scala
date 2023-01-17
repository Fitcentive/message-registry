package io.fitcentive.registry.events.push

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserFriendRequested(requestingUser: UUID, targetUser: UUID)

object UserFriendRequested extends PubSubOps {
  implicit val codec: Codec[UserFriendRequested] = deriveCodec[UserFriendRequested]

  implicit val converter: PubSubMessageConverter[UserFriendRequested] =
    (message: PubsubMessage) => message.decodeUnsafe[UserFriendRequested]
}
