package io.fitcentive.registry.events.meetup

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ParticipantAddedAvailabilityToMeetup(
  meetupId: UUID,
  meetupOwnerId: UUID,
  participantId: UUID,
  targetUserId: UUID
)

object ParticipantAddedAvailabilityToMeetup extends PubSubOps {
  implicit val codec: Codec[ParticipantAddedAvailabilityToMeetup] = deriveCodec[ParticipantAddedAvailabilityToMeetup]

  implicit val converter: PubSubMessageConverter[ParticipantAddedAvailabilityToMeetup] =
    (message: PubsubMessage) => message.decodeUnsafe[ParticipantAddedAvailabilityToMeetup]
}
