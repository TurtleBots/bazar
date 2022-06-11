package io.github.oybek.bazar

import cats.effect.{ExitCode, IO, IOApp, Resource}
import ciris.*
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.client.Client
import telegramium.bots.high.*
import telegramium.bots.high.implicits.*

def resources: Resource[IO, Client[IO]] =
  BlazeClientBuilder[IO].resource

object Bazar extends IOApp:
  override def run(args: List[String]): IO[ExitCode] =
    resources.use { client =>
      for
        config <- Config.value.load[IO]
        api = BotApi(
          client,
          baseUrl = s"https://api.telegram.org/bot${config.botApiToken}"
        )
        _ <- LongPoll(api).start()
        _ <- IO(println(config))
      yield ExitCode.Success
    }
