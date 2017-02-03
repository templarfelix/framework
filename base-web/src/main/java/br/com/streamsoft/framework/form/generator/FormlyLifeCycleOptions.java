package br.com.streamsoft.framework.form.generator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by felix on 24/01/2017.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FormlyLifeCycleOptions implements Serializable {

    //onInit?: FormlyLifeCycleFn;
    //onChanges?: FormlyLifeCycleFn;
    //doCheck?: FormlyLifeCycleFn;
    //afterContentInit?: FormlyLifeCycleFn;
    //afterContentChecked?: FormlyLifeCycleFn;
    //afterViewInit?: FormlyLifeCycleFn;
    //afterViewChecked?: FormlyLifeCycleFn;
    //onDestroy?: FormlyLifeCycleFn;
}
