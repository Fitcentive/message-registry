package io.fitcentive.registry.events.meetup

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class ParticipantAddedToMeetup(meetupId: UUID, ownerId: UUID, participantId: UUID)

object ParticipantAddedToMeetup extends PubSubOps {
  implicit val codec: Codec[ParticipantAddedToMeetup] = deriveCodec[ParticipantAddedToMeetup]

  implicit val converter: PubSubMessageConverter[ParticipantAddedToMeetup] =
    (message: PubsubMessage) => message.decodeUnsafe[ParticipantAddedToMeetup]
}
