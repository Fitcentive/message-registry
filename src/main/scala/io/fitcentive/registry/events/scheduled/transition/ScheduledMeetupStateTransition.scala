package io.fitcentive.registry.events.scheduled.transition

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ScheduledMeetupStateTransition(meetupId: UUID)

object ScheduledMeetupStateTransition extends PubSubOps {
  implicit val codec: Codec[ScheduledMeetupStateTransition] = deriveCodec[ScheduledMeetupStateTransition]

  implicit val converter: PubSubMessageConverter[ScheduledMeetupStateTransition] =
    (message: PubsubMessage) => message.decodeUnsafe[ScheduledMeetupStateTransition]
}
