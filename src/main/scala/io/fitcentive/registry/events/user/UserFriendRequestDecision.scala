package io.fitcentive.registry.events.user

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserFriendRequestDecision(targetUser: UUID, isApproved: Boolean)

object UserFriendRequestDecision extends PubSubOps {
  implicit val codec: Codec[UserFriendRequestDecision] = deriveCodec[UserFriendRequestDecision]

  implicit val converter: PubSubMessageConverter[UserFriendRequestDecision] =
    (message: PubsubMessage) => message.decodeUnsafe[UserFriendRequestDecision]
}
