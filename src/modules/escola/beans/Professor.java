package modules.escola.beans;

import modules.escola.dao.TurmaDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Professor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 80, unique = true, nullable = false)
	private String nome;

	@Column(nullable = false, unique = true, length = 10)
	private String matricula;

	@Column(nullable = false, length = 80)
	private String graduacao;

	@OneToMany(mappedBy = "professor")
	private List<Turma> turmasResponsaveis;

	public Professor() {
	}

	public Professor(String nome, String matricula, String graduacao) {
		this.nome = nome;
		this.matricula = matricula;
		this.graduacao = graduacao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public void setTurmasResponsaveis(List<Turma> turmasResponsaveis) {
			this.turmasResponsaveis = turmasResponsaveis;
	}

	public int getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}
	public String getGraduacao() {
		return graduacao;
	}

	public String getNome() {
		return nome;
	}

	public List<Turma> getTurmasResponsaveis() {
		return TurmaDao.listByTurmaId(this.getId());
	}

}
