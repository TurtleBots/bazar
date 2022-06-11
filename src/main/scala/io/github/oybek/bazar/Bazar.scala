package io.github.oybek.bazar

import cats.effect.{ExitCode, IO, IOApp}
import ciris.*

object Bazar extends IOApp:
  override def run(args: List[String]): IO[ExitCode] =
    for
      config <- Config.value.load[IO]
      _      <- IO(println(config))
    yield ExitCode.Success
