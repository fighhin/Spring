/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * DomainSupport
 *
 * @author: levis
 * @version: 2013-09-26
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 7293660884152874422L;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE) {
            /*null field not output*/
            protected boolean accept(Field f) {
                try{
                    return super.accept(f) && getValue(f)!=null;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            }
        }.toString();
    }
}
