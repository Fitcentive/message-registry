package io.fitcentive.registry.events.diary

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class UserDiaryEntryCreated(userId: UUID, date: String, activityMinutes: Option[Int])

object UserDiaryEntryCreated extends PubSubOps {
  implicit val codec: Codec[UserDiaryEntryCreated] = deriveCodec[UserDiaryEntryCreated]

  implicit val converter: PubSubMessageConverter[UserDiaryEntryCreated] =
    (message: PubsubMessage) => message.decodeUnsafe[UserDiaryEntryCreated]
}
