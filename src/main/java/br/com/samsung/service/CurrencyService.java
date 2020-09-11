package br.com.samsung.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.samsung.data.vo.v1.CotacaoCurrencyVO;
import br.com.samsung.data.vo.v1.CurrencyVO;
import br.com.samsung.data.vo.v1.DocumentCurrencyVO;
import br.com.samsung.data.vo.v1.FiltroVO;
import br.com.samsung.data.vo.v1.ResultadoVO;
import br.com.samsung.enums.CurrencyEnum;

@Service
public class CurrencyService {

	private RestTemplate restTemplate = new RestTemplate();
	private List<CurrencyVO> currencies = new ArrayList<CurrencyVO>();

	public List<CurrencyVO> findCurrencies() {

		if (currencies.isEmpty()) {
			ResponseEntity<List<CurrencyVO>> currencyResponse = restTemplate.exchange(
					"https://cellolatam.cellologistics.com.br/sds-devs-evaluation/evaluation/currency", HttpMethod.GET,
					null, new ParameterizedTypeReference<List<CurrencyVO>>() {
					});

			this.currencies = currencyResponse.getBody();
		}

		return this.currencies;
	}

	private List<CotacaoCurrencyVO> findCotacoesCurrency() {

		ResponseEntity<List<CotacaoCurrencyVO>> cotacaoResponse = restTemplate.exchange(
				"https://cellolatam.cellologistics.com.br/sds-devs-evaluation/evaluation/quotation", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<CotacaoCurrencyVO>>() {
				});
		List<CotacaoCurrencyVO> cotacoes = cotacaoResponse.getBody();

		return cotacoes;
	}

	private List<DocumentCurrencyVO> findDocumentsCurrency() {

		ResponseEntity<List<DocumentCurrencyVO>> documentResponse = restTemplate.exchange(
				"https://cellolatam.cellologistics.com.br/sds-devs-evaluation/evaluation/docs", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<DocumentCurrencyVO>>() {
				});
		List<DocumentCurrencyVO> documents = documentResponse.getBody();

		return documents;
	}

	public List<ResultadoVO> filtrarPorCriterios(FiltroVO filtro) {

		List<ResultadoVO> resultadosFiltrados = new ArrayList<ResultadoVO>();

		if ((filtro.getNumeroDocumento() != null && !"".equals(filtro.getNumeroDocumento())
				|| filtro.getTipoMoeda() != null && !"".equals(filtro.getTipoMoeda())
				|| (filtro.getDataInicio() != null) || filtro.getDataFim() != null)) {

			for (ResultadoVO resultado : buscarListaResultadoVO()) {

				if (filtro.getNumeroDocumento() != null && !"".equals(filtro.getNumeroDocumento())) {
					if (resultado.getDocumentNumber().equals(filtro.getNumeroDocumento())) {
						if (filtro.getTipoMoeda() != null && !"".equals(filtro.getTipoMoeda())) {
							if (resultado.getCurrencyCode().equals(filtro.getTipoMoeda())) {
								if (filtro.getDataInicio() != null && filtro.getDataFim() != null) {
									if (resultado.getDocumentDate().equals(filtro.getDataInicio())
											|| resultado.getDocumentDate().after(filtro.getDataInicio())
											|| resultado.getDocumentDate().before(filtro.getDataFim())) {
										resultadosFiltrados.add(resultado);
									}
								} else if (filtro.getDataInicio() != null) {
									if (resultado.getDocumentDate().equals(filtro.getDataInicio())
											|| resultado.getDocumentDate().after(filtro.getDataInicio())) {
										resultadosFiltrados.add(resultado);
									}
								} else if (filtro.getDataFim() != null) {
									if (resultado.getDocumentDate().before(filtro.getDataFim())
											|| resultado.getDocumentDate().equals(filtro.getDataFim())) {
										resultadosFiltrados.add(resultado);
									}
								}
							}
						} else if (filtro.getDataInicio() != null && filtro.getDataFim() != null) {
							if (resultado.getDocumentDate().equals(filtro.getDataInicio())
									|| resultado.getDocumentDate().after(filtro.getDataInicio())
									|| resultado.getDocumentDate().before(filtro.getDataFim())) {
								resultadosFiltrados.add(resultado);
							}
						} else if (filtro.getDataInicio() != null) {
							if (resultado.getDocumentDate().equals(filtro.getDataInicio())
									|| resultado.getDocumentDate().after(filtro.getDataInicio())) {
								resultadosFiltrados.add(resultado);
							}
						} else if (filtro.getDataFim() != null) {
							if (resultado.getDocumentDate().before(filtro.getDataFim())
									|| resultado.getDocumentDate().equals(filtro.getDataFim())) {
								resultadosFiltrados.add(resultado);
							}
						}

						resultadosFiltrados.add(resultado);
					}
				} else if (filtro.getTipoMoeda() != null && !"".equals(filtro.getTipoMoeda())) {
					if (resultado.getCurrencyCode().equals(filtro.getTipoMoeda())) {
						if (filtro.getDataInicio() != null && filtro.getDataFim() != null) {
							if (resultado.getDocumentDate().equals(filtro.getDataInicio())
									|| resultado.getDocumentDate().after(filtro.getDataInicio())
									|| resultado.getDocumentDate().before(filtro.getDataFim())) {
								resultadosFiltrados.add(resultado);
							}
						} else if (filtro.getDataInicio() != null) {
							if (resultado.getDocumentDate().equals(filtro.getDataInicio())
									|| resultado.getDocumentDate().after(filtro.getDataInicio())) {
								resultadosFiltrados.add(resultado);
							}
						} else if (filtro.getDataFim() != null) {
							if (resultado.getDocumentDate().before(filtro.getDataFim())
									|| resultado.getDocumentDate().equals(filtro.getDataFim())) {
								resultadosFiltrados.add(resultado);
							}
						}
						resultadosFiltrados.add(resultado);
					}
				} else if (filtro.getDataInicio() != null && filtro.getDataFim() != null) {
					if ((resultado.getDocumentDate().equals(filtro.getDataInicio()))
							|| (resultado.getDocumentDate().equals(filtro.getDataFim()))
							|| (resultado.getDocumentDate().after(filtro.getDataInicio())
									&& resultado.getDocumentDate().before(filtro.getDataFim()))) {
						resultadosFiltrados.add(resultado);
					}
				} else if (filtro.getDataInicio() != null) {
					if (resultado.getDocumentDate().equals(filtro.getDataInicio())) {
						resultadosFiltrados.add(resultado);
					}
				} else if (filtro.getDataFim() != null) {
					if (resultado.getDocumentDate().equals(filtro.getDataFim())) {
						resultadosFiltrados.add(resultado);
					}
				}
			}

			return resultadosFiltrados;
		}
		return buscarListaResultadoVO();
	}

