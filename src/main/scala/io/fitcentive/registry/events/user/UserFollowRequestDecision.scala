package io.fitcentive.registry.events.user

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserFollowRequestDecision(targetUser: UUID, isApproved: Boolean)

object UserFollowRequestDecision extends PubSubOps {
  implicit val codec: Codec[UserFollowRequestDecision] = deriveCodec[UserFollowRequestDecision]

  implicit val converter: PubSubMessageConverter[UserFollowRequestDecision] =
    (message: PubsubMessage) => message.decodeUnsafe[UserFollowRequestDecision]
}
