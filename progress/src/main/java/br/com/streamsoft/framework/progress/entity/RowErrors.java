package br.com.streamsoft.framework.progress.entity;

import br.com.streamsoft.framework.progress.ProgressBean;
import com.progress.open4gl.ProResultSet;
import java.io.Serializable;

/**
 * @author Fernando
 * @version 2.0
 */
public class RowErrors implements ProgressBean, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Integer errorSequence;
  private Integer errorNumber;
  private String errorDescription;
  private String errorParameters;
  private String errorType;
  private String errorHelp;
  private String errorSubType;

  public Integer getErrorSequence() {
    return errorSequence;
  }

  public void setErrorSequence(Integer errorSequence) {
    this.errorSequence = errorSequence;
  }

  public Integer getErrorNumber() {
    return errorNumber;
  }

  public void setErrorNumber(Integer errorNumber) {
    this.errorNumber = errorNumber;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getErrorParameters() {
    return errorParameters;
  }

  public void setErrorParameters(String errorParameters) {
    this.errorParameters = errorParameters;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorHelp() {
    return errorHelp;
  }

  public void setErrorHelp(String errorHelp) {
    this.errorHelp = errorHelp;
  }

  public String getErrorSubType() {
    return errorSubType;
  }

  public void setErrorSubType(String errorSubType) {
    this.errorSubType = errorSubType;
  }

  public Object getField(int fieldnum) {
    return null;
  }

  public String getFieldName(String field) {
    if (field.equals("ErrorSequence")) {
      return "ErrorSequence";
    }
    if (field.equals("ErrorNumber")) {
      return "ErrorNumber";
    }
    if (field.equals("ErrorDescription")) {
      return "ErrorDescription";
    }
    if (field.equals("ErrorParameters")) {
      return "ErrorParameters";
    }
    if (field.equals("ErrorType")) {
      return "ErrorType";
    }
    if (field.equals("ErrorHelp")) {
      return "ErrorHelp";
    }
    return field;
  }

  public void setData(ProResultSet resultset) throws Exception {
    setErrorSequence((Integer) resultset.getObject("ErrorSequence"));
    setErrorNumber((Integer) resultset.getObject("ErrorNumber"));
    setErrorDescription((String) resultset.getObject("ErrorDescription"));
    setErrorParameters((String) resultset.getObject("ErrorParameters"));
    setErrorType((String) resultset.getObject("ErrorType"));
    setErrorHelp((String) resultset.getObject("ErrorHelp"));
    setErrorSubType((String) resultset.getObject("ErrorSubType"));
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n errorSequence=" + this.errorSequence);
    sb.append("\n errorNumber=" + this.errorNumber);
    sb.append("\n errorDescription=" + this.errorDescription);
    sb.append("\n errorParameters=" + this.errorParameters);
    sb.append("\n errorType=" + this.errorType);
    sb.append("\n errorHelp=" + this.errorHelp);
    sb.append("\n errorSubType=" + this.errorSubType);
    return sb.toString();
  }
}
