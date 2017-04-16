package io.easycm.framework.base.lazy;

import io.easycm.framework.base.entity.BaseEntity;
import io.easycm.framework.base.paging.DataPage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.Hibernate;

/**
 * Seta os relacionamentos dos DTOs (OneToOne, OneToMany, ManyToOne e
 * ManyToMany) que estao Lazy para Null.
 */
public class LazyToNull {

  @Inject
  private Logger log;

  /**
   * Seta os relacionamentos do objeto.
   */
  private void sweep(Object o, boolean searchMap, Map<String, Object> map) {

    String key = null;
    key = o.getClass().getName() + o.hashCode();

    // para nao dar StackOverFlow
    if (searchMap) {
      if (map.containsKey(key)) {
        return;
      }
    }
    map.put(key, null);

    List<Field> fields = getFields(o.getClass());
    for (int i = 0; i < fields.size(); i++) {
      if (fields.get(i).isAnnotationPresent(OneToMany.class)) {
        verifyLazy(o, fields.get(i), OneToMany.class, map);
      } else if (fields.get(i).isAnnotationPresent(ManyToMany.class)) {
        verifyLazy(o, fields.get(i), ManyToMany.class, map);
      } else if (fields.get(i).isAnnotationPresent(OneToOne.class)) {
        verifyLazy(o, fields.get(i), OneToOne.class, map);
      } else if (fields.get(i).isAnnotationPresent(ManyToOne.class)) {
        verifyLazy(o, fields.get(i), ManyToOne.class, map);
      }
    }
  }

  /**
   * Obtem os atributos da classe e de suas superclasses.
   */
  @SuppressWarnings("rawtypes")
  private List<Field> getFields(Class c) {
    List<Field> result = new ArrayList<Field>();
    Field[] f = c.getDeclaredFields();
    for (int i = 0; i < f.length; i++) {
      result.add(f[i]);
    }

    if (c.getSuperclass() != null
        && !c.getSuperclass().getName().equals("java.lang.Object")) {
      result.addAll(getFields(c.getSuperclass()));
    }
    return result;
  }

  /**
   * Seta para Null o relacionamento do VO se ele estiver Lazy.
   */
  @SuppressWarnings("rawtypes")
  private void verifyLazy(Object o, Field field, Class annotation,
      Map<String, Object> map) {
    try {
      Object result = get(o, field);
      if (result == null) {
        return;
      }

      if ((annotation.equals(OneToMany.class) || annotation
          .equals(ManyToMany.class)) && result instanceof Collection) {
        Collection c = (Collection) result;
        if (isInitialized(c)) {
          sweep(c, map);
        } else {
          setNull(o, field);
        }
      } else if (annotation.equals(OneToOne.class)
          || annotation.equals(ManyToOne.class)) {
        if (isInitialized(result)) {
          sweep(result, true, map);
        } else {
          setNull(o, field);
        }
      }
    } catch (Exception e) {
      log.severe(e.getMessage());
    }
  }

  @SuppressWarnings("rawtypes")
  private boolean isInitialized(Collection result) {
    return Hibernate.isInitialized(result);
  }

  private boolean isInitialized(Object result) {
    return Hibernate.isInitialized(result);
  }

  /**
   * Obtem o valor do field via metodo get
   */
  private Object get(Object o, Field field) {
    try {
      String name = field.getName();
      name = "get" + name.substring(0, 1).toUpperCase()
          + name.substring(1);
      Method method = o.getClass().getMethod(name, (Class[]) null);
      return method.invoke(o, (Object[]) null);
    } catch (NoSuchMethodException e) {
      log.severe(e.getMessage());
    } catch (IllegalAccessException e) {
      log.severe(e.getMessage());
    } catch (IllegalArgumentException e) {
      log.severe(e.getMessage());
    } catch (InvocationTargetException e) {
      log.severe(e.getMessage());
    }
    return null;
  }

  /**
   * Seta o field para null via metodo set.
   */
  private void setNull(Object o, Field field) {
    String name = field.getName();
    name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    try {
      Method method = o.getClass().getMethod(name, field.getType());
      method.invoke(o, new Object[]{null});
      log.info("setNull=" + method);
    } catch (NoSuchMethodException e) {
      log.severe(e.getMessage());
    } catch (IllegalArgumentException e) {
      log.severe(e.getMessage());
    } catch (IllegalAccessException e) {
      log.severe(e.getMessage());
    } catch (InvocationTargetException e) {
      log.severe(e.getMessage());
    }
  }

  @SuppressWarnings("rawtypes")
  private void sweep(Collection c, Map<String, Object> map) {
    if (c == null) {
      return;
    }

    for (Object o : c) {
      sweep(o, false, map);
    }
  }

  /**
   * Verifica os relacionamentos do objeto.
   *
   * @param o Object herdando de br.com.supero.base.domain.DTO (hibernate)
   */
  @SuppressWarnings("rawtypes")
  public void setLazyToNull(Object o) {
    if (o == null) {
      return;
    }

    if (o instanceof Collection) {
      this.setLazyToNull((Collection) o);
      return;
    }

    if (o instanceof DataPage) {
      this.setLazyToNull((DataPage) o);
      return;
    }

    if (!(o instanceof BaseEntity)) {
      return;
    }

    Map<String, Object> map = new HashMap<String, Object>();
    sweep(o, true, map);
  }

  /**
   * Verifica os relacionamentos dos objetos da Collection
   *
   * @param c Collection contendo objetos DTO (hibernate)
   */
  @SuppressWarnings("rawtypes")
  public void setLazyToNull(Collection c) {
    if (c == null) {
      return;
    }

    Map<String, Object> map = new HashMap<String, Object>();
    for (Object o : c) {
      sweep(o, false, map);
    }
  }

  /**
   * Verifica a propriedade data(List) do DataPage.
   */
  @SuppressWarnings("rawtypes")
  public void setLazyToNull(DataPage dataPage) {
    if (dataPage == null) {
      return;
    }

    this.setLazyToNull(dataPage.getData());
  }
}