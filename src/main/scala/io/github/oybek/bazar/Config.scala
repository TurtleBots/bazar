package io.github.oybek.bazar

import ciris.{ConfigValue, Effect, env}

case class Config(botApiToken: String)

object Config:
  def value: ConfigValue[Effect, Config] =
    env("BOT_API_TOKEN").as[String].map(Config.apply)
