package io.easycm.framework.base.paging;

import java.io.Serializable;

public class Page implements Serializable {

  private static final long serialVersionUID = 1L;

  private int startRow;

  private int pageSize;

  /**
   * Construtor vazio.
   */
  public Page() {
  }

  /**
   * Construtor.
   *
   * @param startRow linha inicial
   */
  public Page(int startRow, int pageSize) {
    this.startRow = startRow;
    this.pageSize = pageSize;
  }

  /**
   * maiores que zero.
   */
  public static boolean isValid(Page p) {
    return p != null && p.getStartRow() >= 0 && p.getPageSize() > 0;
  }

  /**
   * Retorna a linha inicial do total de registros. Inicia em zero.
   */
  public int getStartRow() {
    return startRow;
  }

  /**
   * Seta a linha inicial.
   */
  public void setStartRow(int startRow) {
    this.startRow = startRow;
  }

  /**
   * @return
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * @param pageSize
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(this.pageSize);
    result.append("/");
    result.append(this.startRow);
    return result.toString();
  }

}