	private List<ResultadoVO> buscarListaResultadoVO() {

		List<ResultadoVO> resultados = new ArrayList<ResultadoVO>();

		for (DocumentCurrencyVO documento : findDocumentsCurrency()) {

			List<CotacaoCurrencyVO> cotacoes = getCotacoesCurrencyByDocument(documento);

			ResultadoVO resultado = criarResultadoParcial(documento);

			Double vlCotacaoUSD = null;
			Double vlCotacaoPEN = null;
			Double vlCotacaoBRL = null;

			for (CotacaoCurrencyVO cotacao : cotacoes) {

				if (cotacao.getToCurrencyCode().equals(CurrencyEnum.USD.name())) {
					vlCotacaoUSD = documento.getDocumentValue() * cotacao.getCotacao();
				} else if (cotacao.getToCurrencyCode().equals(CurrencyEnum.PEN.name())) {
					vlCotacaoPEN = documento.getDocumentValue() * cotacao.getCotacao();
				} else if (cotacao.getToCurrencyCode().equals(CurrencyEnum.BRL.name())) {
					vlCotacaoBRL = documento.getDocumentValue() * cotacao.getCotacao();
				}
			}

			if (!cotacoes.isEmpty()) {
				resultado.setCotacaoToCurrencyCodeUSD(
						vlCotacaoUSD != null ? formatarValor(vlCotacaoUSD) : documento.getDocumentValue());
				resultado.setCotacaoToCurrencyCodePEN(
						vlCotacaoPEN != null ? formatarValor(vlCotacaoPEN) : documento.getDocumentValue());
				resultado.setCotacaoToCurrencyCodeBRL(
						vlCotacaoBRL != null ? formatarValor(vlCotacaoBRL) : documento.getDocumentValue());
			}

			resultados.add(resultado);

		}
		return resultados;
	}

	private List<CotacaoCurrencyVO> getCotacoesCurrencyByDocument(DocumentCurrencyVO documento) {

		List<CotacaoCurrencyVO> cotacoes = new ArrayList<CotacaoCurrencyVO>();

		for (CotacaoCurrencyVO cotacao : findCotacoesCurrency()) {

			if (cotacao.getDataHoraCotacao().equals(documento.getDocumentDate())
					&& cotacao.getFromCurrencyCode().equals(documento.getCurrencyCode())) {
				cotacoes.add(cotacao);
			}
		}

		return cotacoes;
	}

	private ResultadoVO criarResultadoParcial(DocumentCurrencyVO documento) {

		ResultadoVO resultado = new ResultadoVO();

		resultado.setDocumentNumber(documento.getDocumentNumber().toString());
		resultado.setCurrencyDesc(CurrencyEnum.valueOfTipo(documento.getCurrencyCode()).getDescricao());
		resultado.setCurrencyCode(documento.getCurrencyCode());
		resultado.setDocumentDate(documento.getDocumentDate());
		resultado.setDocumentValue(documento.getDocumentValue());

		return resultado;
	}

	private Double formatarValor(Double valor) {

		DecimalFormat format = new DecimalFormat("#0.00");

		String numberFormatado = format.format(valor).replace(",", ".");

		return Double.parseDouble(numberFormatado);
	}
}
