package io.fitcentive.registry.events.scheduled

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ScheduleMeetupReminderForLater(meetupId: UUID)

object ScheduleMeetupReminderForLater extends PubSubOps {
  implicit val codec: Codec[ScheduleMeetupReminderForLater] = deriveCodec[ScheduleMeetupReminderForLater]

  implicit val converter: PubSubMessageConverter[ScheduleMeetupReminderForLater] =
    (message: PubsubMessage) => message.decodeUnsafe[ScheduleMeetupReminderForLater]
}
