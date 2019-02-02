package com.antoniomarciocs.sistprodv1.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sistemas")
public class SistemaProducaoResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest Funcionando";
	}
}
