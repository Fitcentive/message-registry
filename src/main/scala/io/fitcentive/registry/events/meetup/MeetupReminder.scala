package io.fitcentive.registry.events.meetup

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

import java.util.UUID

case class MeetupReminder(meetupId: UUID, meetupName: String, targetUser: UUID)

object MeetupReminder extends PubSubOps {
  implicit val codec: Codec[MeetupReminder] = deriveCodec[MeetupReminder]

  implicit val converter: PubSubMessageConverter[MeetupReminder] =
    (message: PubsubMessage) => message.decodeUnsafe[MeetupReminder]
}
