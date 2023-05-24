package io.fitcentive.registry.events.scheduled.reminder

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ScheduledMeetupReminder(meetupId: UUID)

object ScheduledMeetupReminder extends PubSubOps {
  implicit val codec: Codec[ScheduledMeetupReminder] = deriveCodec[ScheduledMeetupReminder]

  implicit val converter: PubSubMessageConverter[ScheduledMeetupReminder] =
    (message: PubsubMessage) => message.decodeUnsafe[ScheduledMeetupReminder]
}
