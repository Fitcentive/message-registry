package io.fitcentive.registry.events.social

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserLikedPost(likingUser: UUID, targetUser: UUID, postId: UUID)

object UserLikedPost extends PubSubOps {
  implicit val codec: Codec[UserLikedPost] = deriveCodec[UserLikedPost]

  implicit val converter: PubSubMessageConverter[UserLikedPost] =
    (message: PubsubMessage) => message.decodeUnsafe[UserLikedPost]
}
