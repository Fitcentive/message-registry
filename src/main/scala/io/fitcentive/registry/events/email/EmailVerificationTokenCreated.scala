package io.fitcentive.registry.events.email

import com.google.pubsub.v1.PubsubMessage
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import io.fitcentive.sdk.gcp.pubsub.PubSubMessageConverter
import io.fitcentive.sdk.utils.PubSubOps

case class EmailVerificationTokenCreated(emailId: String, token: String, expiry: Option[Long])

object EmailVerificationTokenCreated extends PubSubOps {
  implicit val codec: Codec[EmailVerificationTokenCreated] = deriveCodec[EmailVerificationTokenCreated]

  implicit val converter: PubSubMessageConverter[EmailVerificationTokenCreated] =
    (message: PubsubMessage) => message.decodeUnsafe[EmailVerificationTokenCreated]
}
