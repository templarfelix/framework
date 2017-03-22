package br.com.streamsoft.framework.progress.config;

import br.com.streamsoft.framework.progress.entity.ConfigurationVO;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.PropertyResourceBundle;

/**
 *
 * */
public class ConfigManager {

  private final static String ARQUIVOCONFIGURACAO = "progress-config";

  public static String getParametro(String chave) {
    PropertyResourceBundle rsBundleConfig = (PropertyResourceBundle) PropertyResourceBundle
        .getBundle(ARQUIVOCONFIGURACAO);
    String retorno = rsBundleConfig.getString(chave);
    return retorno;
  }

  public static List<ConfigurationVO> getConfig() {

    List<ConfigurationVO> retList = new ArrayList<ConfigurationVO>();

    PropertyResourceBundle rsBundleConfig = (PropertyResourceBundle) PropertyResourceBundle
        .getBundle(ARQUIVOCONFIGURACAO);

    Enumeration<String> retorno = rsBundleConfig.getKeys();

    ConfigurationVO vo = null;
    while (retorno.hasMoreElements()) {
      String element = retorno.nextElement();
      vo = new ConfigurationVO();
      vo.setKey(element);
      vo.setValue(rsBundleConfig.getString(element));
      retList.add(vo);
    }

    return retList;
  }
}