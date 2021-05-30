package tables

import org.jetbrains.exposed.sql.*

object Rules: Table() {
    val ruleName: Column<String> = varchar("name", 64)
    val ruleState: Column<Boolean> = bool("state")
}