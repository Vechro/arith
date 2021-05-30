package tables

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.*
import java.time.*

object Users: Table() {
    val userId: Column<String> = char("user_id", 64)
    val unbanDate: Column<LocalDateTime> = datetime("unban_date")
    val strikes: Column<Int> = integer("strikes")
}