package tables

import org.jetbrains.exposed.sql.*

object GlobalData: Table() {
    val isEnabled: Column<Boolean> = bool("is_enabled")
    val channelId: Column<String> = char("channel_id", 64)
    val lastNumber: Column<Int> = integer("last_number")
    val lastMessageId: Column<String> = char("last_message_id", 64)
}