package configreader;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@Sources("classpath:framework.properties")
public interface FrameworkProperties extends Config {


  @Key("driver.baseurl")
  String getBaseUrl();

  @Key("driver.remote")
  Boolean getDriverRemote();

}
