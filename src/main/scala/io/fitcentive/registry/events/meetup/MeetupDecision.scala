package io.fitcentive.registry.events.meetup

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class MeetupDecision(meetupId: UUID, meetupOwnerId: UUID, participantId: UUID, hasAccepted: Boolean)

object MeetupDecision extends PubSubOps {
  implicit val codec: Codec[MeetupDecision] = deriveCodec[MeetupDecision]

  implicit val converter: PubSubMessageConverter[MeetupDecision] =
    (message: PubsubMessage) => message.decodeUnsafe[MeetupDecision]
}
