import discord4j.core.*
import discord4j.core.`object`.entity.*
import discord4j.core.event.domain.lifecycle.*
import discord4j.core.event.domain.message.*
import org.jetbrains.exposed.sql.*
import org.slf4j.*

@Suppress("MemberVisibilityCanBePrivate")
class Arith {
    private val logger = LoggerFactory.getLogger(this::class.java)!!
    private val prefix = Env.PREFIX + Env.KEYWORD

    init {
        main()
    }

    fun main() {
        val client = DiscordClientBuilder.create(Env.TOKEN)
            .build()
            .login()
            .block()!!

        client.eventDispatcher.on(ReadyEvent::class.java)
            .subscribe {
                it.self.apply {
                    logger.info("Logged in as ${this.username} ${this.discriminator}")
                }
            }

        client.eventDispatcher.on(MessageCreateEvent::class.java)
            .map(MessageCreateEvent::getMessage)
            .filter { it.author.map { user -> !user.isBot }.orElse(false) }
            .filter { it.content.equals("!ping", ignoreCase = true) }
            .flatMap(Message::getChannel)
            .flatMap { it.createMessage("Pong!") }
            .subscribe()

        client.onDisconnect().block()
    }
}