import org.jetbrains.exposed.sql.*

internal object DbSettings {
    val db by lazy {
        Database.connect(url = "jdbc:h2:file:" + Env.DATA_PATH, driver = "org.h2.Driver")
    }
}