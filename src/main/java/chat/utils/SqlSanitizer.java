package chat.utils;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

import static org.apache.commons.lang.StringEscapeUtils.escapeSql;

public class SqlSanitizer {

    public static String escapeSQL(String sql) {
        return com.Ostermiller.util.StringHelper.escapeSQL(sql);
    }

    public static String encodeSQL(String sql) {
        MySQLCodec codec = new MySQLCodec(MySQLCodec.MYSQL_MODE);
        return ESAPI.encoder().encodeForSQL(codec, sql);
    }

    public static String escapeSQLApache(String sql) {
        return escapeSql(sql);
    }
}
