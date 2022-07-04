package io.fitcentive.registry.events.push_notifications

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

import java.util.UUID

case class UserFollowRequested(requestingUser: UUID, targetUser: UUID)

object UserFollowRequestedEvent {
  implicit val codec: Codec[UserFollowRequested] = deriveCodec[UserFollowRequested]
}
