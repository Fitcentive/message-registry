package io.fitcentive.registry.events.push_notifications

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserFollowRequested(requestingUser: UUID, targetUser: UUID)

object UserFollowRequested extends PubSubOps {
  implicit val codec: Codec[UserFollowRequested] = deriveCodec[UserFollowRequested]

  implicit val converter: PubSubMessageConverter[UserFollowRequested] =
    (message: PubsubMessage) => message.decodeUnsafe[UserFollowRequested]
}
