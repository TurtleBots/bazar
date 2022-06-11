package io.github.oybek.bazar

import cats.effect.IO
import telegramium.bots.high.*
import telegramium.bots.high.implicits.*
import telegramium.bots.{ChatIntId, Message}

class LongPoll(api: Api[IO]) extends LongPollBot[IO](api):
  given Api[IO] = api

  override def onMessage(msg: Message): IO[Unit] =
    Methods
      .sendMessage(chatId = ChatIntId(msg.chat.id), text = "Hello, world!")
      .exec
      .void
