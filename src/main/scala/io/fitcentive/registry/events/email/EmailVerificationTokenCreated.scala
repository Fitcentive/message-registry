package io.fitcentive.registry.events.email

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

class EmailVerificationTokenCreated(emailId: String, token: String, expiry: Option[Long])

object EmailVerificationTokenCreated {
  implicit val codec: Codec[EmailVerificationTokenCreated] = deriveCodec[EmailVerificationTokenCreated]
}
