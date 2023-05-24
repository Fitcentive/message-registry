package io.fitcentive.registry.events.scheduled.transition

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ScheduleMeetupStateTransitionTimeForLater(meetupId: UUID, scheduleTransitionAtMillis: Long)

object ScheduleMeetupStateTransitionTimeForLater extends PubSubOps {
  implicit val codec: Codec[ScheduleMeetupStateTransitionTimeForLater] =
    deriveCodec[ScheduleMeetupStateTransitionTimeForLater]

  implicit val converter: PubSubMessageConverter[ScheduleMeetupStateTransitionTimeForLater] =
    (message: PubsubMessage) => message.decodeUnsafe[ScheduleMeetupStateTransitionTimeForLater]
}
