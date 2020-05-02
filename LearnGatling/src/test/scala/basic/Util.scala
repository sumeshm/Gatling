package basic

import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.concurrent.duration._

import scala.xml._

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods._;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.xml.parsers._;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom._;
import java.io._;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.TimeZone;

object Util {

  def randomString(length: Int, mode: String): String =
    {

      val buffer = new StringBuffer();
      var characters = "";

      if (mode.equals("ALPHA"))
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

      if (mode.equals("ALPHANUMERIC"))
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

      if (mode.equals("NUMERIC"))
        characters = "1234567890";

      if (mode.equals("NUMTHREE"))
        characters = "123";

      if (mode.equals("NUMFOUR"))
        characters = "1234";

      if (mode.equals("ALPHACAP"))
        characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      if (mode.equals("ALPHACAPNUMERIC"))
        characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

      var charactersLength = characters.length();
      var i = 0;

      for (i <- 0 to (length - 1)) {
        val index = Math.random() * charactersLength;
        buffer.append(characters.charAt(index.toInt));
      }
      return buffer.toString();
    }
}
