package commands

import discord4j.core.event.domain.message.*
import reactor.core.publisher.*

class UseChannel: Command {
    override val name: String = "usechannel"
    override val description: String = "Specify a channel to be used for counting."

    override fun execute(event: MessageCreateEvent?): Mono<Void> {
        TODO("Not yet implemented")
    }
}