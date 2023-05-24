package io.fitcentive.registry.events.scheduled.transition

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class CancelPreviouslyScheduledMeetupStateTransitionForLater(meetupId: UUID)

object CancelPreviouslyScheduledMeetupStateTransitionForLater extends PubSubOps {
  implicit val codec: Codec[CancelPreviouslyScheduledMeetupStateTransitionForLater] =
    deriveCodec[CancelPreviouslyScheduledMeetupStateTransitionForLater]

  implicit val converter: PubSubMessageConverter[CancelPreviouslyScheduledMeetupStateTransitionForLater] =
    (message: PubsubMessage) => message.decodeUnsafe[CancelPreviouslyScheduledMeetupStateTransitionForLater]
}
