package com.uisrael.karateika.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAlumnoUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.IAscensoUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.IAsistenciaUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.ICinturonUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.IComprobanteUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.IPagosUseCase;
import com.uisrael.karateika.aplicacion.casouso.impl.AlumnoUseCaseImpl;
import com.uisrael.karateika.aplicacion.casouso.impl.AscensoUseCaseImpl;
import com.uisrael.karateika.aplicacion.casouso.impl.AsistenciaUseCaseImpl;
import com.uisrael.karateika.aplicacion.casouso.impl.CinturonUseCaseImpl;
import com.uisrael.karateika.aplicacion.casouso.impl.ComprobanteUseCaseImpl;
import com.uisrael.karateika.aplicacion.casouso.impl.PagosUseCaseImpl;
import com.uisrael.karateika.dominio.repositorios.IAlumnoRepositorio;
import com.uisrael.karateika.dominio.repositorios.IAscensoRepositorio;
import com.uisrael.karateika.dominio.repositorios.IAsistenciaRepositorio;
import com.uisrael.karateika.dominio.repositorios.ICinturonRepositorio;
import com.uisrael.karateika.dominio.repositorios.IComprobanteRepositorio;
import com.uisrael.karateika.dominio.repositorios.IPagosRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.AlumnoRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.AscensoRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.AsistenciaRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.CinturonRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.ComprobanteRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.adapadores.PagosRepositorioImpl;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAlumnoJpaMapper;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAscensoJpaMapper;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAsistenciaJpaMapper;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.ICinturonJpaMapper;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IComprobanteJpaMapper;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IPagosJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IAlumnoJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.IAscensoJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.IAsistenciaJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.ICinturonJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.IComprobanteJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.IPagosJpaRepositorio;

@Configuration
public class ConfiguracionGeneral {
	
	@Bean
	IAlumnoUseCase alumnoUseCase(IAlumnoRepositorio repositorio) {
		return new AlumnoUseCaseImpl(repositorio);
	}
	@Bean
	IAscensoUseCase ascensoUseCase(IAscensoRepositorio repositorio) {
		return new AscensoUseCaseImpl(repositorio);
	}
	@Bean
	ICinturonUseCase cinturonUseCase(ICinturonRepositorio repositorio) {
		return new CinturonUseCaseImpl(repositorio);
	}
	@Bean
	IComprobanteUseCase comprobanteUseCase(IComprobanteRepositorio repositorio) {
		return new ComprobanteUseCaseImpl(repositorio);
	}
	@Bean
	IPagosUseCase pagosUseCase(IPagosRepositorio repositorio) {
		return new PagosUseCaseImpl(repositorio);
	}
	@Bean
	IAsistenciaUseCase asistenteUseCase(IAsistenciaRepositorio repositorio) {
		return new AsistenciaUseCaseImpl(repositorio);
	}
	
	@Bean
	IAlumnoRepositorio alumnoRepositorio(IAlumnoJpaRepositorio jpaRepositorio, IAlumnoJpaMapper mapper) {
		return new AlumnoRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IAscensoRepositorio ascensoRepositorio(IAscensoJpaRepositorio jpaRepositorio, IAscensoJpaMapper mapper) {
		return new AscensoRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	ICinturonRepositorio cinturonRepositorio(ICinturonJpaRepositorio jpaRepositorio, ICinturonJpaMapper mapper) {
		return new CinturonRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IComprobanteRepositorio comprobanteRepositorio(IComprobanteJpaRepositorio jpaRepositorio, IComprobanteJpaMapper mapper) {
		return new ComprobanteRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IPagosRepositorio pagosRepositorio(IPagosJpaRepositorio jpaRepositorio, IPagosJpaMapper mapper) {
		return new PagosRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IAsistenciaRepositorio asistenciaRepositorio(IAsistenciaJpaRepositorio jpaRepositorio, IAsistenciaJpaMapper mapper) {
		return new AsistenciaRepositorioImpl(jpaRepositorio, mapper);
	}
}
