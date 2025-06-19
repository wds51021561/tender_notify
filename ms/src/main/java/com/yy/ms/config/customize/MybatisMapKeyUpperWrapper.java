package com.yy.ms.config.customize;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

public class MybatisMapKeyUpperWrapper extends MapWrapper {

	public MybatisMapKeyUpperWrapper(MetaObject metaObject, Map map) {
		super(metaObject, map);
	}

	@Override
	public String findProperty(String name, boolean useCamelCaseMapping) {
		return name == null ? "" : name.toUpperCase();
	}

}