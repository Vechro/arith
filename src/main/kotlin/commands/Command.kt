package commands

import discord4j.core.event.domain.message.*
import reactor.core.publisher.*


sealed interface Command {

    val name: String
    val description: String

    // Since we are expecting to do reactive things in this method, like
    // send a message, then this method will also return a reactive type.
    fun execute(event: MessageCreateEvent?): Mono<Void>
}