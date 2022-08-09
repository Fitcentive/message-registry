package io.fitcentive.registry.events.social

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserCommentedOnPost(commentingUser: UUID, targetUser: UUID, postId: UUID, postCreatorId: UUID)

object UserCommentedOnPost extends PubSubOps {
  implicit val codec: Codec[UserCommentedOnPost] = deriveCodec[UserCommentedOnPost]

  implicit val converter: PubSubMessageConverter[UserCommentedOnPost] =
    (message: PubsubMessage) => message.decodeUnsafe[UserCommentedOnPost]
}
