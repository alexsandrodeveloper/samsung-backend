package br.com.samsung.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.samsung.data.vo.v1.CurrencyVO;
import br.com.samsung.data.vo.v1.FiltroVO;
import br.com.samsung.data.vo.v1.ResultadoVO;
import br.com.samsung.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Currency Endpoint", tags = "CurrencyEndpoint")
@RestController
@RequestMapping(value = "/api/evaluation/v1")
public class CurrencyController {

	@Autowired
	private CurrencyService services;

	@ApiOperation(value = "Find all currencies record")
	@GetMapping(value = "/currency", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CurrencyVO> findAll() {
		List<CurrencyVO> listCurrencyVO = this.services.findCurrencies();
		return listCurrencyVO;
	}

	@ApiOperation(value = "Find all result record")
	@GetMapping(value = "/resultados", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ResultadoVO> findAllResultados() {
		List<ResultadoVO> listCurrencyVO = this.services.filtrarPorCriterios(new FiltroVO());
		return listCurrencyVO;
	}

	@ApiOperation(value = "Buscar por filtro")
	@GetMapping(value = "/resultados/filtrar" , consumes = {"application/json", "application/xml", "application/x-yaml"}
											  , produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ResultadoVO> filtrarResultados(@RequestParam("numeroDocumento") String numeroDocumento
			  								   ,@RequestParam("tipoMoeda") String tipoMoeda
			  								   ,@RequestParam("dataInicio") String dataInicio
			  								   ,@RequestParam("dataFim") String dataFim) {

		FiltroVO filtroVO = new FiltroVO();
		filtroVO.setNumeroDocumento(numeroDocumento.equals("null") ? null : numeroDocumento);
		filtroVO.setTipoMoeda(tipoMoeda.equals("null") ? null : tipoMoeda);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date dtinicio = dataInicio.equals("null") ? null : format.parse(dataInicio);
			filtroVO.setDataInicio(dtinicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		try {
			Date dtFim = dataFim.equals("null") ? null : format.parse(dataFim);
			filtroVO.setDataFim(dtFim);
		} catch (ParseException e) {
			e.printStackTrace();
		}		

		List<ResultadoVO> resultados = this.services.filtrarPorCriterios(filtroVO);
		return resultados;
	}

//	@ApiOperation(value = "Find all documents currency records")
//	@GetMapping(value = "/docs" ,produces = {"application/json", "application/xml", "application/x-yaml" })
//	public List<DocumentCurrencyVO> findAllDocumentsCurrency() {
//		List<DocumentCurrencyVO> listDocumentCurrencyVO = this.services.findDocumentsCurrency();
//		return listDocumentCurrencyVO;
//	}
//
//	@ApiOperation(value = "Find all cotacoes currency records")
//	@GetMapping(value = "/quotation" ,produces = { "application/json", "application/xml", "application/x-yaml" })
//	public List<CotacaoCurrencyVO> findAllCotacoesCurrency() {
//		List<CotacaoCurrencyVO> listCotacaoCurrencyVO = this.services.findCotacoesCurrency();
//		return listCotacaoCurrencyVO;
//	}
}
