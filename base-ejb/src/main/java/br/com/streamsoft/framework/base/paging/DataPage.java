package br.com.streamsoft.framework.base.paging;

import java.io.Serializable;
import java.util.List;

/**
 * Representa o resultado de uma pesquisa paginada.
 *
 * @param <T> DTO para qual foi realizada a pesquisa
 * @author alexandre
 */
public class DataPage<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<T> data;

  private Number count;

  private Page page;

  /**
   * Construtor.
   */
  public DataPage(List<T> data, Number count, Page page) {
    this.data = data;
    this.count = count;
    this.page = page;
  }

  /**
   * @return
   */
  public Page getPage() {
    return page;
  }

  /**
   * @param page
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * Quantidade total de registros da pesquisa.
   */
  public Number getCount() {
    return count;
  }

  /**
   * Seta a quantidade total de registros da pesquisa.
   */
  public void setCount(Number count) {
    this.count = count;
  }

  /**
   * @return
   */
  public List<T> getData() {
    return data;
  }

  /**
   * @param data
   */
  public void setData(List<T> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("count=" + this.count);
    result.append(", page=[" + this.page + "]");
    result.append(", data=" + this.data);
    return result.toString();
  }
}