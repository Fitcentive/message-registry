package io.fitcentive.registry.events.scheduled

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class CancelPreviouslyScheduledMeetupReminderForLater(meetupId: UUID)

object CancelPreviouslyScheduledMeetupReminderForLater extends PubSubOps {
  implicit val codec: Codec[CancelPreviouslyScheduledMeetupReminderForLater] =
    deriveCodec[CancelPreviouslyScheduledMeetupReminderForLater]

  implicit val converter: PubSubMessageConverter[CancelPreviouslyScheduledMeetupReminderForLater] =
    (message: PubsubMessage) => message.decodeUnsafe[CancelPreviouslyScheduledMeetupReminderForLater]
}
