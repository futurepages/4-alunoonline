package modules.escola.beans;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Aluno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 10, unique = true, nullable = false)
	private String matricula;

    @Column(nullable = false)
	private String nome;

    @ManyToOne
    private Turma turma;

	public Aluno() {
	}

	public Aluno(String matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

    public Aluno(String matricula, String nome, Turma turma) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
