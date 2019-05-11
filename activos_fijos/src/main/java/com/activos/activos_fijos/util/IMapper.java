package com.activos.activos_fijos.util;

public interface IMapper<T, V> {

	T aDto(V a);

	V aEntity(T a);

}
