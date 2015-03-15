package br.com.streamsoft.framework.form.rest;

import br.com.streamsoft.framework.base.entity.BaseEntity;
import br.com.streamsoft.framework.base.form.FormColumn;
import br.com.streamsoft.framework.base.rest.BaseREST;
import br.com.streamsoft.framework.form.generator.FormField;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Fernando on 28/12/2014.
 */
public abstract class BaseFormRest<T extends BaseEntity> extends BaseREST
{

	@Inject
	private Logger log;

	@GET
	@Path("/getFilter")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * TODO escrever o json que devolvera os campos de filtro
	 *
	 * */
	public List<FormField> getFilter()
	{

		return null;
	}

	@GET
	@Path("/getForm")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * FIXME finalizar a logica de montar campos
	 * FIXME fazer a logica do campo auto e os demais
	 * FIXME criar metodos para montar os campos privados facilitando chamar a logica
	 *
	 * */
	public List<FormField> getForm() throws Exception
	{
		// make form
		List<FormField> formFields = new ArrayList<FormField>();

		Class current = getEntityClass();

		log.info("currentClass=" + current.getName());

		for (Field field : current.getDeclaredFields())
		{
			log.info("field=" + field);

			// teste
			for (Annotation an : field.getDeclaredAnnotations())
			{
				log.info("Annotation=" + an.toString());
			}

			if (field.isAnnotationPresent(FormColumn.class))
			{
				log.info("field=" + field);

				// pega as informações da anotação
				FormColumn fieldInfoAnnotation = field
						.getAnnotation(FormColumn.class);

				log.info(fieldInfoAnnotation.toString());

				FormField formField = new FormField();
				formField.setKey(field.getName());
				formField.setDescription(fieldInfoAnnotation.description());
				formField.setLabel(fieldInfoAnnotation.label());

				formField.setDisabled(fieldInfoAnnotation.disabled());

				log.info("TYPE=" + field.getType().getTypeName());

				// types by annotation
				//if (field.isAnnotationPresent(org.hibernate.validator.constraints.Email.class)) {}

				// type by class
				if (field.getType().getTypeName().equals("java.lang.String"))
				{
					makeTextField(formField);
				}
				else if (field.getType().getTypeName().equals("java.lang.Long"))
				{
					makeNumberField(formField);
				}

				// check JPA annotations for number
				// logicas para validar tamanho do campo

				if (field.isAnnotationPresent(Size.class))
				{
					Size size = field.getAnnotation(Size.class);
					formField.setMax(Long.valueOf(size.max()));
					formField.setMin(Long.valueOf(size.min()));
				}
				else
				{
					if (field.isAnnotationPresent(Min.class))
					{
						Min min = field.getAnnotation(Min.class);
						formField.setMin(min.value());
					}
					if (field.isAnnotationPresent(Max.class))
					{
						Max max = field.getAnnotation(Max.class);
						formField.setMax(max.value());
					}
				}

				formFields.add(formField);
			}
		}
		// finish

		log.info("formFields = " + formFields.toString());

		return formFields;
	}

	/**
	 * Cria campo do tipo text
	 */
	private FormField makeTextField(FormField formField)
	{
		log.info("text");
		formField.setType("text");

		return formField;
	}

	/**
	 * Cria campo do tipo text
	 */
	private FormField makeNumberField(FormField formField)
	{
		log.info("number");
		formField.setType("number");

		return formField;
	}

	/**
	 * get Entity Class Type
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class<T> getEntityClass()
	{

		if (getClass().getGenericSuperclass() instanceof ParameterizedType)
		{
			return (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		else if (getClass().getGenericSuperclass() instanceof Class)
		{
			Class c = (Class) getClass().getGenericSuperclass();
			return (Class<T>) ((ParameterizedType) c.getGenericSuperclass())
					.getActualTypeArguments()[0];
		}

		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
