package Framework.DataReader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderParams
{
  /**@author Shantanu Gupta
  * String array of key-value pairs fed to a dynamic data provider.
  * Should be in the form of key=value, e.g., <br />
  * args={"foo=bar", "biz=baz"}
  */
String[] value();

}