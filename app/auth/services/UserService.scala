package auth.services

import java.util.UUID

import auth.model.User
import com.google.inject.Inject
import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider

import scala.concurrent.{ExecutionContext, Future}

trait UserService extends IdentityService[User] {

}

class UserServiceImp @Inject() (implicit ex: ExecutionContext) extends UserService {
  val loginInfo = LoginInfo(CredentialsProvider.ID, "email")

  val user = User(
    userID = UUID.randomUUID(),
    loginInfo = loginInfo,
    firstName = Some("firstName"),
    lastName = Some("lastName"),
    fullName = Some(""),
    email = Some("email"),
    avatarURL = None,
    activated = true
  )

  override def retrieve(loginInfo: LoginInfo): Future[Option[User]] = Future(Some(user))
}

