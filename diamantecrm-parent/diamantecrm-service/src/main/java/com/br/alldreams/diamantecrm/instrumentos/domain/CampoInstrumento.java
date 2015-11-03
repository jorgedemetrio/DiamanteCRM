/**
 *
 */
package com.br.alldreams.diamantecrm.instrumentos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.alldreams.diamantecrm.usuario.domain.StatusInformacaoEnum;
import com.br.alldreams.diamantecrm.usuario.domain.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 03/11/2015 18:40:42
 */
@Entity
@Table(name = "tb_campos_instrumentos")
public class CampoInstrumento implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6176796831522911573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_instrumento", insertable = true, updatable = false, nullable = false)
	private Instrumento instrumento;

	// ************************* CONTROLE

	@Column(name = "token", insertable = true, updatable = false, unique = true, nullable = false, length = 100)
	private String token;

	@Column(name = "dt_criado", insertable = true, updatable = true, unique = false, nullable = false)
	private Date criado;

	@Column(name = "dt_alterado", insertable = true, updatable = true, unique = false, nullable = true)
	private Date alterado;

	@ManyToOne
	@JoinColumn(name = "criador", insertable = true, updatable = true, unique = false, nullable = false)
	private Usuario criador;

	@ManyToOne
	@JoinColumn(name = "alterador", insertable = true, updatable = true, unique = false, nullable = false)
	private Usuario alterador;

	@Column(name = "alterador", insertable = true, updatable = true, unique = false, nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private StatusInformacaoEnum status;

	@Column(name = "host_ip_criador", insertable = true, updatable = true, unique = false, nullable = false, length = 30)
	private String ipCriado;

	@Column(name = "host_ip_alterador", insertable = true, updatable = true, unique = false, nullable = true, length = 30)
	private String ipAlterado;

	@Column(name = "versao", insertable = true, updatable = true, unique = false, nullable = true)
	private Integer versao;
}
