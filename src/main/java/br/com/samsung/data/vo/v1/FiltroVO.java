package br.com.samsung.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

public class FiltroVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numeroDocumento;
	private String tipoMoeda;
	private Date dataInicio;
	private Date dataFim;

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the tipoMoeda
	 */
	public String getTipoMoeda() {
		return tipoMoeda;
	}

	/**
	 * @param tipoMoeda the tipoMoeda to set
	 */
	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim the dataFim to set
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
		result = prime * result + ((tipoMoeda == null) ? 0 : tipoMoeda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiltroVO other = (FiltroVO) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		if (tipoMoeda == null) {
			if (other.tipoMoeda != null)
				return false;
		} else if (!tipoMoeda.equals(other.tipoMoeda))
			return false;
		return true;
	}
}
