package io.fitcentive.registry.events.meetup

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class MeetupLocationChanged(meetupId: UUID, meetupName: String, targetUser: UUID)

object MeetupLocationChanged extends PubSubOps {
  implicit val codec: Codec[MeetupLocationChanged] = deriveCodec[MeetupLocationChanged]

  implicit val converter: PubSubMessageConverter[MeetupLocationChanged] =
    (message: PubsubMessage) => message.decodeUnsafe[MeetupLocationChanged]
}
