package org.abimon.eternalJukebox.objects

import org.abimon.visi.lang.EnumOS
import java.util.*
import kotlin.collections.HashMap

data class JukeboxConfig(
        var ip: String = "http://\$ip:\$port", //The IP to listen on. Used for OAuth2 callback and song hosting.
        val ssl: SSLCertPair? = null, //Whether to use SSL/HTTPS

        val logAllPaths: Boolean = false,
        val logMissingPaths: Boolean = false,
        val port: Int = 11037,

        val storeSongInformation: Boolean = true,
        val storeSongs: Boolean = true,
        val storeAudio: Boolean = true,

        val redirects: Map<String, String> = hashMapOf("/index.html" to "/jukebox_index.html", "/" to "/jukebox_index.html"),

        var spotifyBase64: String? = null,
        var spotifyClient: String? = null,
        var spotifySecret: String? = null,

        val cors: Boolean = true,

        val googleClient: String? = null,
        val googleSecret: String? = null,
        val eternityUserKey: String = "Eternity-User",

        val httpOnlyCookies: Boolean = true,
        val secureCookies: Boolean = false,

        val csrf: Boolean = true,
        val csrfSecret: String = UUID.randomUUID().toString(),

        val epoch: Long = 1489148833,

        val mysqlUsername: String? = null,
        val mysqlPassword: String? = null,
        val mysqlDatabase: String? = null,

        val httpsOverride: Boolean = false,

        val uploads: Boolean = false,

        val cacheFiles: Boolean = true,
        val enforceHttps: Boolean = ssl != null,
        val format: String = "mp3",

        val vertxBlockingTime: Long = 5 * 60L * 1000 * 1000000,

        val scriptCommand: List<String> = if(EnumOS.determineOS() == EnumOS.WINDOWS) listOf("yt.bat") else listOf("bash", "yt.sh"),
        val storageType: String = "LocalStorage",
        val storageOptions: Map<String, String> = HashMap(),
        val shortIDLength: Int = 4 //No greater than 16
)

data class SSLCertPair(val key: String, val cert: String)